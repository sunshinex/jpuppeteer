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
    public final String service;

    public RecordingStateChangedEvent(Boolean isRecording, String service) {
        this.isRecording = isRecording;
        this.service = service;
    }

}