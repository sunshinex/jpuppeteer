package jpuppeteer.chrome;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import jpuppeteer.api.browser.BrowserContext;
import jpuppeteer.api.constant.PermissionType;
import jpuppeteer.api.future.DefaultPromise;
import jpuppeteer.api.future.Promise;
import jpuppeteer.cdp.CDPConnection;
import jpuppeteer.cdp.cdp.domain.Browser;
import jpuppeteer.cdp.cdp.domain.Target;
import jpuppeteer.cdp.cdp.entity.browser.GrantPermissionsRequest;
import jpuppeteer.cdp.cdp.entity.browser.ResetPermissionsRequest;
import jpuppeteer.cdp.cdp.entity.target.*;
import jpuppeteer.chrome.util.ImmediateFuture;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static jpuppeteer.chrome.ChromeBrowser.DEFAULT_TIMEOUT;
import static jpuppeteer.chrome.event.BrowserEvent.*;

public class ChromeContext implements BrowserContext {

    private static final Logger logger = LoggerFactory.getLogger(ChromeContext.class);

    private CDPConnection connection;

    private ChromeBrowser browser;

    private String browserContextId;

    private Map<String, Future<ChromePage>> pageMap;

    private Browser domainBrowser;

    private Target target;

    public ChromeContext(CDPConnection connection, ChromeBrowser browser, String browserContextId) {
        this.connection = connection;
        this.browser = browser;
        this.browserContextId = browserContextId;
        this.pageMap = new ConcurrentHashMap<>();
        this.domainBrowser = new Browser(connection);
        this.target = new Target(connection);
        browser.addListener(TARGETCREATED, event -> {
            TargetInfo target = event.getTargetInfo();
            String targetId = target.getTargetId();
            try {
                //对所有创建的页面, 自动附加
                browser.attachToTarget(targetId);
                logger.info("attach to target success, targetId={}", targetId);
            } catch (Exception e) {
                logger.error("attach to target failed, targetId={}, error={}", targetId, e.getMessage(), e);
            }
        });
        browser.addListener(ATTACHEDTOTARGET, event -> {
            String sessionId = event.getSessionId();
            TargetInfo target = event.getTargetInfo();
            String targetId = target.getTargetId();
            logger.info("target attached, targetId={}, sessionId={}, target={}", targetId, sessionId, JSON.toJSONString(target));
            String openerId = target.getOpenerId();
            ChromePage opener = null;
            if (StringUtils.isNotEmpty(openerId)) {
                if (!pageMap.containsKey(openerId)) {
                    logger.error("opener not found");
                    return;
                } else {
                    try {
                        opener = pageMap.get(openerId).get(30, TimeUnit.SECONDS);
                    } catch (Exception e) {
                        logger.error("opener future get failed, error={}", e.getMessage(), e);
                        return;
                    }
                }
            }
            try {
                ChromePage page = new ChromePage(this, connection.createSession(sessionId), targetId, opener);
                Future<ChromePage> future;
                synchronized (pageMap) {
                    future = pageMap.get(targetId);
                }
                if (future != null) {
                    Promise<ChromePage> promise = (Promise<ChromePage>) future;
                    promise.setSuccess(page);
                } else {
                    pageMap.put(targetId, new ImmediateFuture<>(page));
                }
            } catch (Exception e) {
                logger.error("create page failed, error={}", e.getMessage(), e);
            }
        });
        //监听target destory跟crash事件, 以便从pageMap中移除page
        browser.addListener(TARGETDESTROYED, event -> cleanUp(event.getTargetId()));
        browser.addListener(TARGETCRASHED, event -> cleanUp(event.getTargetId()));
    }

    private void cleanUp(String targetId) {
        Future<ChromePage> future = pageMap.get(targetId);
        if (future == null) {
            return;
        }
        ChromePage page = null;
        try {
            page = future.get();
        } catch (Exception e) {
            logger.error("page future error, targetId={}, error={}", targetId, e.getMessage(), e);
        }
        if (page == null) {
            return;
        }
        //尝试关闭页面
        if (!page.isClosed()) {
            page.close();
        }
        //移除session
        connection.removeSession(page.session.getSessionId());
        //移除page link
        pageMap.remove(targetId);
        logger.error("page clean up done, targetId={}", target);
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

    /**
     * warning!!! 请不要对同一个context执行多次close
     * @throws Exception
     */
    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isIncognito() {
        //@TODO 暂不支持创建上下文, 顾此处直接返回false
        return false;
    }

    @Override
    public ChromePage newPage() throws Exception {
        Promise<ChromePage> promise = new DefaultPromise<>();
        String targetId;
        synchronized (pageMap) {
            targetId = browser.createTarget(browserContextId);
            pageMap.put(targetId, promise);
        }
        try {
            return promise.get(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            //发生异常的时候关闭页面
            CloseTargetRequest request = new CloseTargetRequest();
            request.setTargetId(targetId);
            target.closeTarget(request, DEFAULT_TIMEOUT);
            throw e;
        }
    }

    @Override
    public List<ChromePage> pages() throws Exception {
        List<ChromePage> pages = new ArrayList<>(pageMap.size());
        for(Future<ChromePage> promise : pageMap.values()) {
            pages.add(promise.get());
        }
        return pages;
    }
}
