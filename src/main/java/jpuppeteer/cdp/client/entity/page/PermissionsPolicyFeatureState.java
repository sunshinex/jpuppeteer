package jpuppeteer.cdp.client.entity.page;

/**
*/
public class PermissionsPolicyFeatureState {

    /**
    */
    private jpuppeteer.cdp.client.constant.page.PermissionsPolicyFeature feature;

    /**
    */
    private Boolean allowed;

    /**
    */
    private jpuppeteer.cdp.client.entity.page.PermissionsPolicyBlockLocator locator;

    public void setFeature (jpuppeteer.cdp.client.constant.page.PermissionsPolicyFeature feature) {
        this.feature = feature;
    }

    public jpuppeteer.cdp.client.constant.page.PermissionsPolicyFeature getFeature() {
        return this.feature;
    }

    public void setAllowed (Boolean allowed) {
        this.allowed = allowed;
    }

    public Boolean getAllowed() {
        return this.allowed;
    }

    public void setLocator (jpuppeteer.cdp.client.entity.page.PermissionsPolicyBlockLocator locator) {
        this.locator = locator;
    }

    public jpuppeteer.cdp.client.entity.page.PermissionsPolicyBlockLocator getLocator() {
        return this.locator;
    }

    public PermissionsPolicyFeatureState(jpuppeteer.cdp.client.constant.page.PermissionsPolicyFeature feature, Boolean allowed, jpuppeteer.cdp.client.entity.page.PermissionsPolicyBlockLocator locator) {
        this.feature = feature;
        this.allowed = allowed;
        this.locator = locator;
    }

    public PermissionsPolicyFeatureState(jpuppeteer.cdp.client.constant.page.PermissionsPolicyFeature feature, Boolean allowed) {
        this.feature = feature;
        this.allowed = allowed;
        this.locator = null;
    }

    public PermissionsPolicyFeatureState() {
    }

}