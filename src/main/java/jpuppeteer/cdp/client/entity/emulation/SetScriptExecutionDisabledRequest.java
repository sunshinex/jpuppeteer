package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetScriptExecutionDisabledRequest {

    /**
    * Whether script execution should be disabled in the page.
    */
    public final Boolean value;

    public SetScriptExecutionDisabledRequest(Boolean value) {
        this.value = value;
    }

}