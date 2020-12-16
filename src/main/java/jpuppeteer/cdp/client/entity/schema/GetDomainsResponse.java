package jpuppeteer.cdp.client.entity.schema;

/**
*/
public class GetDomainsResponse {

    /**
    * List of supported domains.
    */
    public final java.util.List<Domain> domains;

    public GetDomainsResponse(java.util.List<Domain> domains) {
        this.domains = domains;
    }

}