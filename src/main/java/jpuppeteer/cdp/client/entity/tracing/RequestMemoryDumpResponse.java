package jpuppeteer.cdp.client.entity.tracing;

/**
* experimental
*/
public class RequestMemoryDumpResponse {

    /**
    * GUID of the resulting global memory dump.
    */
    public final String dumpGuid;

    /**
    * True iff the global memory dump succeeded.
    */
    public final Boolean success;

    public RequestMemoryDumpResponse(String dumpGuid, Boolean success) {
        this.dumpGuid = dumpGuid;
        this.success = success;
    }

}