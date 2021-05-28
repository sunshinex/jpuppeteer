package jpuppeteer.cdp.client.entity.backgroundservice;

/**
* experimental
*/
public class SetRecordingRequest {

    /**
    */
    public final Boolean shouldRecord;

    /**
    */
    public final jpuppeteer.cdp.client.constant.backgroundservice.ServiceName service;

    public SetRecordingRequest(Boolean shouldRecord, jpuppeteer.cdp.client.constant.backgroundservice.ServiceName service) {
        this.shouldRecord = shouldRecord;
        this.service = service;
    }

}