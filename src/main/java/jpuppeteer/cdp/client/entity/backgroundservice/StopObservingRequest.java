package jpuppeteer.cdp.client.entity.backgroundservice;

/**
* experimental
*/
public class StopObservingRequest {

    /**
    */
    public final jpuppeteer.cdp.client.constant.backgroundservice.ServiceName service;

    public StopObservingRequest(jpuppeteer.cdp.client.constant.backgroundservice.ServiceName service) {
        this.service = service;
    }

}