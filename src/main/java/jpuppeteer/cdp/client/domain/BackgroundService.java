package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class BackgroundService {

    private jpuppeteer.cdp.CDPConnection connection;

    public BackgroundService(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Enables event updates for the service.
    */
    public io.netty.util.concurrent.Future startObserving(jpuppeteer.cdp.client.entity.backgroundservice.StartObservingRequest request) {
        return connection.send("BackgroundService.startObserving", request);
    }


    /**
    * Disables event updates for the service.
    */
    public io.netty.util.concurrent.Future stopObserving(jpuppeteer.cdp.client.entity.backgroundservice.StopObservingRequest request) {
        return connection.send("BackgroundService.stopObserving", request);
    }


    /**
    * Set the recording state for the service.
    */
    public io.netty.util.concurrent.Future setRecording(jpuppeteer.cdp.client.entity.backgroundservice.SetRecordingRequest request) {
        return connection.send("BackgroundService.setRecording", request);
    }


    /**
    * Clears all stored data for the service.
    */
    public io.netty.util.concurrent.Future clearEvents(jpuppeteer.cdp.client.entity.backgroundservice.ClearEventsRequest request) {
        return connection.send("BackgroundService.clearEvents", request);
    }

}