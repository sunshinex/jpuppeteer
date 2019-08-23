package jpuppeteer.chrome;

import com.google.common.collect.Lists;
import jpuppeteer.api.browser.BrowserObject;
import jpuppeteer.api.browser.Frame;
import jpuppeteer.api.event.EventEmitter;
import jpuppeteer.api.event.EventType;
import jpuppeteer.api.event.GenericEventEmitter;
import jpuppeteer.cdp.cdp.domain.DOM;
import jpuppeteer.cdp.cdp.domain.Input;
import jpuppeteer.cdp.cdp.domain.Page;
import jpuppeteer.cdp.cdp.domain.Runtime;
import jpuppeteer.cdp.cdp.entity.page.NavigateRequest;
import jpuppeteer.cdp.cdp.entity.runtime.CallArgument;
import jpuppeteer.cdp.cdp.entity.runtime.CallFunctionOnRequest;
import jpuppeteer.cdp.cdp.entity.runtime.CallFunctionOnResponse;
import jpuppeteer.chrome.event.FrameEvent;
import jpuppeteer.chrome.util.ScriptUtils;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static jpuppeteer.chrome.ChromeBrowser.DEFAULT_TIMEOUT;

public class ChromeFrame implements Frame {

    private static final Logger logger = LoggerFactory.getLogger(ChromeFrame.class);

    private static final String SCRIPT_WAIT = ScriptUtils.load("wait.js");

    private static final String SCRIPT_SET_CONTENT = ScriptUtils.load("setcontent.js");

    protected EventEmitter events;

    protected String frameId;

    protected ChromeFrame parent;

    protected volatile Set<ChromeFrame> children;

    protected Page page;

    protected Runtime runtime;

    protected DOM dom;

    protected Input input;

    protected Integer executionContextId;

    @Setter
    protected String name;

    @Setter
    protected URL url;

    @Setter
    protected String securityOrigin;

    @Setter
    protected String mimeType;

    @Setter
    protected URL unreachableUrl;

    public ChromeFrame(ChromeFrame parent, String frameId, Page page, Runtime runtime, DOM dom, Input input) {
        this.events = new GenericEventEmitter();
        this.parent = parent;
        this.frameId = frameId;
        this.children = new HashSet<>(0);
        this.page = page;
        this.runtime = runtime;
        this.dom = dom;
        this.input = input;
    }

    private static <E> void checkEventType(EventType<E> eventType) {
        if (!(eventType instanceof FrameEvent)) {
            throw new IllegalArgumentException("eventType必须是FrameEvent的子类");
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
    public <E> E wait(EventType<E> eventType, int timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        checkEventType(eventType);
        return events.wait(eventType, timeout, unit);
    }

    @Override
    public <E> E wait(EventType<E> eventType, Predicate<E> predicate, int timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        checkEventType(eventType);
        return events.wait(eventType, predicate, timeout, unit);
    }

    @Override
    public <E> void emit(EventType<E> eventType, E event) {
        checkEventType(eventType);
        events.emit(eventType, event);
    }

    protected ChromeFrame find(String frameId) {
        if (this.frameId.equals(frameId)) {
            return this;
        } else if (CollectionUtils.isNotEmpty(children)) {
            for (ChromeFrame frame : children) {
                if (frame.find(frameId) == null) {
                    continue;
                }
                return frame;
            }
        }
        return null;
    }

    protected void append(String frameId) {
        this.children.add(new ChromeFrame(this, frameId, page, runtime, dom, input));
    }

    protected void remove() {
        if (this.parent != null) {
            this.parent.children.remove(this);
        }
    }

    @Override
    public String frameId() {
        return this.frameId;
    }

    @Override
    public ChromeFrame parent() {
        return parent;
    }

    @Override
    public ChromeFrame[] children() {
        ChromeFrame[] frames = new ChromeFrame[this.children.size()];
        return this.children.toArray(frames);
    }

    @Override
    public ChromeElement querySelector(String selector) throws Exception {
        CallArgument argSelector = new CallArgument();
        argSelector.setValue(selector);
        ChromeBrowserObject browserObject = evaluate("function(selector){return document.querySelector(selector);}", false, argSelector);
        return new ChromeElement(this, browserObject.object);
    }

    @Override
    public List<ChromeElement> querySelectorAll(String selector) throws Exception {
        CallArgument argSelector = new CallArgument();
        argSelector.setValue(selector);
        ChromeBrowserObject browserObject = evaluate("function(selector){return document.querySelectorAll(selector);}", false, argSelector);
        List<ChromeBrowserObject> properties = browserObject.getProperties();
        return properties.stream().map(object -> new ChromeElement(this, object.object)).collect(Collectors.toList());
    }

    @Override
    public String content() throws Exception {
        ChromeBrowserObject object = evaluate("function(){return document.documentElement.outerHTML;}", false);
        return object.getString();
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void setContent(String content) throws Exception {
        CallArgument html = new CallArgument();
        html.setValue(content);
        evaluate(SCRIPT_SET_CONTENT, false, html);
    }

    @Override
    public String title() throws Exception {
        ChromeBrowserObject object = evaluate("function(){return document.title;}", false);
        return object.getString();
    }

    @Override
    public URL url() throws Exception {
        return url;
    }

    @Override
    public void navigate(String url, String referer) throws Exception {
        NavigateRequest request = new NavigateRequest();
        request.setUrl(url);
        request.setReferrer(referer);
        request.setFrameId(frameId);
        page.navigate(request, DEFAULT_TIMEOUT);
    }

    public ChromeBrowserObject evaluate(String expression, boolean returnJSON, CallArgument... args) throws Exception {
        CallFunctionOnRequest request = new CallFunctionOnRequest();
        request.setFunctionDeclaration(expression);
        request.setArguments(Lists.newArrayList(args));
        request.setExecutionContextId(executionContextId);
        request.setReturnByValue(true);
        request.setUserGesture(true);
        request.setReturnByValue(returnJSON);
        request.setAwaitPromise(true);
        CallFunctionOnResponse response = runtime.callFunctionOn(request, DEFAULT_TIMEOUT);
        if (response.getExceptionDetails() != null) {
            throw new Exception(response.getExceptionDetails().getException().getDescription());
        }
        return new ChromeBrowserObject(this, response.getResult());
    }


    @Override
    public ChromeBrowserObject evaluate(String expression) throws Exception {
        return evaluate(expression, true);
    }

    @Override
    public BrowserObject wait(String expression, int timeout, TimeUnit unit) throws Exception {
        //TODO 带有超时设定的方法需要把超时设置传递给cdp request
        CallArgument argExpression = new CallArgument();
        argExpression.setValue(expression);
        CallArgument argTimeout = new CallArgument();
        argTimeout.setValue(unit.toMillis(timeout));
        return evaluate(SCRIPT_WAIT, false, argExpression, argTimeout);
    }

    @Override
    public ChromeElement waitSelector(String selector, int timeout, TimeUnit unit) throws Exception {
        ChromeBrowserObject object = (ChromeBrowserObject) wait("return document.querySelector('"+selector+"');", timeout, unit);
        return new ChromeElement(this, object.object);
    }

}
