package jpuppeteer.cdp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.ValueFilter;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketClientCompressionHandler;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import jpuppeteer.cdp.client.CDPEventType;
import jpuppeteer.cdp.client.domain.Runtime;
import jpuppeteer.cdp.client.domain.*;
import jpuppeteer.util.CDPEnumFilter;
import jpuppeteer.util.CDPException;
import jpuppeteer.util.CDPParserConfig;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.nio.channels.ClosedChannelException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

@SuppressWarnings("unchecked")
public abstract class CDPConnection {

    private static final Logger logger = LoggerFactory.getLogger(CDPConnection.class);

    private static final ValueFilter CDP_ENUM_SERIALIZE_FILTER = new CDPEnumFilter();

    private static final ParserConfig CDP_PARSER_CONFIG = new CDPParserConfig();

    private static final String WS = "ws";

    protected static final String ID = "id";

    protected static final String METHOD = "method";

    protected static final String PARAMS = "params";

    protected static final String ERROR = "error";

    protected static final String RESULT = "result";

    private final EventLoop eventLoop;

    private final URI uri;

    private final Channel channel;

    private final Promise connectFuture;

    private final Map<Integer, Promise<JSONObject>> promiseMap;

    //domains
    public final Browser browser;

    public final DOM dom;

    public final Emulation emulation;

    public final Fetch fetch;

    public final Input input;

    public final jpuppeteer.util.Input inputWrapper;

    public final Network network;

    public final Page page;

    public final Runtime runtime;

    public final Target target;

    public final Storage storage;

    public CDPConnection(EventLoop eventLoop, AtomicInteger messageIdGen, URI uri) {
        this.eventLoop = eventLoop;
        this.uri = uri;
        this.promiseMap = new ConcurrentHashMap<>();
        this.browser = new Browser(this);
        this.dom = new DOM(this);
        this.emulation = new Emulation(this);
        this.fetch = new Fetch(this);
        this.input = new Input(this);
        this.inputWrapper = new jpuppeteer.util.Input(this.input, eventLoop);
        this.network = new Network(this);
        this.page = new Page(this);
        this.runtime = new Runtime(this);
        this.target = new Target(this);
        this.storage = new Storage(this);
        this.connectFuture = eventLoop.newPromise();
        this.channel = open().channel();
    }

    public CDPConnection(EventLoop eventLoop, URI uri) {
        this(eventLoop, new AtomicInteger(0), uri);
    }

    abstract protected int genId();

    abstract protected void onEvent(CDPEvent event);

    private ChannelFuture open() {
        String scheme = uri.getScheme() == null ? WS : uri.getScheme();
        if (!scheme.equals(WS)) {
            throw new RuntimeException("Unsupported protocol: " + scheme);
        }
        Bootstrap b = new Bootstrap();
        ChannelFuture channelFuture = b.group(eventLoop)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 30000)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.SO_LINGER, 3)
                .option(ChannelOption.SO_REUSEADDR, true)
                .option(ChannelOption.AUTO_CLOSE, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) {
                        ChannelPipeline p = ch.pipeline();
                        p.addLast(
                                new HttpClientCodec(),
                                new HttpObjectAggregator(8192),
                                new Handshake());
                    }
                })
                .connect(uri.getHost(), uri.getPort())
                .addListener(f -> {
                    if (f.cause() != null) {
                        connectFuture.tryFailure(f.cause());
                    }
                });
        return channelFuture;
    }

    public boolean isClosed() {
        return !(channel.isOpen() && channel.isActive());
    }

    public Future close() {
        connectFuture.cancel(true);
        return channel.close();
    }

    private Future<JSONObject> send0(String method, Object params) {
        JSONObject json = new JSONObject();
        int id = genId();
        json.put(ID, id);
        json.put(METHOD, method);
        json.put(PARAMS, params);

        String jsonStr = JSON.toJSONString(json, CDP_ENUM_SERIALIZE_FILTER);

        if (logger.isDebugEnabled()) {
            logger.debug("[{}] ==> send message={}", uri.getPath(), jsonStr);
        }

        Promise<JSONObject> promise = new DefaultPromise<>(eventLoop);
        promiseMap.put(id, promise);
        TextWebSocketFrame frame = new TextWebSocketFrame(jsonStr);
        connectFuture.addListener(f -> {
            if (f.isCancelled()) {
                promise.tryFailure(new Exception("Connection canceled"));
            } else if (f.cause() != null) {
                promise.tryFailure(f.cause());
            } else {
                channel.writeAndFlush(frame).addListener(f1 -> {
                    if (f1.cause() != null) {
                        promise.tryFailure(f1.cause());
                    }
                });
            }
        });
        promise.addListener(f -> {
            if (f.isCancelled()) {
                logger.debug("future cancelled, id={}", id);
                promiseMap.remove(id);
            }
        });
        return promise;
    }

    public <T> Future<T> send(String method, Object params, Function<String, T> function) {
        Promise<T> promise = new DefaultPromise<>(eventLoop);
        send0(method, params).addListener(f -> {
            if (f.cause() != null) {
                promise.tryFailure(f.cause());
            } else {
                try {
                    String jsonStr = JSON.toJSONString(f.getNow());
                    T result = function.apply(jsonStr);
                    promise.trySuccess(result);
                } catch (Throwable cause) {
                    promise.tryFailure(cause);
                }
            }
        });
        return promise;
    }

    public final Future send(String method, Object params) {
        return send0(method, params);
    }

    public final <T> Future<T> send(String method, Object params, Class<T> clazz) {
        return send(method, params, o -> JSON.parseObject(o, clazz, CDP_PARSER_CONFIG));
    }

    private class Handshake extends SimpleChannelInboundHandler<FullHttpResponse> {

        private final WebSocketClientHandshaker handshake;

        public Handshake() {
            this.handshake = WebSocketClientHandshakerFactory.newHandshaker(
                    uri, WebSocketVersion.V13, null,
                    true, new DefaultHttpHeaders(),
                    8 * 1024 * 1024);
        }

        @Override
        public void channelActive(ChannelHandlerContext ctx) {
            handshake.handshake(ctx.channel()).addListener(f -> {
                if (f.cause() != null) {
                    connectFuture.tryFailure(f.cause());
                    ctx.close();
                }
            });
        }

        @Override
        protected void channelRead0(ChannelHandlerContext ctx, FullHttpResponse msg) throws Exception {
            Channel ch = ctx.channel();
            try {
                handshake.finishHandshake(ch, msg);
                ctx.pipeline().remove(this);
                ctx.pipeline().addLast(WebSocketClientCompressionHandler.INSTANCE);
                ctx.pipeline().addLast(new ClientHandler());
                connectFuture.trySuccess(null);
            } catch (WebSocketHandshakeException e) {
                connectFuture.tryFailure(e);
                ctx.close();
            }
        }

        @Override
        public void channelInactive(ChannelHandlerContext ctx) throws Exception {
            connectFuture.tryFailure(new ClosedChannelException());
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            ctx.close();
        }
    }

    private class ClientHandler extends SimpleChannelInboundHandler<WebSocketFrame> {

        @Override
        public void channelRead0(ChannelHandlerContext ctx, WebSocketFrame frame) throws Exception {
            if (frame instanceof TextWebSocketFrame) {
                TextWebSocketFrame textFrame = (TextWebSocketFrame) frame;
                String message = textFrame.text();
                logger.debug("[{}] <== recv message={}", uri.getPath(), message);
                JSONObject json = JSON.parseObject(message);
                String methodName = json.getString(METHOD);
                if (StringUtils.isNotEmpty(methodName)) {
                    //这种格式的就是event notification
                    CDPEventType eventType = CDPEventType.findByName(methodName);
                    if (eventType == null) {
                        logger.warn("Unknown event: {}", message);
                        return;
                    }
                    String paramsString = JSON.toJSONString(json.get(PARAMS));
                    CDPEvent event = new CDPEvent(
                            eventType,
                            JSON.parseObject(paramsString, eventType.getClazz(), CDP_PARSER_CONFIG)
                    );
                    onEvent(event);
                    return;
                }
                if (!json.containsKey(ID)) {
                    //没有ID就是异常的返回
                    throw new IllegalArgumentException("attribute \"id\" can not be null");
                }
                Integer id = json.getInteger(ID);
                Promise<JSONObject> promise = promiseMap.remove(id);
                if (promise == null) {
                    logger.warn("can not found promise, drop message id={}", id);
                    return;
                }
                if (json.containsKey(ERROR)) {
                    JSONObject error = json.getJSONObject(ERROR);
                    String errorMsg = error.getString("message");
                    String errorData = error.getString("data");
                    if (StringUtils.isNotEmpty(errorData)) {
                        errorMsg += "(" + errorData + ")";
                    }
                    promise.tryFailure(new CDPException(error.getIntValue("code"), errorMsg));
                } else {
                    promise.trySuccess(json.getJSONObject(RESULT));
                }
            } else if (frame instanceof CloseWebSocketFrame) {
                ctx.close();
            }
        }

    }

}
