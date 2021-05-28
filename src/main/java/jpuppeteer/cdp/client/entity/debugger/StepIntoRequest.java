package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class StepIntoRequest {

    /**
    * Debugger will pause on the execution of the first async task which was scheduled before next pause.
    */
    public final Boolean breakOnAsyncCall;

    /**
    * The skipList specifies location ranges that should be skipped on step into.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.debugger.LocationRange> skipList;

    public StepIntoRequest(Boolean breakOnAsyncCall, java.util.List<jpuppeteer.cdp.client.entity.debugger.LocationRange> skipList) {
        this.breakOnAsyncCall = breakOnAsyncCall;
        this.skipList = skipList;
    }

    public StepIntoRequest() {
        this.breakOnAsyncCall = null;
        this.skipList = null;
    }

}