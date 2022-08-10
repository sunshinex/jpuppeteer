package jpuppeteer.cdp.client.entity.backgroundservice;

/**
* experimental
*/
public class StopObservingRequest {

    /**
    */
    private jpuppeteer.cdp.client.constant.backgroundservice.ServiceName service;

    public void setService (jpuppeteer.cdp.client.constant.backgroundservice.ServiceName service) {
        this.service = service;
    }

    public jpuppeteer.cdp.client.constant.backgroundservice.ServiceName getService() {
        return this.service;
    }

    public StopObservingRequest(jpuppeteer.cdp.client.constant.backgroundservice.ServiceName service) {
        this.service = service;
    }

    public StopObservingRequest() {
    }

}