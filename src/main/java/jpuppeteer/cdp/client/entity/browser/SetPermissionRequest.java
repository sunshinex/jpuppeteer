package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class SetPermissionRequest {

    /**
    * Descriptor of permission to override.
    */
    private jpuppeteer.cdp.client.entity.browser.PermissionDescriptor permission;

    /**
    * Setting of the permission.
    */
    private jpuppeteer.cdp.client.constant.browser.PermissionSetting setting;

    /**
    * Origin the permission applies to, all origins if not specified.
    */
    private String origin;

    /**
    * Context to override. When omitted, default browser context is used.
    */
    private String browserContextId;

    public void setPermission (jpuppeteer.cdp.client.entity.browser.PermissionDescriptor permission) {
        this.permission = permission;
    }

    public jpuppeteer.cdp.client.entity.browser.PermissionDescriptor getPermission() {
        return this.permission;
    }

    public void setSetting (jpuppeteer.cdp.client.constant.browser.PermissionSetting setting) {
        this.setting = setting;
    }

    public jpuppeteer.cdp.client.constant.browser.PermissionSetting getSetting() {
        return this.setting;
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

    public SetPermissionRequest() {
    }

}