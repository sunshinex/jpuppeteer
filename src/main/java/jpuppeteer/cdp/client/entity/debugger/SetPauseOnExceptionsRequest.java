package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetPauseOnExceptionsRequest {

    /**
    * Pause on exceptions mode.
    */
    private jpuppeteer.cdp.client.constant.debugger.SetPauseOnExceptionsRequestState state;

    public void setState (jpuppeteer.cdp.client.constant.debugger.SetPauseOnExceptionsRequestState state) {
        this.state = state;
    }

    public jpuppeteer.cdp.client.constant.debugger.SetPauseOnExceptionsRequestState getState() {
        return this.state;
    }

    public SetPauseOnExceptionsRequest(jpuppeteer.cdp.client.constant.debugger.SetPauseOnExceptionsRequestState state) {
        this.state = state;
    }

    public SetPauseOnExceptionsRequest() {
    }

}