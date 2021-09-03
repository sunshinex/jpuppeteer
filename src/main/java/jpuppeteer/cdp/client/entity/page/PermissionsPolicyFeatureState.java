package jpuppeteer.cdp.client.entity.page;

/**
*/
public class PermissionsPolicyFeatureState {

    /**
    */
    public final jpuppeteer.cdp.client.constant.page.PermissionsPolicyFeature feature;

    /**
    */
    public final Boolean allowed;

    /**
    */
    public final jpuppeteer.cdp.client.entity.page.PermissionsPolicyBlockLocator locator;

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

}