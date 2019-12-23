package jpuppeteer.chrome;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import jpuppeteer.api.browser.BrowserContext;
import jpuppeteer.api.browser.Page;
import jpuppeteer.api.constant.PermissionType;
import jpuppeteer.api.event.AbstractEventEmitter;
import jpuppeteer.api.future.DefaultPromise;
import jpuppeteer.api.future.Promise;
import jpuppeteer.cdp.CDPConnection;
import jpuppeteer.cdp.cdp.domain.Browser;
import jpuppeteer.cdp.cdp.domain.Target;
import jpuppeteer.cdp.cdp.entity.browser.GrantPermissionsRequest;
import jpuppeteer.cdp.cdp.entity.browser.ResetPermissionsRequest;
import jpuppeteer.cdp.cdp.entity.target.CloseTargetRequest;
import jpuppeteer.cdp.cdp.entity.target.TargetInfo;
import jpuppeteer.cdp.constant.TargetType;
import jpuppeteer.chrome.event.PageEvent;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static jpuppeteer.chrome.ChromeBrowser.DEFAULT_TIMEOUT;
import static jpuppeteer.chrome.event.BrowserEvent.*;

public class ChromeContext extends AbstractEventEmitter implements BrowserContext {

    private static final Logger logger = LoggerFactory.getLogger(ChromeContext.class);

    private CDPConnection connection;

    private ChromeBrowser browser;

    private String browserContextId;

    private Map<String, ChromePage> pageMap;

    private Browser domainBrowser;

    private Target target;

    private Map<String, Promise<ChromePage>> promiseMap;

    public ChromeContext(CDPConnection connection, ChromeBrowser browser, String browserContextId) {
        this.connection = connection;
        this.browser = browser;
        this.browserContextId = browserContextId;
        MapMaker mapMaker = new MapMaker().weakValues().concurrencyLevel(16);
        this.pageMap = mapMaker.makeMap();
        this.promiseMap = new ConcurrentHashMap<>();
        this.domainBrowser = new Browser(connection);
        this.target = new Target(connection);
        browser.addListener(TARGETCREATED, event -> {
            TargetInfo target = event.getTargetInfo();
            TargetType targetType = TargetType.findByValue(target.getType());
            if (!(TargetType.PAGE.equals(targetType))) {
                logger.debug("ignore target is not page, target={}", target);
                return;
            }
            String targetId = target.getTargetId();
            try {
                //对所有创建的页面, 自动附加
                browser.attachToTarget(targetId);
                logger.info("do attach target success, targetId={}", targetId);
            } catch (Exception e) {
                logger.error("do attach target failed, targetId={}, error={}", targetId, e.getMessage(), e);
            }
        });
        browser.addListener(ATTACHEDTOTARGET, event -> {
            TargetInfo target = event.getTargetInfo();
            String sessionId = event.getSessionId();
            String targetId = target.getTargetId();
            logger.info("target attached, targetId={}, sessionId={}, target={}", targetId, sessionId, JSON.toJSONString(target));
            String openerId = target.getOpenerId();
            ChromePage opener = null;
            if (StringUtils.isNotEmpty(openerId)) {
                opener = pageMap.get(openerId);
                if (opener == null) {
                    logger.error("opener not found, openerId={}", openerId);
                    return;
                }
            }
            Promise<ChromePage> promise = promiseMap.get(targetId);
            try {
                ChromePage page = new ChromePage(this, connection.createSession(sessionId), targetId, opener);
                synchronized (pageMap) {
                    if (pageMap.containsKey(targetId)) {
                        logger.warn("page exists, will be cover");
                    }
                    pageMap.put(targetId, page);
                }
                if (promise != null) {
                    promise.setSuccess(page);
                }
                if (opener != null) {
                    opener.emit(PageEvent.OPENPAGE, page);
                }
            } catch (Exception e) {
                if (promise != null) {
                    promise.setFailure(e);
                }
                logger.error("create page failed, error={}", e.getMessage(), e);
            }
        });
        //监听target destory事件, 以便从pageMap中移除page
        browser.addListener(TARGETDESTROYED, event -> cleanUp(event.getTargetId()));
        //crashed事件暂时不处理, 交给业务自己处理
    }

    private void cleanUp(String targetId) {
        ChromePage page = pageMap.get(targetId);
        if (page == null) {
            return;
        }
        //移除session
        connection.removeSession(page.session.getSessionId());
        //移除page link
        pageMap.remove(targetId);
        logger.debug("page clean up done, targetId={}", targetId);
    }

    @Override
    public ChromeBrowser browser() {
        return browser;
    }

    @Override
    public void resetPermissions() throws Exception {
        ResetPermissionsRequest request = new ResetPermissionsRequest();
        request.setBrowserContextId(browserContextId);
        domainBrowser.resetPermissions(request, DEFAULT_TIMEOUT);
    }

    @Override
    public void grantPermissions(String origin, PermissionType... permissions) throws Exception {
        GrantPermissionsRequest request = new GrantPermissionsRequest();
        request.setBrowserContextId(browserContextId);
        request.setOrigin(origin);
        request.setPermissions(Arrays.stream(permissions).map(permission -> permission.getValue()).collect(Collectors.toList()));
        domainBrowser.grantPermissions(request, DEFAULT_TIMEOUT);
    }

    @Override
    public boolean isIncognito() {
        //@TODO 暂不支持创建上下文, 顾此处直接返回false
        return false;
    }

    @Override
    public ChromePage newPage() throws Exception {
        Promise<ChromePage> promise = new DefaultPromise<>();
        String targetId = browser.createTarget(browserContextId);
        promiseMap.put(targetId, promise);
        try {
            return promise.get(5, TimeUnit.SECONDS);
        } catch (Exception e) {
            CloseTargetRequest request = new CloseTargetRequest();
            request.setTargetId(targetId);
            target.closeTarget(request, DEFAULT_TIMEOUT);
            throw e;
        } finally {
            promiseMap.remove(targetId);
        }
    }

    @Override
    public List<Page> pages() throws Exception {
        return Lists.newArrayList(pageMap.values());
    }
}
