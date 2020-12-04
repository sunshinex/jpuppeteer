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
    public final String service;

    public SetRecordingRequest(Boolean shouldRecord, String service) {
        this.shouldRecord = shouldRecord;
        this.service = service;
    }

}