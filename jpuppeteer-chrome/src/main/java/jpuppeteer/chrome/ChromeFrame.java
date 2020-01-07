package jpuppeteer.chrome;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import jpuppeteer.api.browser.Coordinate;
import jpuppeteer.api.browser.Frame;
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
import jpuppeteer.cdp.cdp.entity.runtime.CallFunctionOnRequest;
import jpuppeteer.cdp.cdp.entity.runtime.EvaluateRequest;
import jpuppeteer.cdp.cdp.entity.runtime.RemoteObject;
import jpuppeteer.chrome.constant.ScriptConstants;
import jpuppeteer.chrome.util.ChromeObjectUtils;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static jpuppeteer.chrome.ChromeBrowser.DEFAULT_TIMEOUT;

public class ChromeFrame extends AbstractExecutionContext implements Frame {

    private static final Logger logger = LoggerFactory.getLogger(ChromeFrame.class);

    protected String frameId;

    protected ChromeFrame parent;

    protected volatile Set<ChromeFrame> children;

    protected volatile Integer executionContextId;

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

    public ChromeFrame(ChromeFrame parent, String frameId, CDPSession session, Page page, Runtime runtime, DOM dom, Input input) {
        super(runtime);
        this.parent = parent;
        this.frameId = frameId;
        this.session = session;
        this.children = new HashSet<>(0);
        this.page = page;
        this.dom = dom;
        this.input = input;
        this.runtime = runtime;
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
        if (Objects.equals(this.executionContextId, executionContextId)) {
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
        ChromeFrame frame = new ChromeFrame(this, frameId, session, page, runtime, dom, input);
        this.children.add(frame);
        return frame;
    }

    protected void remove() {
        if (this.parent != null) {
            this.parent.children.remove(this);
        }
    }

    public void createExecutionContext(Integer executionContextId) {
        this.executionContextId = executionContextId;
    }

    public void destroyExecutionContext() {
        this.executionContextId = null;
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
    void pre(CallFunctionOnRequest request) {
        request.setExecutionContextId(this.executionContextId);
    }

    @Override
    void pre(EvaluateRequest request) {
        request.setContextId(this.executionContextId);
    }

    private ChromeBrowserObject evaluate(String expression, boolean returnJSON, Object... args) throws Exception {
        if (isFunction(expression)) {
            return doCall(expression, returnJSON, args);
        } else {
            return doEvaluate(expression, returnJSON);
        }
    }

    @Override
    public <R> R evaluate(String expression, Class<R> clazz, Object... args) throws Exception {
        return evaluate(expression, false, args).toObject(clazz);
    }

    @Override
    public <R> R evaluate(String expression, TypeReference<R> type, Object... args) throws Exception {
        return evaluate(expression, false, args).toObject(type);
    }

    @Override
    public ChromeBrowserObject evaluate(String expression, Object... args) throws Exception {
        return evaluate(expression, false, args);
    }

    @Override
    public ChromeElement querySelector(String selector) throws Exception {
        ChromeBrowserObject object = evaluate("document.querySelector(\"" + StringEscapeUtils.escapeEcmaScript(selector) + "\")");
        if (RemoteObjectType.UNDEFINED.equals(object.type) || RemoteObjectSubtype.NULL.equals(object.subType)) {
            return null;
        }
        return new ChromeElement(this, object);
    }

    @Override
    public List<ChromeElement> querySelectorAll(String selector) throws Exception {
        ChromeBrowserObject browserObject = evaluate("document.querySelectorAll(\"" + StringEscapeUtils.escapeEcmaScript(selector) + "\")", selector);
        List<ChromeBrowserObject> properties = browserObject.getProperties();
        List<ChromeElement> elements = properties.stream().map(object -> new ChromeElement(this, object)).collect(Collectors.toList());
        ChromeObjectUtils.releaseObjectQuietly(runtime, browserObject.objectId);
        return elements;
    }

    @Override
    public String content() throws Exception {
        ChromeBrowserObject object = evaluate("document.documentElement.outerHTML");
        return object.toStringValue();
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void setContent(String content) throws Exception {
        evaluate(ScriptConstants.SET_CONTENT, content);
    }

    @Override
    public String title() throws Exception {
        ChromeBrowserObject object = evaluate("document.title");
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

    private static Object[] buildWaitArgs(String expression, int timeout, TimeUnit unit, Object... args) {
        //TODO 带有超时设定的方法需要把超时设置传递给cdp request
        Object[] callArgs = new Object[2 + args.length];
        callArgs[0] = expression;
        callArgs[1] = unit.toMillis(timeout);
        System.arraycopy(args, 0, callArgs, 2, args.length);
        return callArgs;
    }

    @Override
    public ChromeBrowserObject wait(String expression, int timeout, TimeUnit unit, Object... args) throws Exception {
        return evaluate(ScriptConstants.WAIT, buildWaitArgs(expression, timeout, unit, args));
    }

    @Override
    public <R> R wait(String expression, int timeout, TimeUnit unit, Class<R> clazz, Object... args) throws Exception {
        return evaluate(ScriptConstants.WAIT, clazz, buildWaitArgs(expression, timeout, unit, args));
    }

    @Override
    public <R> R wait(String expression, int timeout, TimeUnit unit, TypeReference<R> type, Object... args) throws Exception {
        return evaluate(ScriptConstants.WAIT, type, buildWaitArgs(expression, timeout, unit, args));
    }

    @Override
    public ChromeElement waitSelector(String selector, int timeout, TimeUnit unit) throws Exception {
        ChromeBrowserObject object = wait(ScriptConstants.WAIT_SELECTOR, timeout, unit, selector);
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
            resolveRequest.setExecutionContextId(frame.executionContextId);
            ResolveNodeResponse resolveResponse = frame.dom.resolveNode(resolveRequest, DEFAULT_TIMEOUT);
            ChromeObjectUtils.releaseObjectQuietly(frame.runtime, object.getObjectId());
            remoteObject = resolveResponse.getObject();
        } catch (Exception e) {
            logger.warn("script object to dom element error, error={}", e.getMessage(), e);
        }
        return remoteObject;
    }

    @Override
    public Coordinate scroll(int x, int y) throws Exception {
        JSONObject offset = evaluate(ScriptConstants.SCROLL, JSONObject.class, x, y);
        return new Coordinate(offset.getDouble("scrollX"), offset.getDouble("scrollY"));
    }

}
