package jpuppeteer.cdp.client.entity.domdebugger;

/**
*/
public class GetEventListenersResponse {

    /**
    * Array of relevant listeners.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.domdebugger.EventListener> listeners;

    public GetEventListenersResponse(java.util.List<jpuppeteer.cdp.client.entity.domdebugger.EventListener> listeners) {
        this.listeners = listeners;
    }

}