package jpuppeteer.cdp.client.entity.backgroundservice;

/**
* Called when the recording state for the service has been updated.
* experimental
*/
public class RecordingStateChangedEvent {

    /**
    */
    private Boolean isRecording;

    /**
    */
    private jpuppeteer.cdp.client.constant.backgroundservice.ServiceName service;

    public void setIsRecording (Boolean isRecording) {
        this.isRecording = isRecording;
    }

    public Boolean getIsRecording() {
        return this.isRecording;
    }

    public void setService (jpuppeteer.cdp.client.constant.backgroundservice.ServiceName service) {
        this.service = service;
    }

    public jpuppeteer.cdp.client.constant.backgroundservice.ServiceName getService() {
        return this.service;
    }

    public RecordingStateChangedEvent(Boolean isRecording, jpuppeteer.cdp.client.constant.backgroundservice.ServiceName service) {
        this.isRecording = isRecording;
        this.service = service;
    }

    public RecordingStateChangedEvent() {
    }

}