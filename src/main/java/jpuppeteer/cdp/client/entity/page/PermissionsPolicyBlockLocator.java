package jpuppeteer.cdp.client.entity.page;

/**
*/
public class PermissionsPolicyBlockLocator {

    /**
    */
    public final String frameId;

    /**
    */
    public final jpuppeteer.cdp.client.constant.page.PermissionsPolicyBlockReason blockReason;

    public PermissionsPolicyBlockLocator(String frameId, jpuppeteer.cdp.client.constant.page.PermissionsPolicyBlockReason blockReason) {
        this.frameId = frameId;
        this.blockReason = blockReason;
    }

}