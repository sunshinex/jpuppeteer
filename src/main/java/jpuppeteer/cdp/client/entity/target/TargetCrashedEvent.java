package jpuppeteer.cdp.client.entity.target;

/**
* Issued when a target has crashed.
*/
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

    public void setTargetId (String targetId) {
        this.targetId = targetId;
    }

    public String getTargetId() {
        return this.targetId;
    }

    public void setStatus (String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setErrorCode (Integer errorCode) {
        this.errorCode = errorCode;
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }

    public TargetCrashedEvent(String targetId, String status, Integer errorCode) {
        this.targetId = targetId;
        this.status = status;
        this.errorCode = errorCode;
    }

    public TargetCrashedEvent() {
    }

}