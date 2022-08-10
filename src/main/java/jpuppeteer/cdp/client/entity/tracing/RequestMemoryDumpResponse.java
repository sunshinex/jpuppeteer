package jpuppeteer.cdp.client.entity.tracing;

/**
* experimental
*/
public class RequestMemoryDumpResponse {

    /**
    * GUID of the resulting global memory dump.
    */
    private String dumpGuid;

    /**
    * True iff the global memory dump succeeded.
    */
    private Boolean success;

    public void setDumpGuid (String dumpGuid) {
        this.dumpGuid = dumpGuid;
    }

    public String getDumpGuid() {
        return this.dumpGuid;
    }

    public void setSuccess (Boolean success) {
        this.success = success;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public RequestMemoryDumpResponse(String dumpGuid, Boolean success) {
        this.dumpGuid = dumpGuid;
        this.success = success;
    }

    public RequestMemoryDumpResponse() {
    }

}