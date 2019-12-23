package jpuppeteer.cdp.cdp.domain;

/**
* experimental
*/
public class BackgroundService {

    private jpuppeteer.cdp.CDPSession session;

    public BackgroundService(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Enables event updates for the service.
    * experimental
    */
    public void startObserving(jpuppeteer.cdp.cdp.entity.backgroundservice.StartObservingRequest request, int timeout) throws Exception {
        session.send("BackgroundService.startObserving", request, timeout);
    }


    /**
    * Disables event updates for the service.
    * experimental
    */
    public void stopObserving(jpuppeteer.cdp.cdp.entity.backgroundservice.StopObservingRequest request, int timeout) throws Exception {
        session.send("BackgroundService.stopObserving", request, timeout);
    }


    /**
    * Set the recording state for the service.
    * experimental
    */
    public void setRecording(jpuppeteer.cdp.cdp.entity.backgroundservice.SetRecordingRequest request, int timeout) throws Exception {
        session.send("BackgroundService.setRecording", request, timeout);
    }


    /**
    * Clears all stored data for the service.
    * experimental
    */
    public void clearEvents(jpuppeteer.cdp.cdp.entity.backgroundservice.ClearEventsRequest request, int timeout) throws Exception {
        session.send("BackgroundService.clearEvents", request, timeout);
    }

}