package jpuppeteer.cdp.client.entity.backgroundservice;

/**
* experimental
*/
public class StartObservingRequest {

    /**
    */
    private jpuppeteer.cdp.client.constant.backgroundservice.ServiceName service;

    public void setService (jpuppeteer.cdp.client.constant.backgroundservice.ServiceName service) {
        this.service = service;
    }

    public jpuppeteer.cdp.client.constant.backgroundservice.ServiceName getService() {
        return this.service;
    }

    public StartObservingRequest(jpuppeteer.cdp.client.constant.backgroundservice.ServiceName service) {
        this.service = service;
    }

    public StartObservingRequest() {
    }

}