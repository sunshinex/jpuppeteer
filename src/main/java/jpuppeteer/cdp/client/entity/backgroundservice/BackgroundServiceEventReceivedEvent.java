package jpuppeteer.cdp.client.entity.backgroundservice;

/**
* Called with all existing backgroundServiceEvents when enabled, and all new events afterwards if enabled and recording.
* experimental
*/
public class BackgroundServiceEventReceivedEvent {

    /**
    */
    private jpuppeteer.cdp.client.entity.backgroundservice.BackgroundServiceEvent backgroundServiceEvent;

    public void setBackgroundServiceEvent (jpuppeteer.cdp.client.entity.backgroundservice.BackgroundServiceEvent backgroundServiceEvent) {
        this.backgroundServiceEvent = backgroundServiceEvent;
    }

    public jpuppeteer.cdp.client.entity.backgroundservice.BackgroundServiceEvent getBackgroundServiceEvent() {
        return this.backgroundServiceEvent;
    }

    public BackgroundServiceEventReceivedEvent(jpuppeteer.cdp.client.entity.backgroundservice.BackgroundServiceEvent backgroundServiceEvent) {
        this.backgroundServiceEvent = backgroundServiceEvent;
    }

    public BackgroundServiceEventReceivedEvent() {
    }

}