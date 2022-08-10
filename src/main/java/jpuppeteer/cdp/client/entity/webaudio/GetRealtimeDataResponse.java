package jpuppeteer.cdp.client.entity.webaudio;

/**
* experimental
*/
public class GetRealtimeDataResponse {

    /**
    */
    private jpuppeteer.cdp.client.entity.webaudio.ContextRealtimeData realtimeData;

    public void setRealtimeData (jpuppeteer.cdp.client.entity.webaudio.ContextRealtimeData realtimeData) {
        this.realtimeData = realtimeData;
    }

    public jpuppeteer.cdp.client.entity.webaudio.ContextRealtimeData getRealtimeData() {
        return this.realtimeData;
    }

    public GetRealtimeDataResponse(jpuppeteer.cdp.client.entity.webaudio.ContextRealtimeData realtimeData) {
        this.realtimeData = realtimeData;
    }

    public GetRealtimeDataResponse() {
    }

}