package jpuppeteer.cdp.client.entity.target;

/**
*/
public class GetTargetInfoRequest {

    /**
    */
    public final String targetId;

    public GetTargetInfoRequest(String targetId) {
        this.targetId = targetId;
    }

    public GetTargetInfoRequest() {
        this.targetId = null;
    }

}