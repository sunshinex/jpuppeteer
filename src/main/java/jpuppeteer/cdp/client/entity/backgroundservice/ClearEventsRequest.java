package jpuppeteer.cdp.client.entity.backgroundservice;

/**
* experimental
*/
public class ClearEventsRequest {

    /**
    */
    private jpuppeteer.cdp.client.constant.backgroundservice.ServiceName service;

    public void setService (jpuppeteer.cdp.client.constant.backgroundservice.ServiceName service) {
        this.service = service;
    }

    public jpuppeteer.cdp.client.constant.backgroundservice.ServiceName getService() {
        return this.service;
    }

    public ClearEventsRequest(jpuppeteer.cdp.client.constant.backgroundservice.ServiceName service) {
        this.service = service;
    }

    public ClearEventsRequest() {
    }

}