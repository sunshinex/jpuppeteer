package jpuppeteer.cdp.client.entity.storage;

/**
* experimental
*/
public class GetUsageAndQuotaRequest {

    /**
    * Security origin.
    */
    private String origin;

    public void setOrigin (String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return this.origin;
    }

    public GetUsageAndQuotaRequest(String origin) {
        this.origin = origin;
    }

    public GetUsageAndQuotaRequest() {
    }

}