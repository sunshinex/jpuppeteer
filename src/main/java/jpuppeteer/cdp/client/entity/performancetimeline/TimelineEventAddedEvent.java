package jpuppeteer.cdp.client.entity.performancetimeline;

/**
* Sent when a performance timeline event is added. See reportPerformanceTimeline method.
* experimental
*/
public class TimelineEventAddedEvent {

    /**
    */
    private jpuppeteer.cdp.client.entity.performancetimeline.TimelineEvent event;

    public void setEvent (jpuppeteer.cdp.client.entity.performancetimeline.TimelineEvent event) {
        this.event = event;
    }

    public jpuppeteer.cdp.client.entity.performancetimeline.TimelineEvent getEvent() {
        return this.event;
    }

    public TimelineEventAddedEvent(jpuppeteer.cdp.client.entity.performancetimeline.TimelineEvent event) {
        this.event = event;
    }

    public TimelineEventAddedEvent() {
    }

}