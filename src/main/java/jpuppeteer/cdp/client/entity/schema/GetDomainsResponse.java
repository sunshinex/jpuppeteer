package jpuppeteer.cdp.client.entity.schema;

/**
*/
public class GetDomainsResponse {

    /**
    * List of supported domains.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.schema.Domain> domains;

    public GetDomainsResponse(java.util.List<jpuppeteer.cdp.client.entity.schema.Domain> domains) {
        this.domains = domains;
    }

}