package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetDocumentCookieDisabledRequest {

    /**
    * Whether document.coookie API should be disabled.
    */
    private Boolean disabled;

    public void setDisabled (Boolean disabled) {
        this.disabled = disabled;
    }

    public Boolean getDisabled() {
        return this.disabled;
    }

    public SetDocumentCookieDisabledRequest(Boolean disabled) {
        this.disabled = disabled;
    }

    public SetDocumentCookieDisabledRequest() {
    }

}