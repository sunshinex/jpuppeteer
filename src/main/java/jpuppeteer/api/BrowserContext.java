package jpuppeteer.api;

import io.netty.util.concurrent.Future;
import jpuppeteer.cdp.client.constant.browser.PermissionType;
import jpuppeteer.cdp.client.entity.network.Cookie;
import jpuppeteer.cdp.client.entity.network.CookieParam;

public interface BrowserContext {

    String name();

    Browser browser();

    Future grantPermissions(String origin, PermissionType... permissions);

    Future resetPermissions();

    Future<Page> newPage(String url, Integer width, Integer height);

    default Future<Page> newPage(String url) {
        return newPage(url, null, null);
    }

    default Future<Page> newPage() {
        return newPage("about:blank", null, null);
    }

    Page[] pages();

    Future setCookies(CookieParam... cookies);

    Future clearCookies();

    Future<Cookie[]> getCookies();

    Future close();

}
