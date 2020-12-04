package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetPauseOnExceptionsRequest {

    /**
    * Pause on exceptions mode.
    */
    public final String state;

    public SetPauseOnExceptionsRequest(String state) {
        this.state = state;
    }

}