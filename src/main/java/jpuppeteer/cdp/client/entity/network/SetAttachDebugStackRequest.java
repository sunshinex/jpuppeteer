package jpuppeteer.cdp.client.entity.network;

/**
*/
public class SetAttachDebugStackRequest {

    /**
    * Whether to attach a page script stack for debugging purpose.
    */
    private Boolean enabled;

    public void setEnabled (Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public SetAttachDebugStackRequest(Boolean enabled) {
        this.enabled = enabled;
    }

    public SetAttachDebugStackRequest() {
    }

}