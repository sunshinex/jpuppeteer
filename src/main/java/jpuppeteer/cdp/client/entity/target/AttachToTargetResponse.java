package jpuppeteer.cdp.client.entity.target;

/**
*/
public class AttachToTargetResponse {

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

    public AttachToTargetResponse(String sessionId) {
        this.sessionId = sessionId;
    }

    public AttachToTargetResponse() {
    }

}