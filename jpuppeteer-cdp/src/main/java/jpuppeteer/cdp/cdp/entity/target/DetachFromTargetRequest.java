package jpuppeteer.cdp.cdp.entity.target;

/**
*/
@lombok.Setter
@lombok.Getter
@lombok.ToString
public class DetachFromTargetRequest {

    /**
    * Session to detach.
    */
    private String sessionId;

    /**
    * Deprecated.
    */
    private String targetId;



}