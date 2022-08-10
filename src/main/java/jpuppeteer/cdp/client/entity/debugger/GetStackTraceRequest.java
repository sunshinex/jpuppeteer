package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class GetStackTraceRequest {

    /**
    */
    private jpuppeteer.cdp.client.entity.runtime.StackTraceId stackTraceId;

    public void setStackTraceId (jpuppeteer.cdp.client.entity.runtime.StackTraceId stackTraceId) {
        this.stackTraceId = stackTraceId;
    }

    public jpuppeteer.cdp.client.entity.runtime.StackTraceId getStackTraceId() {
        return this.stackTraceId;
    }

    public GetStackTraceRequest(jpuppeteer.cdp.client.entity.runtime.StackTraceId stackTraceId) {
        this.stackTraceId = stackTraceId;
    }

    public GetStackTraceRequest() {
    }

}