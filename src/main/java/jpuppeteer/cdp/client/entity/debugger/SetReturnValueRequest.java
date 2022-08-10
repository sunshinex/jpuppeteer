package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetReturnValueRequest {

    /**
    * New return value.
    */
    private jpuppeteer.cdp.client.entity.runtime.CallArgument newValue;

    public void setNewValue (jpuppeteer.cdp.client.entity.runtime.CallArgument newValue) {
        this.newValue = newValue;
    }

    public jpuppeteer.cdp.client.entity.runtime.CallArgument getNewValue() {
        return this.newValue;
    }

    public SetReturnValueRequest(jpuppeteer.cdp.client.entity.runtime.CallArgument newValue) {
        this.newValue = newValue;
    }

    public SetReturnValueRequest() {
    }

}