package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class PauseOnAsyncCallRequest {

    /**
    * Debugger will pause when async call with given stack trace is started.
    */
    public final jpuppeteer.cdp.client.entity.runtime.StackTraceId parentStackTraceId;

    public PauseOnAsyncCallRequest(jpuppeteer.cdp.client.entity.runtime.StackTraceId parentStackTraceId) {
        this.parentStackTraceId = parentStackTraceId;
    }

}