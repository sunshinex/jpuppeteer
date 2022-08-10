package jpuppeteer.cdp.client.entity.tracing;

/**
* Contains an bucket of collected trace events. When tracing is stopped collected events will be send as a sequence of dataCollected events followed by tracingComplete event.
* experimental
*/
public class DataCollectedEvent {

    /**
    */
    private java.util.List<java.util.Map<String, Object>> value;

    public void setValue (java.util.List<java.util.Map<String, Object>> value) {
        this.value = value;
    }

    public java.util.List<java.util.Map<String, Object>> getValue() {
        return this.value;
    }

    public DataCollectedEvent(java.util.List<java.util.Map<String, Object>> value) {
        this.value = value;
    }

    public DataCollectedEvent() {
    }

}