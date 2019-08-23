package jpuppeteer.cdp.cdp.entity.target;

/**
*/
@lombok.Setter
@lombok.Getter
@lombok.ToString
public class AttachToTargetRequest {

    /**
    */
    private String targetId;

    /**
    * Enables "flat" access to the session via specifying sessionId attribute in the commands.
    */
    private Boolean flatten;



}