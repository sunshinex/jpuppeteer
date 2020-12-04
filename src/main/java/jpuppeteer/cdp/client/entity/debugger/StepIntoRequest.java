package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class StepIntoRequest {

    /**
    * Debugger will pause on the execution of the first async task which was scheduled before next pause.
    */
    public final Boolean breakOnAsyncCall;

    public StepIntoRequest(Boolean breakOnAsyncCall) {
        this.breakOnAsyncCall = breakOnAsyncCall;
    }

    public StepIntoRequest() {
        this.breakOnAsyncCall = null;
    }

}