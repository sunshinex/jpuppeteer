package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class GetStackTraceResponse {

    /**
    */
    public final jpuppeteer.cdp.client.entity.runtime.StackTrace stackTrace;

    public GetStackTraceResponse(jpuppeteer.cdp.client.entity.runtime.StackTrace stackTrace) {
        this.stackTrace = stackTrace;
    }

}