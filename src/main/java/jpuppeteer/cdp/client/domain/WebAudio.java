package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class WebAudio {

    private jpuppeteer.cdp.CDPConnection connection;

    public WebAudio(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Enables the WebAudio domain and starts sending context lifetime events.
    */
    public io.netty.util.concurrent.Future enable() {
        return connection.send("WebAudio.enable", null);
    }


    /**
    * Disables the WebAudio domain.
    */
    public io.netty.util.concurrent.Future disable() {
        return connection.send("WebAudio.disable", null);
    }


    /**
    * Fetch the realtime data from the registered contexts.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.webaudio.GetRealtimeDataResponse> getRealtimeData(jpuppeteer.cdp.client.entity.webaudio.GetRealtimeDataRequest request) {
        return connection.send("WebAudio.getRealtimeData", request, jpuppeteer.cdp.client.entity.webaudio.GetRealtimeDataResponse.class);
    }

}