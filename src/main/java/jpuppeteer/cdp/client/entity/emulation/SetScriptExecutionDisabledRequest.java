package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetScriptExecutionDisabledRequest {

    /**
    * Whether script execution should be disabled in the page.
    */
    private Boolean value;

    public void setValue (Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return this.value;
    }

    public SetScriptExecutionDisabledRequest(Boolean value) {
        this.value = value;
    }

    public SetScriptExecutionDisabledRequest() {
    }

}