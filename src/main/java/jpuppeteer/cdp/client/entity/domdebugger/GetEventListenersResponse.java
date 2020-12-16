package jpuppeteer.cdp.client.entity.domdebugger;

/**
*/
public class GetEventListenersResponse {

    /**
    * Array of relevant listeners.
    */
    public final java.util.List<EventListener> listeners;

    public GetEventListenersResponse(java.util.List<EventListener> listeners) {
        this.listeners = listeners;
    }

}