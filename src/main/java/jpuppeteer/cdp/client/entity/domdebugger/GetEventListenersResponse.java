package jpuppeteer.cdp.client.entity.domdebugger;

/**
*/
public class GetEventListenersResponse {

    /**
    * Array of relevant listeners.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.domdebugger.EventListener> listeners;

    public void setListeners (java.util.List<jpuppeteer.cdp.client.entity.domdebugger.EventListener> listeners) {
        this.listeners = listeners;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.domdebugger.EventListener> getListeners() {
        return this.listeners;
    }

    public GetEventListenersResponse(java.util.List<jpuppeteer.cdp.client.entity.domdebugger.EventListener> listeners) {
        this.listeners = listeners;
    }

    public GetEventListenersResponse() {
    }

}