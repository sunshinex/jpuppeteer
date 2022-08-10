package jpuppeteer.cdp.client.entity.webaudio;

/**
* experimental
*/
public class GetRealtimeDataRequest {

    /**
    */
    private String contextId;

    public void setContextId (String contextId) {
        this.contextId = contextId;
    }

    public String getContextId() {
        return this.contextId;
    }

    public GetRealtimeDataRequest(String contextId) {
        this.contextId = contextId;
    }

    public GetRealtimeDataRequest() {
    }

}