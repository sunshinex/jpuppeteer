package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class GrantPermissionsRequest {

    /**
    */
    public final java.util.List<jpuppeteer.cdp.client.constant.browser.PermissionType> permissions;

    /**
    * Origin the permission applies to, all origins if not specified.
    */
    public final String origin;

    /**
    * BrowserContext to override permissions. When omitted, default browser context is used.
    */
    public final String browserContextId;

    public GrantPermissionsRequest(java.util.List<jpuppeteer.cdp.client.constant.browser.PermissionType> permissions, String origin, String browserContextId) {
        this.permissions = permissions;
        this.origin = origin;
        this.browserContextId = browserContextId;
    }

    public GrantPermissionsRequest(java.util.List<jpuppeteer.cdp.client.constant.browser.PermissionType> permissions) {
        this.permissions = permissions;
        this.origin = null;
        this.browserContextId = null;
    }

}