package jpuppeteer.chrome;

import com.google.common.collect.Lists;
import jpuppeteer.api.browser.BrowserContext;
import jpuppeteer.api.constant.PermissionType;
import jpuppeteer.cdp.CDPConnection;
import jpuppeteer.cdp.cdp.domain.Browser;
import jpuppeteer.cdp.cdp.domain.Target;
import jpuppeteer.cdp.cdp.entity.browser.GrantPermissionsRequest;
import jpuppeteer.cdp.cdp.entity.browser.ResetPermissionsRequest;
import jpuppeteer.cdp.cdp.entity.target.CloseTargetRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static jpuppeteer.chrome.ChromeBrowser.DEFAULT_TIMEOUT;
import static jpuppeteer.chrome.event.BrowserEvent.TARGETCRASHED;
import static jpuppeteer.chrome.event.BrowserEvent.TARGETDESTROYED;

public class ChromeContext implements BrowserContext {

    private static final Logger logger = LoggerFactory.getLogger(ChromeContext.class);

    private CDPConnection connection;

    private ChromeBrowser browser;

    private String browserContextId;

    private Map<String, ChromePage> pageMap;

    private Browser domainBrowser;

    private Target target;

    public ChromeContext(CDPConnection connection, ChromeBrowser browser, String browserContextId) {
        this.connection = connection;
        this.browser = browser;
        this.browserContextId = browserContextId;
        this.pageMap = new ConcurrentHashMap<>();
        this.domainBrowser = new Browser(connection);
        this.target = new Target(connection);
        //监听target destory跟crash事件, 以便从pageMap中移除page
        browser.addListener(TARGETDESTROYED, event -> {
            ChromePage page = pageMap.get(event.getTargetId());
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
            pageMap.remove(event.getTargetId());
            logger.info("page destroyed, clean done, pageId={}", event.getTargetId());
        });
        browser.addListener(TARGETCRASHED, event -> {
            ChromePage page = pageMap.get(event.getTargetId());
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
            pageMap.remove(event.getTargetId());
            logger.error("page crashed, clean done, pageId={}", event.getTargetId());
        });
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
        //关闭所有打开的页面
        Exception ex = null;
        Iterator<Map.Entry<String, ChromePage>> iterator = pageMap.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, ChromePage> entry = iterator.next();
            try {
                entry.getValue().close();
            } catch (Exception e) {
                ex = e;
            } finally {
                //这里需要等context的事件监听去移除, 所以不要对一个context执行两次close, 会发生异常
                //iterator.remove();
            }
        }
        if (ex != null) {
            throw ex;
        }
    }

    @Override
    public boolean isIncognito() {
        //@TODO 暂不支持创建上下文, 顾此处直接返回false
        return false;
    }

    @Override
    public ChromePage newPage() throws Exception {
        //先创建一个target
        String targetId = browser.createTarget(browserContextId);
        Throwable cause = null;
        try {
            //attach dev tools
            String sessionId = browser.attachToTarget(targetId);
            ChromePage page = new ChromePage(this, connection.createSession(sessionId), targetId);
            pageMap.put(targetId, page);
            return page;
        } catch (Throwable t) {
            cause = t;
            throw t;
        } finally {
            //无论哪一步失败了, 都关闭标签页
            if (cause != null) {
                CloseTargetRequest request = new CloseTargetRequest();
                request.setTargetId(targetId);
                target.closeTarget(request, DEFAULT_TIMEOUT);
            }
        }
    }

    @Override
    public List<ChromePage> pages() {
        return Lists.newArrayList(pageMap.values());
    }
}
