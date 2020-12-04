package jpuppeteer.cdp.client.entity.storage;

/**
* experimental
*/
public class GetUsageAndQuotaRequest {

    /**
    * Security origin.
    */
    public final String origin;

    public GetUsageAndQuotaRequest(String origin) {
        this.origin = origin;
    }

}