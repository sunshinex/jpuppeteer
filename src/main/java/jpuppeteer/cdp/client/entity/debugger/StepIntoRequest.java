package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class StepIntoRequest {

    /**
    * Debugger will pause on the execution of the first async task which was scheduled before next pause.
    */
    private Boolean breakOnAsyncCall;

    /**
    * The skipList specifies location ranges that should be skipped on step into.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.debugger.LocationRange> skipList;

    public void setBreakOnAsyncCall (Boolean breakOnAsyncCall) {
        this.breakOnAsyncCall = breakOnAsyncCall;
    }

    public Boolean getBreakOnAsyncCall() {
        return this.breakOnAsyncCall;
    }

    public void setSkipList (java.util.List<jpuppeteer.cdp.client.entity.debugger.LocationRange> skipList) {
        this.skipList = skipList;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.debugger.LocationRange> getSkipList() {
        return this.skipList;
    }

    public StepIntoRequest(Boolean breakOnAsyncCall, java.util.List<jpuppeteer.cdp.client.entity.debugger.LocationRange> skipList) {
        this.breakOnAsyncCall = breakOnAsyncCall;
        this.skipList = skipList;
    }

    public StepIntoRequest() {
        this.breakOnAsyncCall = null;
        this.skipList = null;
    }

}