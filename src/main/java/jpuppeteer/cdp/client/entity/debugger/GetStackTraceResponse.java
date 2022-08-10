package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class GetStackTraceResponse {

    /**
    */
    private jpuppeteer.cdp.client.entity.runtime.StackTrace stackTrace;

    public void setStackTrace (jpuppeteer.cdp.client.entity.runtime.StackTrace stackTrace) {
        this.stackTrace = stackTrace;
    }

    public jpuppeteer.cdp.client.entity.runtime.StackTrace getStackTrace() {
        return this.stackTrace;
    }

    public GetStackTraceResponse(jpuppeteer.cdp.client.entity.runtime.StackTrace stackTrace) {
        this.stackTrace = stackTrace;
    }

    public GetStackTraceResponse() {
    }

}