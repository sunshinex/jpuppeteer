package jpuppeteer.cdp.cdp.entity.target;

/**
*/
@lombok.Setter
@lombok.Getter
@lombok.ToString
public class GetTargetsResponse {

    /**
    * The list of targets.
    */
    private java.util.List<jpuppeteer.cdp.cdp.entity.target.TargetInfo> targetInfos;



}