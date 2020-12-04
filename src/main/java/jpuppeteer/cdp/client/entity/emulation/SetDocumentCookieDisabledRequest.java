package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetDocumentCookieDisabledRequest {

    /**
    * Whether document.coookie API should be disabled.
    */
    public final Boolean disabled;

    public SetDocumentCookieDisabledRequest(Boolean disabled) {
        this.disabled = disabled;
    }

}