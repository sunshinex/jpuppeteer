package jpuppeteer.cdp.client.entity.tracing;

/**
* Contains an bucket of collected trace events. When tracing is stopped collected events will be send as a sequence of dataCollected events followed by tracingComplete event.
* experimental
*/
public class DataCollectedEvent {

    /**
    */
    public final java.util.List<java.util.Map<String, Object>> value;

    public DataCollectedEvent(java.util.List<java.util.Map<String, Object>> value) {
        this.value = value;
    }

}