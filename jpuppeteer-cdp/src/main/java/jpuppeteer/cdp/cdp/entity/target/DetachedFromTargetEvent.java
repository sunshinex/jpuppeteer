package jpuppeteer.cdp.cdp.entity.target;

/**
* Issued when detached from target for any reason (including `detachFromTarget` command). Can be issued multiple times per target if multiple sessions have been attached to it.
*/
@lombok.Setter
@lombok.Getter
@lombok.ToString
public class DetachedFromTargetEvent {

    /**
    * Detached session identifier.
    */
    private String sessionId;

    /**
    * Deprecated.
    */
    private String targetId;



}