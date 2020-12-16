package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetReturnValueRequest {

    /**
    * New return value.
    */
    public final jpuppeteer.cdp.client.entity.runtime.CallArgument newValue;

    public SetReturnValueRequest(jpuppeteer.cdp.client.entity.runtime.CallArgument newValue) {
        this.newValue = newValue;
    }

}