package jpuppeteer.chrome;

import io.netty.util.concurrent.Future;
import jpuppeteer.api.BrowserContext;
import jpuppeteer.api.Page;
import jpuppeteer.cdp.client.constant.browser.PermissionType;
import jpuppeteer.cdp.client.entity.network.Cookie;
import jpuppeteer.cdp.client.entity.network.CookieParam;
import jpuppeteer.entity.TargetBase;
import jpuppeteer.util.SeriesPromise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"rawtypes", "unchecked"})
public class ChromeContext implements BrowserContext {

    private static final Logger logger = LoggerFactory.getLogger(ChromeContext.class);

    private final ChromeBrowser browser;

    private final String browserContextId;

    public ChromeContext(ChromeBrowser browser, String browserContextId) {
        this.browser = browser;
        this.browserContextId = browserContextId;
    }

    @Override
    public ChromeBrowser browser() {
        return browser;
    }

    @Override
    public Future grantPermissions(String origin, PermissionType... permissions) {
        return browser.grantPermissions(browserContextId, origin, permissions);
    }

    @Override
    public Future resetPermissions() {
        return browser.resetPermissions(browserContextId);
    }

    @Override
    public Future<Page> newPage(String url, Integer width, Integer height) {
        return SeriesPromise
                .wrap(browser.createTarget(browserContextId, url, width, height))
                .sync(targetId -> {
                    TargetBase targetBase = browser.findTarget(targetId);
                    return new ChromePage(this, targetBase);
                });
    }

    @Override
    public Future setCookies(CookieParam... cookies) {
        return browser.setCookies(browserContextId, cookies);
    }

    @Override
    public Future clearCookies() {
        return browser.clearCookies(browserContextId);
    }

    @Override
    public Future<Cookie[]> getCookies() {
        return browser.getCookies(browserContextId);
    }

    @Override
    public Future close() {
        return browser.closeContext(browserContextId);
    }

    public String browserContextId() {
        return browserContextId;
    }

}
