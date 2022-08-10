package jpuppeteer.cdp.client.entity.target;

/**
*/
public class GetTargetsResponse {

    /**
    * The list of targets.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.target.TargetInfo> targetInfos;

    public void setTargetInfos (java.util.List<jpuppeteer.cdp.client.entity.target.TargetInfo> targetInfos) {
        this.targetInfos = targetInfos;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.target.TargetInfo> getTargetInfos() {
        return this.targetInfos;
    }

    public GetTargetsResponse(java.util.List<jpuppeteer.cdp.client.entity.target.TargetInfo> targetInfos) {
        this.targetInfos = targetInfos;
    }

    public GetTargetsResponse() {
    }

}