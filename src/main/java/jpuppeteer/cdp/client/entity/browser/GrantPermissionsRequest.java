package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class GrantPermissionsRequest {

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.constant.browser.PermissionType> permissions;

    /**
    * Origin the permission applies to, all origins if not specified.
    */
    private String origin;

    /**
    * BrowserContext to override permissions. When omitted, default browser context is used.
    */
    private String browserContextId;

    public void setPermissions (java.util.List<jpuppeteer.cdp.client.constant.browser.PermissionType> permissions) {
        this.permissions = permissions;
    }

    public java.util.List<jpuppeteer.cdp.client.constant.browser.PermissionType> getPermissions() {
        return this.permissions;
    }

    public void setOrigin (String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setBrowserContextId (String browserContextId) {
        this.browserContextId = browserContextId;
    }

    public String getBrowserContextId() {
        return this.browserContextId;
    }

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

    public GrantPermissionsRequest() {
    }

}