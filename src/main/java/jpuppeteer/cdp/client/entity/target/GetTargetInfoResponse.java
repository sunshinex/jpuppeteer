package jpuppeteer.cdp.client.entity.target;

/**
*/
public class GetTargetInfoResponse {

    /**
    */
    private jpuppeteer.cdp.client.entity.target.TargetInfo targetInfo;

    public void setTargetInfo (jpuppeteer.cdp.client.entity.target.TargetInfo targetInfo) {
        this.targetInfo = targetInfo;
    }

    public jpuppeteer.cdp.client.entity.target.TargetInfo getTargetInfo() {
        return this.targetInfo;
    }

    public GetTargetInfoResponse(jpuppeteer.cdp.client.entity.target.TargetInfo targetInfo) {
        this.targetInfo = targetInfo;
    }

    public GetTargetInfoResponse() {
    }

}