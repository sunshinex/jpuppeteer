package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class GrantPermissionsRequest {

    /**
    */
    public final String origin;

    /**
    */
    public final java.util.List<jpuppeteer.cdp.client.constant.browser.PermissionType> permissions;

    /**
    * BrowserContext to override permissions. When omitted, default browser context is used.
    */
    public final String browserContextId;

    public GrantPermissionsRequest(String origin, java.util.List<jpuppeteer.cdp.client.constant.browser.PermissionType> permissions, String browserContextId) {
        this.origin = origin;
        this.permissions = permissions;
        this.browserContextId = browserContextId;
    }

    public GrantPermissionsRequest(String origin, java.util.List<jpuppeteer.cdp.client.constant.browser.PermissionType> permissions) {
        this.origin = origin;
        this.permissions = permissions;
        this.browserContextId = null;
    }

}