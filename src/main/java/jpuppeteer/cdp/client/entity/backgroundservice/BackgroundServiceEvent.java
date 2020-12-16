package jpuppeteer.cdp.client.entity.backgroundservice;

/**
* experimental
*/
public class BackgroundServiceEvent {

    /**
    * Timestamp of the event (in seconds).
    */
    public final java.math.BigDecimal timestamp;

    /**
    * The origin this event belongs to.
    */
    public final String origin;

    /**
    * The Service Worker ID that initiated the event.
    */
    public final String serviceWorkerRegistrationId;

    /**
    * The Background Service this event belongs to.
    */
    public final jpuppeteer.cdp.client.constant.backgroundservice.ServiceName service;

    /**
    * A description of the event.
    */
    public final String eventName;

    /**
    * An identifier that groups related events together.
    */
    public final String instanceId;

    /**
    * A list of event-specific information.
    */
    public final java.util.List<EventMetadata> eventMetadata;

    public BackgroundServiceEvent(java.math.BigDecimal timestamp, String origin, String serviceWorkerRegistrationId, jpuppeteer.cdp.client.constant.backgroundservice.ServiceName service, String eventName, String instanceId, java.util.List<EventMetadata> eventMetadata) {
        this.timestamp = timestamp;
        this.origin = origin;
        this.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
        this.service = service;
        this.eventName = eventName;
        this.instanceId = instanceId;
        this.eventMetadata = eventMetadata;
    }

}