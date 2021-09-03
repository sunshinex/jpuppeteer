package jpuppeteer.cdp.client.entity.performancetimeline;

/**
* Sent when a performance timeline event is added. See reportPerformanceTimeline method.
* experimental
*/
public class TimelineEventAddedEvent {

    /**
    */
    public final jpuppeteer.cdp.client.entity.performancetimeline.TimelineEvent event;

    public TimelineEventAddedEvent(jpuppeteer.cdp.client.entity.performancetimeline.TimelineEvent event) {
        this.event = event;
    }

}