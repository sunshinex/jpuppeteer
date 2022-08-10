package jpuppeteer.cdp.client.entity.performancetimeline;

/**
* experimental
*/
public class EnableRequest {

    /**
    * The types of event to report, as specified in https://w3c.github.io/performance-timeline/#dom-performanceentry-entrytype The specified filter overrides any previous filters, passing empty filter disables recording. Note that not all types exposed to the web platform are currently supported.
    */
    private java.util.List<String> eventTypes;

    public void setEventTypes (java.util.List<String> eventTypes) {
        this.eventTypes = eventTypes;
    }

    public java.util.List<String> getEventTypes() {
        return this.eventTypes;
    }

    public EnableRequest(java.util.List<String> eventTypes) {
        this.eventTypes = eventTypes;
    }

    public EnableRequest() {
    }

}