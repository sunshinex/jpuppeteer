package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class GetStackTraceRequest {

    /**
    */
    public final jpuppeteer.cdp.client.entity.runtime.StackTraceId stackTraceId;

    public GetStackTraceRequest(jpuppeteer.cdp.client.entity.runtime.StackTraceId stackTraceId) {
        this.stackTraceId = stackTraceId;
    }

}