package jpuppeteer.cdp.client.entity.backgroundservice;

/**
* experimental
*/
public class BackgroundServiceEvent {

    /**
    * Timestamp of the event (in seconds).
    */
    private java.math.BigDecimal timestamp;

    /**
    * The origin this event belongs to.
    */
    private String origin;

    /**
    * The Service Worker ID that initiated the event.
    */
    private String serviceWorkerRegistrationId;

    /**
    * The Background Service this event belongs to.
    */
    private jpuppeteer.cdp.client.constant.backgroundservice.ServiceName service;

    /**
    * A description of the event.
    */
    private String eventName;

    /**
    * An identifier that groups related events together.
    */
    private String instanceId;

    /**
    * A list of event-specific information.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.backgroundservice.EventMetadata> eventMetadata;

    public void setTimestamp (java.math.BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public java.math.BigDecimal getTimestamp() {
        return this.timestamp;
    }

    public void setOrigin (String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setServiceWorkerRegistrationId (String serviceWorkerRegistrationId) {
        this.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
    }

    public String getServiceWorkerRegistrationId() {
        return this.serviceWorkerRegistrationId;
    }

    public void setService (jpuppeteer.cdp.client.constant.backgroundservice.ServiceName service) {
        this.service = service;
    }

    public jpuppeteer.cdp.client.constant.backgroundservice.ServiceName getService() {
        return this.service;
    }

    public void setEventName (String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return this.eventName;
    }

    public void setInstanceId (String instanceId) {
        this.instanceId = instanceId;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public void setEventMetadata (java.util.List<jpuppeteer.cdp.client.entity.backgroundservice.EventMetadata> eventMetadata) {
        this.eventMetadata = eventMetadata;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.backgroundservice.EventMetadata> getEventMetadata() {
        return this.eventMetadata;
    }

    public BackgroundServiceEvent(java.math.BigDecimal timestamp, String origin, String serviceWorkerRegistrationId, jpuppeteer.cdp.client.constant.backgroundservice.ServiceName service, String eventName, String instanceId, java.util.List<jpuppeteer.cdp.client.entity.backgroundservice.EventMetadata> eventMetadata) {
        this.timestamp = timestamp;
        this.origin = origin;
        this.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
        this.service = service;
        this.eventName = eventName;
        this.instanceId = instanceId;
        this.eventMetadata = eventMetadata;
    }

    public BackgroundServiceEvent() {
    }

}