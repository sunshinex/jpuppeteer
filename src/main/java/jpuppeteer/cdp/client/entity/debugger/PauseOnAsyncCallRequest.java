package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class PauseOnAsyncCallRequest {

    /**
    * Debugger will pause when async call with given stack trace is started.
    */
    private jpuppeteer.cdp.client.entity.runtime.StackTraceId parentStackTraceId;

    public void setParentStackTraceId (jpuppeteer.cdp.client.entity.runtime.StackTraceId parentStackTraceId) {
        this.parentStackTraceId = parentStackTraceId;
    }

    public jpuppeteer.cdp.client.entity.runtime.StackTraceId getParentStackTraceId() {
        return this.parentStackTraceId;
    }

    public PauseOnAsyncCallRequest(jpuppeteer.cdp.client.entity.runtime.StackTraceId parentStackTraceId) {
        this.parentStackTraceId = parentStackTraceId;
    }

    public PauseOnAsyncCallRequest() {
    }

}