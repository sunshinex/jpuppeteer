package jpuppeteer.cdp.client.entity.target;

/**
* Issued when a target has crashed.
*/
public class TargetCrashedEvent {

    /**
    */
    public final String targetId;

    /**
    * Termination status type.
    */
    public final String status;

    /**
    * Termination error code.
    */
    public final Integer errorCode;

    public TargetCrashedEvent(String targetId, String status, Integer errorCode) {
        this.targetId = targetId;
        this.status = status;
        this.errorCode = errorCode;
    }

}