package jpuppeteer.chrome;

import com.alibaba.fastjson.JSONObject;
import jpuppeteer.api.browser.Browser;
import jpuppeteer.api.browser.Cookie;
import jpuppeteer.api.event.EventEmitter;
import jpuppeteer.api.event.EventType;
import jpuppeteer.api.event.GenericEventEmitter;
import jpuppeteer.cdp.CDPConnection;
import jpuppeteer.cdp.CDPSession;
import jpuppeteer.cdp.WebSocketConnection;
import jpuppeteer.cdp.cdp.domain.Network;
import jpuppeteer.cdp.cdp.domain.Target;
import jpuppeteer.cdp.cdp.entity.browser.GetVersionResponse;
import jpuppeteer.cdp.cdp.entity.network.DeleteCookiesRequest;
import jpuppeteer.cdp.cdp.entity.network.GetAllCookiesResponse;
import jpuppeteer.cdp.cdp.entity.network.SetCookiesRequest;
import jpuppeteer.cdp.cdp.entity.target.*;
import jpuppeteer.cdp.constant.TargetType;
import jpuppeteer.chrome.event.BrowserEvent;
import jpuppeteer.chrome.util.CookieUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static jpuppeteer.cdp.cdp.CDPEventType.*;
import static jpuppeteer.chrome.event.BrowserEvent.*;

public class ChromeBrowser implements Browser {

    private static final Logger logger = LoggerFactory.getLogger(ChromeBrowser.class);

    private static final String DEFAULT_URL = "about:blank";

    public static final int DEFAULT_TIMEOUT = 30;

    private EventEmitter events;

    private CDPConnection connection;

    private ChromeContext defaultContext;

    private Process process;

    private jpuppeteer.cdp.cdp.domain.Browser browser;

    private Target target;

    private CDPSession defaultSession;

    private Network network;

    public ChromeBrowser(Process process, CDPConnection connection) throws Exception {
        connection.open();
        this.events = new GenericEventEmitter();
        this.process = process;
        this.connection = connection;
        this.browser = new jpuppeteer.cdp.cdp.domain.Browser(connection);
        this.target = new Target(connection);
        this.setDiscoverTargets(true);
        this.defaultContext = new ChromeContext(connection, this, null);
        //绑定事件
        connection.addListener(TARGET_TARGETCREATED, ev -> emit(TARGETCREATED, ev.getParams().toJavaObject(TARGETCREATED.eventClass())));
        connection.addListener(TARGET_TARGETINFOCHANGED, ev -> emit(TARGETINFOCHANGED, ev.getParams().toJavaObject(TARGETINFOCHANGED.eventClass())));
        connection.addListener(TARGET_TARGETDESTROYED, ev -> emit(TARGETDESTROYED, ev.getParams().toJavaObject(TARGETDESTROYED.eventClass())));
        connection.addListener(TARGET_TARGETCRASHED, ev -> emit(TARGETCRASHED, ev.getParams().toJavaObject(TARGETCRASHED.eventClass())));
        connection.addListener(TARGET_ATTACHEDTOTARGET, ev -> emit(ATTACHEDTOTARGET, ev.getParams().toJavaObject(ATTACHEDTOTARGET.eventClass())));
        connection.addListener(TARGET_DETACHEDFROMTARGET, ev -> emit(DETACHEDFROMTARGET, ev.getParams().toJavaObject(DETACHEDFROMTARGET.eventClass())));
        connection.addListener(TARGET_RECEIVEDMESSAGEFROMTARGET, ev -> emit(RECEIVEDMESSAGEFROMTARGET, ev.getParams().toJavaObject(RECEIVEDMESSAGEFROMTARGET.eventClass())));
        //找到默认的标签页
        String defaultTargetId = null;
        for(TargetInfo targetInfo : getTargets()) {
            TargetType targetType = TargetType.findByValue(targetInfo.getType());
            if (TargetType.PAGE.equals(targetType)) {
                defaultTargetId = targetInfo.getTargetId();
            }
        }
        //如果没有找到默认的标签页, 则创建一个
        if (defaultTargetId == null) {
            defaultTargetId = createTarget(null);
        }
        //给默认标签页附加devtools
        String sessionId = attachToTarget(defaultTargetId);
        defaultSession = new CDPSession(connection, TargetType.PAGE, sessionId);
        this.network = new Network(defaultSession);
    }

    private static <E> void checkEventType(EventType<E> eventType) {
        if (!(eventType instanceof BrowserEvent)) {
            throw new IllegalArgumentException("eventType必须是BrowserEvent的子类");
        }
    }

    @Override
    public <E> void addListener(EventType<E> eventType, Consumer<E> consumer) {
        checkEventType(eventType);
        events.addListener(eventType, consumer);
    }

    @Override
    public <E> void removeListener(EventType<E> eventType, Consumer<E> consumer) {
        checkEventType(eventType);
        events.removeListener(eventType, consumer);
    }

    @Override
    public <E> Future<E> await(EventType<E> eventType) {
        checkEventType(eventType);
        return events.await(eventType);
    }

    @Override
    public <E> Future<E> await(EventType<E> eventType, Predicate<E> predicate) {
        checkEventType(eventType);
        return events.await(eventType, predicate);
    }

    @Override
    public <E> void emit(EventType<E> eventType, E event) {
        checkEventType(eventType);
        events.emit(eventType, event);
    }

    /**
     * 只对已经存在的页面生效
     * @param autoAttach
     * @throws Exception
     */
    protected void setAutoAttach(boolean autoAttach) throws Exception {
        SetAutoAttachRequest request = new SetAutoAttachRequest();
        request.setAutoAttach(autoAttach);
        request.setFlatten(true);
        request.setWaitForDebuggerOnStart(false);
        this.target.setAutoAttach(request, DEFAULT_TIMEOUT);
    }

    protected void activateTarget(String targetId) throws Exception {
        ActivateTargetRequest request = new ActivateTargetRequest();
        request.setTargetId(targetId);
        target.activateTarget(request, DEFAULT_TIMEOUT);
    }

    protected String attachToTarget(String targetId) throws Exception {
        AttachToTargetRequest request = new AttachToTargetRequest();
        request.setTargetId(targetId);
        request.setFlatten(true);
        AttachToTargetResponse response = target.attachToTarget(request, DEFAULT_TIMEOUT);
        return response.getSessionId();
    }

    protected boolean closeTarget(String targetId) throws Exception {
        CloseTargetRequest request = new CloseTargetRequest();
        request.setTargetId(targetId);
        CloseTargetResponse response = target.closeTarget(request, DEFAULT_TIMEOUT);
        return response.getSuccess();
    }

    protected String createTarget(String browserContextId) throws Exception {
        CreateTargetRequest request = new CreateTargetRequest();
        request.setUrl(DEFAULT_URL);
        request.setBrowserContextId(browserContextId);
        CreateTargetResponse response = target.createTarget(request, DEFAULT_TIMEOUT);
        return response.getTargetId();
    }

    protected void detachFromTarget(String sessionId) throws Exception {
        DetachFromTargetRequest request = new DetachFromTargetRequest();
        request.setSessionId(sessionId);
        target.detachFromTarget(request, DEFAULT_TIMEOUT);
    }

    protected List<TargetInfo> getTargets() throws Exception {
        GetTargetsResponse response = target.getTargets(DEFAULT_TIMEOUT);
        return response.getTargetInfos();
    }

    protected void sendMessageToTarget(String sessionId, String message) throws Exception {
        SendMessageToTargetRequest request = new SendMessageToTargetRequest();
        request.setSessionId(sessionId);
        request.setMessage(message);
        target.sendMessageToTarget(request, DEFAULT_TIMEOUT);
    }

    protected void setDiscoverTargets(boolean discover) throws Exception {
        SetDiscoverTargetsRequest request = new SetDiscoverTargetsRequest();
        request.setDiscover(discover);
        target.setDiscoverTargets(request, DEFAULT_TIMEOUT);
    }

    @Override
    public void close() throws Exception {
        browser.close(DEFAULT_TIMEOUT);
    }

    @Override
    public ChromeContext defaultContext() {
        return defaultContext;
    }

    @Override
    public String userAgent() throws Exception {
        GetVersionResponse response = browser.getVersion(DEFAULT_TIMEOUT);
        return response.getUserAgent();
    }

    @Override
    public String version() throws Exception {
        GetVersionResponse response = browser.getVersion(DEFAULT_TIMEOUT);
        return response.getProduct();
    }

    @Override
    public URI wsEndpoint() {
        return connection instanceof WebSocketConnection ? ((WebSocketConnection) connection).uri() : null;
    }

    @Override
    public Process process() {
        return this.process;
    }

    @Override
    public void setCookie(Cookie... cookies) throws Exception {
        SetCookiesRequest request = CookieUtils.create(cookies);
        network.setCookies(request, DEFAULT_TIMEOUT);
    }

    @Override
    public void deleteCookie(Cookie... cookies) throws Exception {
        //此处需要异步实现
        List<Future<JSONObject>> futures = new ArrayList<>();
        for(Cookie cookie : cookies) {
            DeleteCookiesRequest request = new DeleteCookiesRequest();
            request.setName(cookie.getName());
            request.setDomain(cookie.getDomain());
            request.setPath(cookie.getPath());
            request.setUrl(cookie.getUrl());
            futures.add(defaultSession.asyncSend("Network.deleteCookies", request));
        }
        for(Future<JSONObject> future : futures) {
            future.get(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        }
    }

    @Override
    public void clearCookie() throws Exception {
        network.clearBrowserCookies(DEFAULT_TIMEOUT);
    }

    @Override
    public List<Cookie> cookies() throws Exception {
        GetAllCookiesResponse response = network.getAllCookies(DEFAULT_TIMEOUT);
        return response.getCookies().stream().map(cookie -> CookieUtils.copyOf(cookie)).collect(Collectors.toList());
    }
}
