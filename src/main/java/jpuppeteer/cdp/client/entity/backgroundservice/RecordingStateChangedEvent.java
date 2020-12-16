package jpuppeteer.cdp.client.entity.backgroundservice;

/**
* Called when the recording state for the service has been updated.
* experimental
*/
public class RecordingStateChangedEvent {

    /**
    */
    public final Boolean isRecording;

    /**
    */
    public final jpuppeteer.cdp.client.constant.backgroundservice.ServiceName service;

    public RecordingStateChangedEvent(Boolean isRecording, jpuppeteer.cdp.client.constant.backgroundservice.ServiceName service) {
        this.isRecording = isRecording;
        this.service = service;
    }

}