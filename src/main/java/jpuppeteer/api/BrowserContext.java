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

    Future<Page> newPage(String url);

    default Future<Page> newPage() {
        return newPage("about:blank");
    }

    Page[] pages();

    Future setCookies(CookieParam... cookies);

    Future clearCookies();

    Future<Cookie[]> getCookies();

    Future close();

}
