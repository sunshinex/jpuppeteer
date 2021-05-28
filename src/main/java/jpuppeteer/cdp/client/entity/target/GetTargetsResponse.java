package jpuppeteer.cdp.client.entity.target;

/**
*/
public class GetTargetsResponse {

    /**
    * The list of targets.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.target.TargetInfo> targetInfos;

    public GetTargetsResponse(java.util.List<jpuppeteer.cdp.client.entity.target.TargetInfo> targetInfos) {
        this.targetInfos = targetInfos;
    }

}