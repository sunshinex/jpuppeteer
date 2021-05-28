package jpuppeteer.cdp.client.entity.network;

/**
*/
public class SetAttachDebugStackRequest {

    /**
    * Whether to attach a page script stack for debugging purpose.
    */
    public final Boolean enabled;

    public SetAttachDebugStackRequest(Boolean enabled) {
        this.enabled = enabled;
    }

}