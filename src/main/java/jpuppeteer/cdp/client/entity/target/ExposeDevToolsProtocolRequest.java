package jpuppeteer.cdp.client.entity.target;

/**
*/
public class ExposeDevToolsProtocolRequest {

    /**
    */
    private String targetId;

    /**
    * Binding name, 'cdp' if not specified.
    */
    private String bindingName;

    public void setTargetId (String targetId) {
        this.targetId = targetId;
    }

    public String getTargetId() {
        return this.targetId;
    }

    public void setBindingName (String bindingName) {
        this.bindingName = bindingName;
    }

    public String getBindingName() {
        return this.bindingName;
    }

    public ExposeDevToolsProtocolRequest(String targetId, String bindingName) {
        this.targetId = targetId;
        this.bindingName = bindingName;
    }

    public ExposeDevToolsProtocolRequest(String targetId) {
        this.targetId = targetId;
        this.bindingName = null;
    }

    public ExposeDevToolsProtocolRequest() {
    }

}