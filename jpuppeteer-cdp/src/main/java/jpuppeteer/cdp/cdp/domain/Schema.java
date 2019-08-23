package jpuppeteer.cdp.cdp.domain;

/**
*/
public class Schema {

    private jpuppeteer.cdp.CDPSession session;

    public Schema(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Returns supported domains.
    */
    public jpuppeteer.cdp.cdp.entity.schema.GetDomainsResponse getDomains(int timeout) throws Exception {
        return session.send("Schema.getDomains", null, jpuppeteer.cdp.cdp.entity.schema.GetDomainsResponse.class, timeout);
    }

}