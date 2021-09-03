package jpuppeteer.cdp.client.entity.tracing;

/**
* experimental
*/
public class RequestMemoryDumpRequest {

    /**
    * Enables more deterministic results by forcing garbage collection
    */
    public final Boolean deterministic;

    /**
    * Specifies level of details in memory dump. Defaults to "detailed".
    */
    public final jpuppeteer.cdp.client.constant.tracing.MemoryDumpLevelOfDetail levelOfDetail;

    public RequestMemoryDumpRequest(Boolean deterministic, jpuppeteer.cdp.client.constant.tracing.MemoryDumpLevelOfDetail levelOfDetail) {
        this.deterministic = deterministic;
        this.levelOfDetail = levelOfDetail;
    }

    public RequestMemoryDumpRequest() {
        this.deterministic = null;
        this.levelOfDetail = null;
    }

}