package jpuppeteer.cdp.client.entity.tracing;

/**
* experimental
*/
public class RequestMemoryDumpRequest {

    /**
    * Enables more deterministic results by forcing garbage collection
    */
    public final Boolean deterministic;

    public RequestMemoryDumpRequest(Boolean deterministic) {
        this.deterministic = deterministic;
    }

    public RequestMemoryDumpRequest() {
        this.deterministic = null;
    }

}