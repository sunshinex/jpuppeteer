package jpuppeteer.cdp.client.domain;

/**
*/
@Deprecated
public class Schema {

    private jpuppeteer.cdp.CDPSession session;

    public Schema(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Returns supported domains.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.schema.GetDomainsResponse> getDomains() {
        return session.send("Schema.getDomains", null, jpuppeteer.cdp.client.entity.schema.GetDomainsResponse.class);
    }

}