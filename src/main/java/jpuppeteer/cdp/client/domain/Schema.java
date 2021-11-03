package jpuppeteer.cdp.client.domain;

/**
*/
@java.lang.Deprecated
public class Schema {

    private jpuppeteer.cdp.CDPConnection connection;

    public Schema(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Returns supported domains.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.schema.GetDomainsResponse> getDomains() {
        return connection.send("Schema.getDomains", null, jpuppeteer.cdp.client.entity.schema.GetDomainsResponse.class);
    }

}