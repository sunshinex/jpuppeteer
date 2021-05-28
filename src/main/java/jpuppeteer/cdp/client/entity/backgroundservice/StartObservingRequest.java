package jpuppeteer.cdp.client.entity.backgroundservice;

/**
* experimental
*/
public class StartObservingRequest {

    /**
    */
    public final jpuppeteer.cdp.client.constant.backgroundservice.ServiceName service;

    public StartObservingRequest(jpuppeteer.cdp.client.constant.backgroundservice.ServiceName service) {
        this.service = service;
    }

}