package jpuppeteer.cdp.client.entity.target;

/**
*/
public class GetTargetsResponse {

    /**
    * The list of targets.
    */
    public final java.util.List<TargetInfo> targetInfos;

    public GetTargetsResponse(java.util.List<TargetInfo> targetInfos) {
        this.targetInfos = targetInfos;
    }

}