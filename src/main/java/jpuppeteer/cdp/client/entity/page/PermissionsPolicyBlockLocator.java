package jpuppeteer.cdp.client.entity.page;

/**
*/
public class PermissionsPolicyBlockLocator {

    /**
    */
    private String frameId;

    /**
    */
    private jpuppeteer.cdp.client.constant.page.PermissionsPolicyBlockReason blockReason;

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public void setBlockReason (jpuppeteer.cdp.client.constant.page.PermissionsPolicyBlockReason blockReason) {
        this.blockReason = blockReason;
    }

    public jpuppeteer.cdp.client.constant.page.PermissionsPolicyBlockReason getBlockReason() {
        return this.blockReason;
    }

    public PermissionsPolicyBlockLocator(String frameId, jpuppeteer.cdp.client.constant.page.PermissionsPolicyBlockReason blockReason) {
        this.frameId = frameId;
        this.blockReason = blockReason;
    }

    public PermissionsPolicyBlockLocator() {
    }

}