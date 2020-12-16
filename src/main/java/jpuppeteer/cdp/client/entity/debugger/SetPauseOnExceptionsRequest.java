package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetPauseOnExceptionsRequest {

    /**
    * Pause on exceptions mode.
    */
    public final jpuppeteer.cdp.client.constant.debugger.SetPauseOnExceptionsRequestState state;

    public SetPauseOnExceptionsRequest(jpuppeteer.cdp.client.constant.debugger.SetPauseOnExceptionsRequestState state) {
        this.state = state;
    }

}