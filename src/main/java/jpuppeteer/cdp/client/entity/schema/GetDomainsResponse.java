package jpuppeteer.cdp.client.entity.schema;

/**
*/
public class GetDomainsResponse {

    /**
    * List of supported domains.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.schema.Domain> domains;

    public void setDomains (java.util.List<jpuppeteer.cdp.client.entity.schema.Domain> domains) {
        this.domains = domains;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.schema.Domain> getDomains() {
        return this.domains;
    }

    public GetDomainsResponse(java.util.List<jpuppeteer.cdp.client.entity.schema.Domain> domains) {
        this.domains = domains;
    }

    public GetDomainsResponse() {
    }

}