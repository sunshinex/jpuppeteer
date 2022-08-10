package jpuppeteer.cdp.client.entity.target;

/**
*/
public class AttachToBrowserTargetResponse {

    /**
    * Id assigned to the session.
    */
    private String sessionId;

    public void setSessionId (String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public AttachToBrowserTargetResponse(String sessionId) {
        this.sessionId = sessionId;
    }

    public AttachToBrowserTargetResponse() {
    }

}