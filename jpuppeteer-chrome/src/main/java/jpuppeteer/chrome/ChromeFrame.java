package jpuppeteer.chrome;

import com.alibaba.fastjson.TypeReference;
import jpuppeteer.api.browser.Frame;
import jpuppeteer.api.event.DefaultEventEmitter;
import jpuppeteer.cdp.CDPSession;
import jpuppeteer.cdp.cdp.constant.runtime.RemoteObjectSubtype;
import jpuppeteer.cdp.cdp.constant.runtime.RemoteObjectType;
import jpuppeteer.cdp.cdp.domain.DOM;
import jpuppeteer.cdp.cdp.domain.Input;
import jpuppeteer.cdp.cdp.domain.Page;
import jpuppeteer.cdp.cdp.domain.Runtime;
import jpuppeteer.cdp.cdp.entity.dom.DescribeNodeRequest;
import jpuppeteer.cdp.cdp.entity.dom.DescribeNodeResponse;
import jpuppeteer.cdp.cdp.entity.dom.ResolveNodeRequest;
import jpuppeteer.cdp.cdp.entity.dom.ResolveNodeResponse;
import jpuppeteer.cdp.cdp.entity.page.NavigateRequest;
import jpuppeteer.cdp.cdp.entity.runtime.CallArgument;
import jpuppeteer.cdp.cdp.entity.runtime.RemoteObject;
import jpuppeteer.chrome.constant.ScriptConstants;
import jpuppeteer.chrome.event.type.ChromeFrameEvent;
import jpuppeteer.chrome.util.ArgUtils;
import jpuppeteer.chrome.util.ChromeObjectUtils;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static jpuppeteer.chrome.ChromeBrowser.DEFAULT_TIMEOUT;

public class ChromeFrame extends DefaultEventEmitter<ChromeFrameEvent> implements Frame<CallArgument> {

    private static final Logger logger = LoggerFactory.getLogger(ChromeFrame.class);

    protected Executor executor;

    protected String frameId;

    protected ChromeFrame parent;

    protected volatile Set<ChromeFrame> children;

    private volatile ChromeExecutionContext executionContext;

    protected CDPSession session;

    protected Page page;

    protected DOM dom;

    protected Input input;

    protected Runtime runtime;

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

    public ChromeFrame(Executor executor, ChromeFrame parent, String frameId, CDPSession session, Page page, Runtime runtime, DOM dom, Input input) {
        super(executor);
        this.executor = executor;
        this.parent = parent;
        this.frameId = frameId;
        this.session = session;
        this.children = new HashSet<>(0);
        this.page = page;
        this.dom = dom;
        this.input = input;
        this.runtime = runtime;
    }

    protected ChromeExecutionContext executionContext() {
        if (executionContext == null) {
            synchronized (this) {
                while (true) {
                    try {
                        wait();
                        break;
                    } catch (InterruptedException e) {
                        //忽略中断
                    }
                }
            }
        }
        return executionContext;
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

    protected ChromeFrame find(Integer executionContextId) {
        if (executionContext != null && executionContext.executionContextId == executionContextId) {
            return this;
        } else if (CollectionUtils.isNotEmpty(children)) {
            for (ChromeFrame frame : children) {
                if (frame.find(executionContextId) == null) {
                    continue;
                }
                return frame;
            }
        }
        return null;
    }

    /**
     * 返回刚刚append的子frame
     * @param frameId
     * @return
     */
    protected ChromeFrame append(String frameId) {
        ChromeFrame frame = new ChromeFrame(executor,this, frameId, session, page, runtime, dom, input);
        this.children.add(frame);
        return frame;
    }

    protected void remove() {
        if (this.parent != null) {
            this.parent.children.remove(this);
        }
    }

    public void createExecutionContext(Integer executionContextId) {
        executionContext = new ChromeExecutionContext(runtime, executionContextId);
        synchronized (this) {
            notifyAll();
        }
    }

    public void destroyExecutionContext() {
        executionContext = null;
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
    public <R> R evaluate(String expression, Class<R> clazz, CallArgument... args) throws Exception {
        return executionContext().evaluate(expression, clazz, args);
    }

    @Override
    public <R> R evaluate(String expression, TypeReference<R> type, CallArgument... args) throws Exception {
        return executionContext().evaluate(expression, type, args);
    }

    @Override
    public ChromeBrowserObject evaluate(String expression, CallArgument... args) throws Exception {
        return executionContext().evaluate(expression, args);
    }

    @Override
    public ChromeElement querySelector(String selector) throws Exception {
        CallArgument argSelector = ArgUtils.createFromValue(selector);
        ChromeBrowserObject object = evaluate("function(selector){return document.querySelector(selector);}", argSelector);
        if (RemoteObjectType.UNDEFINED.equals(object.type) || RemoteObjectSubtype.NULL.equals(object.subType)) {
            return null;
        }
        return new ChromeElement(this, object);
    }

    @Override
    public List<ChromeElement> querySelectorAll(String selector) throws Exception {
        CallArgument argSelector = ArgUtils.createFromValue(selector);
        ChromeBrowserObject browserObject = evaluate("function(selector){return document.querySelectorAll(selector);}", argSelector);
        List<ChromeBrowserObject> properties = browserObject.getProperties();
        List<ChromeElement> elements = properties.stream().map(object -> new ChromeElement(this, object)).collect(Collectors.toList());
        ChromeObjectUtils.releaseObjectQuietly(runtime, browserObject.objectId);
        return elements;
    }

    @Override
    public String content() throws Exception {
        ChromeBrowserObject object = evaluate("function(){return document.documentElement.outerHTML;}");
        return object.toStringValue();
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void setContent(String content) throws Exception {
        CallArgument html = ArgUtils.createFromValue(content);
        evaluate(ScriptConstants.SET_CONTENT, html);
    }

    @Override
    public String title() throws Exception {
        ChromeBrowserObject object = evaluate("function(){return document.title;}");
        return object.toStringValue();
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

    private static CallArgument[] buildWaitArgs(String expression, int timeout, TimeUnit unit, CallArgument... args) {
        //TODO 带有超时设定的方法需要把超时设置传递给cdp request
        CallArgument argExpression = ArgUtils.createFromValue(expression);
        CallArgument argTimeout = ArgUtils.createFromValue(unit.toMillis(timeout));
        CallArgument[] callArgs = new CallArgument[2 + args.length];
        callArgs[0] = argExpression;
        callArgs[1] = argTimeout;
        System.arraycopy(args, 0, callArgs, 2, args.length);
        return callArgs;
    }

    @Override
    public ChromeBrowserObject wait(String expression, int timeout, TimeUnit unit, CallArgument... args) throws Exception {
        CallArgument[] callArgs = buildWaitArgs(expression, timeout, unit, args);
        return evaluate(ScriptConstants.WAIT, callArgs);
    }

    @Override
    public <R> R wait(String expression, int timeout, TimeUnit unit, Class<R> clazz, CallArgument... args) throws Exception {
        CallArgument[] callArgs = buildWaitArgs(expression, timeout, unit, args);
        return evaluate(ScriptConstants.WAIT, clazz, callArgs);
    }

    @Override
    public <R> R wait(String expression, int timeout, TimeUnit unit, TypeReference<R> type, CallArgument... args) throws Exception {
        CallArgument[] callArgs = buildWaitArgs(expression, timeout, unit, args);
        return evaluate(ScriptConstants.WAIT, type, callArgs);
    }

    @Override
    public ChromeElement waitSelector(String selector, int timeout, TimeUnit unit) throws Exception {
        CallArgument argSelector = ArgUtils.createFromValue(selector);
        ChromeBrowserObject object = wait(ScriptConstants.WAIT_SELECTOR, timeout, unit, argSelector);
        if (RemoteObjectType.UNDEFINED.equals(object.type) || RemoteObjectSubtype.NULL.equals(object.subType)) {
            return null;
        }
        return new ChromeElement(this, toDomObject(this, object.object));
    }

    public static RemoteObject toDomObject(ChromeFrame frame, RemoteObject object) {
        RemoteObject remoteObject = object;
        try {
            DescribeNodeRequest describeRequest = new DescribeNodeRequest();
            describeRequest.setObjectId(object.getObjectId());
            DescribeNodeResponse describeResponse = frame.dom.describeNode(describeRequest, DEFAULT_TIMEOUT);
            ResolveNodeRequest resolveRequest = new ResolveNodeRequest();
            resolveRequest.setBackendNodeId(describeResponse.getNode().getBackendNodeId());
            resolveRequest.setExecutionContextId(frame.executionContext().executionContextId);
            ResolveNodeResponse resolveResponse = frame.dom.resolveNode(resolveRequest, DEFAULT_TIMEOUT);
            ChromeObjectUtils.releaseObjectQuietly(frame.runtime, object.getObjectId());
            remoteObject = resolveResponse.getObject();
        } catch (Exception e) {
            logger.warn("script object to dom element error, error={}", e.getMessage(), e);
        }
        return remoteObject;
    }

}
