package jpuppeteer.cdp.cdp.domain;

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
    * experimental
    */
    public void enable(int timeout) throws Exception {
        session.send("WebAudio.enable", null, timeout);
    }


    /**
    * Disables the WebAudio domain.
    * experimental
    */
    public void disable(int timeout) throws Exception {
        session.send("WebAudio.disable", null, timeout);
    }


    /**
    * Fetch the realtime data from the registered contexts.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.webaudio.GetRealtimeDataResponse getRealtimeData(jpuppeteer.cdp.cdp.entity.webaudio.GetRealtimeDataRequest request, int timeout) throws Exception {
        return session.send("WebAudio.getRealtimeData", request, jpuppeteer.cdp.cdp.entity.webaudio.GetRealtimeDataResponse.class, timeout);
    }

}