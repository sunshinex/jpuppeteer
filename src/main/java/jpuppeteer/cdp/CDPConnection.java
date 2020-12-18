package jpuppeteer.cdp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.ValueFilter;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketClientCompressionHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.concurrent.Promise;
import jpuppeteer.api.event.AbstractEventEmitter;
import jpuppeteer.api.event.AbstractListener;
import jpuppeteer.cdp.client.CDPEnum;
import jpuppeteer.cdp.client.CDPEventType;
import jpuppeteer.cdp.client.constant.accessibility.AXPropertyName;
import jpuppeteer.cdp.client.constant.accessibility.AXValueType;
import jpuppeteer.cdp.client.entity.accessibility.AXProperty;
import jpuppeteer.cdp.client.entity.accessibility.AXValue;
import jpuppeteer.util.CDPEnumFilter;
import jpuppeteer.util.CDPException;
import jpuppeteer.util.CDPParserConfig;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLException;
import java.lang.reflect.Type;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.channels.ClosedChannelException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class CDPConnection extends AbstractEventEmitter<CDPEvent> {

    private static final Logger logger = LoggerFactory.getLogger(CDPConnection.class);

    private static final ValueFilter CDP_ENUM_SERIALIZE_FILTER = new CDPEnumFilter();

    private static final ParserConfig CDP_PARSER_CONFIG = new CDPParserConfig();

    private static final String WS = "ws";

    private static final String WSS = "wss";

    protected static final String ID = "id";

    protected static final String METHOD = "method";

    protected static final String PARAMS = "params";

    protected static final String ERROR = "error";

    protected static final String RESULT = "result";

    private final URI uri;

    private final ChannelFuture channelFuture;

    private final AtomicInteger messageIdGen;

    private final Map<Integer, Promise<JSONObject>> promiseMap;

    public CDPConnection(String url) throws URISyntaxException, ProtocolException, SSLException {
        this.uri = new URI(url);
        this.channelFuture = open(uri);
        this.messageIdGen = new AtomicInteger(0);
        this.promiseMap = new ConcurrentHashMap<>();
    }

    @Override
    protected void emitInternal(AbstractListener<CDPEvent> listener, CDPEvent event) {
        EventLoop eventLoop = eventLoop();
        if (eventLoop.inEventLoop()) {
            listener.accept(event);
        } else {
            eventLoop().execute(() -> listener.accept(event));
        }
    }

    private ChannelFuture open(URI uri) throws ProtocolException, SSLException {
        String scheme = uri.getScheme() == null ? WS : uri.getScheme();
        if (!scheme.equals(WS) && !scheme.equals(WSS)) {
            throw new ProtocolException("Unsupported protocol: " + scheme);
        }
        String host = uri.getHost();
        int port = uri.getPort() != -1 ? uri.getPort() : WSS.equals(scheme) ? 443 : 80;
        boolean ssl = scheme.equals(WSS);
        SslContext sslContext;
        if (ssl) {
            sslContext = SslContextBuilder.forClient()
                    .trustManager(InsecureTrustManagerFactory.INSTANCE).build();
        } else {
            sslContext = null;
        }
        EventLoopGroup group = new NioEventLoopGroup(1, r -> {
            return new Thread(r, "Connection-" + host + ":" + port);
        });
        try {
            Promise shakePromise = new DefaultPromise<>(group.next());
            Bootstrap b = new Bootstrap();
            b.group(group)
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
                            if (sslContext != null) {
                                p.addLast(sslContext.newHandler(ch.alloc(), host, port));
                            }
                            p.addLast(
                                    new HttpClientCodec(),
                                    new HttpObjectAggregator(8192),
                                    new Handshaker(
                                            WebSocketClientHandshakerFactory.newHandshaker(
                                                    uri, WebSocketVersion.V13, null,
                                                    true, new DefaultHttpHeaders(), 8 * 1024 * 1024),
                                            shakePromise
                                    ));
                        }
                    });

            ChannelFuture connectFuture = b.connect(uri.getHost(), port);
            Channel channel = connectFuture.channel();
            ChannelPromise promise = channel.newPromise();
            connectFuture.addListener(f0 -> {
                //连接完成
                if (f0.cause() != null) {
                    promise.tryFailure(f0.cause());
                } else {
                    shakePromise.addListener(f1 -> {
                        //握手完成
                        if (f1.cause() != null) {
                            promise.tryFailure(f1.cause());
                        } else {
                            promise.trySuccess();
                        }
                    });
                }
            });
            return promise;
        } catch (Throwable cause){
            group.shutdownGracefully();
            throw cause;
        }
    }

    public Channel channel() {
        return channelFuture.channel();
    }

    public EventLoop eventLoop() {
        return channelFuture.channel().eventLoop();
    }

    public Future close() {
        Channel channel = channelFuture.channel();
        Promise<CDPConnection> promise = new DefaultPromise<>(GlobalEventExecutor.INSTANCE);
        channel.close().addListener(f0 -> {
            eventLoop().shutdownGracefully().addListener(f1 -> {
                Throwable cause = f0.cause() != null ? f0.cause() : f1.cause();
                if (cause != null) {
                    promise.tryFailure(cause);
                } else {
                    promise.trySuccess(this);
                }
            });
        });
        return promise;
    }

    private Future<JSONObject> send0(String method, Object params, Map<String, Object> extra) {
        JSONObject json = new JSONObject();
        int id = this.messageIdGen.getAndIncrement();
        //避免extra中的内容会覆盖ID, METHOD, PARAMS, 所以在前面先put进去
        if (extra != null && extra.size() > 0) {
            json.putAll(extra);
        }
        json.put(ID, id);
        json.put(METHOD, method);
        json.put(PARAMS, params);

        String jsonStr = JSON.toJSONString(json, CDP_ENUM_SERIALIZE_FILTER);

        if (logger.isDebugEnabled()) {
            logger.debug("==> send message={}", jsonStr);
        }

        Promise<JSONObject> promise = new DefaultPromise<>(eventLoop());
        promiseMap.put(id, promise);
        channelFuture.addListener(f0 -> {
            if (f0.cause() != null) {
                promise.tryFailure(f0.cause());
            } else {
                TextWebSocketFrame frame = new TextWebSocketFrame(jsonStr);
                channel().writeAndFlush(frame).addListener(f1 -> {
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

    public <T> Future<T> send(String method, Object params, Map<String, Object> extra, Function<String, T> function) {
        Promise<T> promise = new DefaultPromise<>(eventLoop());
        send0(method, params, extra).addListener(f -> {
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
        return send(method, params, null, o -> null);
    }

    public final Future send(String method, Object params, Map<String, Object> extra) {
        return send(method, params, extra, o -> null);
    }

    public final <T> Future<T> send(String method, Object params, Class<T> clazz) {
        return send(method, params, null, o -> JSON.parseObject(o, clazz, CDP_PARSER_CONFIG));
    }

    public final <T> Future<T> send(String method, Object params, Map<String, Object> extra, Class<T> clazz) {
        return send(method, params, extra, o -> JSON.parseObject(o, clazz, CDP_PARSER_CONFIG));
    }

    public CDPSession newSession(String targetId, String sessionId) {
        return new CDPSession(this, targetId, sessionId);
    }

    private class Handshaker extends SimpleChannelInboundHandler<FullHttpResponse> {

        private final WebSocketClientHandshaker handshaker;

        private final Promise promise;

        public Handshaker(WebSocketClientHandshaker handshaker, Promise promise) {
            this.handshaker = handshaker;
            this.promise = promise;
        }

        @Override
        public void channelActive(ChannelHandlerContext ctx) {
            handshaker.handshake(ctx.channel()).addListener(f -> {
                if (f.cause() != null) {
                    promise.tryFailure(f.cause());
                }
            });
        }

        @Override
        public void channelInactive(ChannelHandlerContext ctx) {
            promise.tryFailure(new ClosedChannelException());
        }

        @Override
        protected void channelRead0(ChannelHandlerContext ctx, FullHttpResponse msg) throws Exception {
            Channel ch = ctx.channel();
            try {
                handshaker.finishHandshake(ch, msg);
                ctx.pipeline().remove(this);
                ctx.pipeline().addLast(WebSocketClientCompressionHandler.INSTANCE);
                ctx.pipeline().addLast(new ClientHandler());
                promise.trySuccess(null);
            } catch (WebSocketHandshakeException e) {
                promise.tryFailure(e);
            }
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            promise.tryFailure(cause);
            ctx.close();
        }
    }

    private class ClientHandler extends SimpleChannelInboundHandler<WebSocketFrame> {

        @Override
        public void channelRead0(ChannelHandlerContext ctx, WebSocketFrame frame) throws Exception {
            if (frame instanceof TextWebSocketFrame) {
                TextWebSocketFrame textFrame = (TextWebSocketFrame) frame;
                String message = textFrame.text();
                logger.debug("<== recv message={}", message);
                JSONObject json = JSON.parseObject(message);
                String methodName = json.getString(METHOD);
                if (StringUtils.isNotEmpty(methodName)) {
                    //这种格式的就是event notification
                    CDPEventType method = CDPEventType.findByName(methodName);
                    if (message == null) {
                        logger.warn("Unknown event: {}", method);
                        return;
                    }
                    String params = json.getJSONObject(PARAMS).toJSONString();
                    CDPEvent event = new CDPEvent(
                            json.getString(CDPSession.SESSION_ID),
                            method,
                            JSON.parseObject(params, method.getClazz())
                    );
                    emit(event);
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
