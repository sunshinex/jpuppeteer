package jpuppeteer.cdp.client.entity.target;

/**
*/
public class ExposeDevToolsProtocolRequest {

    /**
    */
    public final String targetId;

    /**
    * Binding name, 'cdp' if not specified.
    */
    public final String bindingName;

    public ExposeDevToolsProtocolRequest(String targetId, String bindingName) {
        this.targetId = targetId;
        this.bindingName = bindingName;
    }

    public ExposeDevToolsProtocolRequest(String targetId) {
        this.targetId = targetId;
        this.bindingName = null;
    }

}