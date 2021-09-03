package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class SetPermissionRequest {

    /**
    * Descriptor of permission to override.
    */
    public final jpuppeteer.cdp.client.entity.browser.PermissionDescriptor permission;

    /**
    * Setting of the permission.
    */
    public final jpuppeteer.cdp.client.constant.browser.PermissionSetting setting;

    /**
    * Origin the permission applies to, all origins if not specified.
    */
    public final String origin;

    /**
    * Context to override. When omitted, default browser context is used.
    */
    public final String browserContextId;

    public SetPermissionRequest(jpuppeteer.cdp.client.entity.browser.PermissionDescriptor permission, jpuppeteer.cdp.client.constant.browser.PermissionSetting setting, String origin, String browserContextId) {
        this.permission = permission;
        this.setting = setting;
        this.origin = origin;
        this.browserContextId = browserContextId;
    }

    public SetPermissionRequest(jpuppeteer.cdp.client.entity.browser.PermissionDescriptor permission, jpuppeteer.cdp.client.constant.browser.PermissionSetting setting) {
        this.permission = permission;
        this.setting = setting;
        this.origin = null;
        this.browserContextId = null;
    }

}