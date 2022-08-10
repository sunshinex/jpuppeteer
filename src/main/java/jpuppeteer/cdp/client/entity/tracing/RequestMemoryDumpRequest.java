package jpuppeteer.cdp.client.entity.tracing;

/**
* experimental
*/
public class RequestMemoryDumpRequest {

    /**
    * Enables more deterministic results by forcing garbage collection
    */
    private Boolean deterministic;

    /**
    * Specifies level of details in memory dump. Defaults to "detailed".
    */
    private jpuppeteer.cdp.client.constant.tracing.MemoryDumpLevelOfDetail levelOfDetail;

    public void setDeterministic (Boolean deterministic) {
        this.deterministic = deterministic;
    }

    public Boolean getDeterministic() {
        return this.deterministic;
    }

    public void setLevelOfDetail (jpuppeteer.cdp.client.constant.tracing.MemoryDumpLevelOfDetail levelOfDetail) {
        this.levelOfDetail = levelOfDetail;
    }

    public jpuppeteer.cdp.client.constant.tracing.MemoryDumpLevelOfDetail getLevelOfDetail() {
        return this.levelOfDetail;
    }

    public RequestMemoryDumpRequest(Boolean deterministic, jpuppeteer.cdp.client.constant.tracing.MemoryDumpLevelOfDetail levelOfDetail) {
        this.deterministic = deterministic;
        this.levelOfDetail = levelOfDetail;
    }

    public RequestMemoryDumpRequest() {
        this.deterministic = null;
        this.levelOfDetail = null;
    }

}