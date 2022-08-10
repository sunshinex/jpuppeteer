package jpuppeteer.api;

import jpuppeteer.cdp.client.constant.browser.PermissionType;
import jpuppeteer.cdp.client.entity.network.Cookie;
import jpuppeteer.cdp.client.entity.network.CookieParam;
import jpuppeteer.util.XFuture;

public interface BrowserContext {

    String browserContextId();

    Browser browser();

    XFuture<?> grantPermissions(String origin, PermissionType... permissions);

    XFuture<?> resetPermissions();

    XFuture<Page> newPage(String url, Integer width, Integer height);

    default XFuture<Page> newPage(String url) {
        return newPage(url, null, null);
    }

    default XFuture<Page> newPage() {
        return newPage("about:blank", null, null);
    }

    XFuture<?> setCookies(CookieParam... cookies);

    XFuture<?> clearCookies();

    XFuture<Cookie[]> getCookies();

    void close();

}
