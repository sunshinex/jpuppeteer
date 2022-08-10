package jpuppeteer.cdp.client.entity.backgroundservice;

/**
* experimental
*/
public class SetRecordingRequest {

    /**
    */
    private Boolean shouldRecord;

    /**
    */
    private jpuppeteer.cdp.client.constant.backgroundservice.ServiceName service;

    public void setShouldRecord (Boolean shouldRecord) {
        this.shouldRecord = shouldRecord;
    }

    public Boolean getShouldRecord() {
        return this.shouldRecord;
    }

    public void setService (jpuppeteer.cdp.client.constant.backgroundservice.ServiceName service) {
        this.service = service;
    }

    public jpuppeteer.cdp.client.constant.backgroundservice.ServiceName getService() {
        return this.service;
    }

    public SetRecordingRequest(Boolean shouldRecord, jpuppeteer.cdp.client.constant.backgroundservice.ServiceName service) {
        this.shouldRecord = shouldRecord;
        this.service = service;
    }

    public SetRecordingRequest() {
    }

}