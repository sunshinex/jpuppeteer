package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class SetPermissionRequest {

    /**
    * Origin the permission applies to.
    */
    public final String origin;

    /**
    * Descriptor of permission to override.
    */
    public final jpuppeteer.cdp.client.entity.browser.PermissionDescriptor permission;

    /**
    * Setting of the permission.
    */
    public final String setting;

    /**
    * Context to override. When omitted, default browser context is used.
    */
    public final String browserContextId;

    public SetPermissionRequest(String origin, jpuppeteer.cdp.client.entity.browser.PermissionDescriptor permission, String setting, String browserContextId) {
        this.origin = origin;
        this.permission = permission;
        this.setting = setting;
        this.browserContextId = browserContextId;
    }

    public SetPermissionRequest(String origin, jpuppeteer.cdp.client.entity.browser.PermissionDescriptor permission, String setting) {
        this.origin = origin;
        this.permission = permission;
        this.setting = setting;
        this.browserContextId = null;
    }

}