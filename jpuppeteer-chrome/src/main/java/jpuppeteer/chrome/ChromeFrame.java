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
import jpuppeteer.cdp.cdp.entity.runtime.CallArgument;
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

public class ChromeFrame implements Frame {

    private static final Logger logger = LoggerFactory.getLogger(ChromeFrame.class);

    protected String frameId;

    protected ChromeFrame parent;

    protected volatile Set<ChromeFrame> children;

    protected volatile ChromeExecutionContext executionContext;

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
        this.parent = parent;
        this.frameId = frameId;
        this.session = session;
        this.children = new HashSet<>(0);
        this.page = page;
        this.dom = dom;
        this.input = input;
        this.runtime = runtime;
        createExecutionContext(null);
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
        if (executionContext != null && Objects.equals(executionContext.executionContextId, executionContextId)) {
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
        executionContext = new ChromeExecutionContext(runtime, executionContextId);
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
    public <R> R evaluate(String expression, Class<R> clazz, Object... args) throws Exception {
        return executionContext.evaluate(expression, clazz, args);
    }

    @Override
    public <R> R evaluate(String expression, TypeReference<R> type, Object... args) throws Exception {
        return executionContext.evaluate(expression, type, args);
    }

    @Override
    public ChromeBrowserObject evaluate(String expression, Object... args) throws Exception {
        return executionContext.evaluate(expression, args);
    }

    @Override
    public ChromeElement querySelector(String selector) throws Exception {
        ChromeBrowserObject object = evaluate("document.querySelector(\""+ StringEscapeUtils.escapeEcmaScript(selector) +"\")");
        if (RemoteObjectType.UNDEFINED.equals(object.type) || RemoteObjectSubtype.NULL.equals(object.subType)) {
            return null;
        }
        return new ChromeElement(this, object);
    }

    @Override
    public List<ChromeElement> querySelectorAll(String selector) throws Exception {
        ChromeBrowserObject browserObject = evaluate("document.querySelectorAll(\""+ StringEscapeUtils.escapeEcmaScript(selector) +"\")");
        List<ChromeBrowserObject> properties = browserObject.getProperties();
        List<ChromeElement> elements = properties.stream().map(object -> new ChromeElement(this, object)).collect(Collectors.toList());
        ChromeObjectUtils.releaseObjectQuietly(runtime, browserObject.objectId);
        return elements;
    }

    @Override
    public String content() throws Exception {
        return evaluate("document.documentElement.outerHTML", String.class);
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
        return evaluate("document.title", String.class);
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

    @Override
    public ChromeBrowserObject wait(String expression, int timeout, TimeUnit unit, Object... args) throws Exception {
        Object[] callArgs = new Object[2 + args.length];
        callArgs[0] = expression;
        callArgs[1] = unit.toMillis(timeout);
        System.arraycopy(args, 0, callArgs, 2, args.length);
        return evaluate(ScriptConstants.WAIT, callArgs);
    }

    @Override
    public <R> R wait(String expression, int timeout, TimeUnit unit, Class<R> clazz, Object... args) throws Exception {
        return wait(expression, timeout, unit, args).toObject(clazz);
    }

    @Override
    public <R> R wait(String expression, int timeout, TimeUnit unit, TypeReference<R> type, Object... args) throws Exception {
        return wait(expression, timeout, unit, args).toObject(type);
    }

    @Override
    public ChromeElement waitSelector(String selector, int timeout, TimeUnit unit) throws Exception {
        ChromeBrowserObject object = wait(ScriptConstants.WAIT_SELECTOR, timeout, unit, selector);
        if (RemoteObjectType.UNDEFINED.equals(object.type) || RemoteObjectSubtype.NULL.equals(object.subType)) {
            return null;
        }
        return new ChromeElement(this, toDomObject(this, object.object));
    }

    @Override
    public Coordinate scroll(int x, int y) throws Exception {
        JSONObject offset = evaluate(ScriptConstants.SCROLL, JSONObject.class, x, y);
        return new Coordinate(offset.getDouble("scrollX"), offset.getDouble("scrollY"));
    }

    public static RemoteObject toDomObject(ChromeFrame frame, RemoteObject object) {
        RemoteObject remoteObject = object;
        try {
            DescribeNodeRequest describeRequest = new DescribeNodeRequest();
            describeRequest.setObjectId(object.getObjectId());
            DescribeNodeResponse describeResponse = frame.dom.describeNode(describeRequest, DEFAULT_TIMEOUT);
            ResolveNodeRequest resolveRequest = new ResolveNodeRequest();
            resolveRequest.setBackendNodeId(describeResponse.getNode().getBackendNodeId());
            resolveRequest.setExecutionContextId(frame.executionContext.executionContextId);
            ResolveNodeResponse resolveResponse = frame.dom.resolveNode(resolveRequest, DEFAULT_TIMEOUT);
            ChromeObjectUtils.releaseObjectQuietly(frame.runtime, object.getObjectId());
            remoteObject = resolveResponse.getObject();
        } catch (Exception e) {
            logger.warn("script object to dom element error, error={}", e.getMessage(), e);
        }
        return remoteObject;
    }

}
