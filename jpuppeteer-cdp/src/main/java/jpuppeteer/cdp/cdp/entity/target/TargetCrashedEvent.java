package jpuppeteer.cdp.cdp.entity.target;

/**
* Issued when a target has crashed.
*/
@lombok.Setter
@lombok.Getter
@lombok.ToString
public class TargetCrashedEvent {

    /**
    */
    private String targetId;

    /**
    * Termination status type.
    */
    private String status;

    /**
    * Termination error code.
    */
    private Integer errorCode;



}