package jpuppeteer.cdp.client.entity.backgroundservice;

/**
* Called with all existing backgroundServiceEvents when enabled, and all new events afterwards if enabled and recording.
* experimental
*/
public class BackgroundServiceEventReceivedEvent {

    /**
    */
    public final jpuppeteer.cdp.client.entity.backgroundservice.BackgroundServiceEvent backgroundServiceEvent;

    public BackgroundServiceEventReceivedEvent(jpuppeteer.cdp.client.entity.backgroundservice.BackgroundServiceEvent backgroundServiceEvent) {
        this.backgroundServiceEvent = backgroundServiceEvent;
    }

}