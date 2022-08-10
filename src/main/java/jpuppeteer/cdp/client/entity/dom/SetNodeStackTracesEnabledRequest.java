package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class SetNodeStackTracesEnabledRequest {

    /**
    * Enable or disable.
    */
    private Boolean enable;

    public void setEnable (Boolean enable) {
        this.enable = enable;
    }

    public Boolean getEnable() {
        return this.enable;
    }

    public SetNodeStackTracesEnabledRequest(Boolean enable) {
        this.enable = enable;
    }

    public SetNodeStackTracesEnabledRequest() {
    }

}