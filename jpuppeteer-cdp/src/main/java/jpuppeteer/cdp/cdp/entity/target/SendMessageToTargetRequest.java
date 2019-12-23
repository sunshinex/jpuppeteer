package jpuppeteer.cdp.cdp.entity.target;

/**
*/
@lombok.Setter
@lombok.Getter
@lombok.ToString
public class SendMessageToTargetRequest {

    /**
    */
    private String message;

    /**
    * Identifier of the session.
    */
    private String sessionId;

    /**
    * Deprecated.
    */
    private String targetId;



}