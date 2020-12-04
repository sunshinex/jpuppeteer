package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class WebAudio {

    private jpuppeteer.cdp.CDPSession session;

    public WebAudio(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Enables the WebAudio domain and starts sending context lifetime events.
    */
    public io.netty.util.concurrent.Future enable() {
        return session.send("WebAudio.enable", null);
    }


    /**
    * Disables the WebAudio domain.
    */
    public io.netty.util.concurrent.Future disable() {
        return session.send("WebAudio.disable", null);
    }


    /**
    * Fetch the realtime data from the registered contexts.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.webaudio.GetRealtimeDataResponse> getRealtimeData(jpuppeteer.cdp.client.entity.webaudio.GetRealtimeDataRequest request) {
        return session.send("WebAudio.getRealtimeData", request, jpuppeteer.cdp.client.entity.webaudio.GetRealtimeDataResponse.class);
    }

}