package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class GetWindowForTargetRequest {

    /**
    * Devtools agent host id. If called as a part of the session, associated targetId is used.
    */
    public final String targetId;

    public GetWindowForTargetRequest(String targetId) {
        this.targetId = targetId;
    }

    public GetWindowForTargetRequest() {
        this.targetId = null;
    }

}