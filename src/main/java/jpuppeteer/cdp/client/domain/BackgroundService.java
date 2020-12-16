package jpuppeteer.cdp.client.domain;

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
    */
    public io.netty.util.concurrent.Future startObserving(jpuppeteer.cdp.client.entity.backgroundservice.StartObservingRequest request) {
        return session.send("BackgroundService.startObserving", request);
    }


    /**
    * Disables event updates for the service.
    */
    public io.netty.util.concurrent.Future stopObserving(jpuppeteer.cdp.client.entity.backgroundservice.StopObservingRequest request) {
        return session.send("BackgroundService.stopObserving", request);
    }


    /**
    * Set the recording state for the service.
    */
    public io.netty.util.concurrent.Future setRecording(jpuppeteer.cdp.client.entity.backgroundservice.SetRecordingRequest request) {
        return session.send("BackgroundService.setRecording", request);
    }


    /**
    * Clears all stored data for the service.
    */
    public io.netty.util.concurrent.Future clearEvents(jpuppeteer.cdp.client.entity.backgroundservice.ClearEventsRequest request) {
        return session.send("BackgroundService.clearEvents", request);
    }

}