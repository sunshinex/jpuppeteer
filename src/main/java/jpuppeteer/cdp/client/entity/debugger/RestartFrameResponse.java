package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class RestartFrameResponse {

    /**
    * New stack trace.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.debugger.CallFrame> callFrames;

    /**
    * Async stack trace, if any.
    */
    private jpuppeteer.cdp.client.entity.runtime.StackTrace asyncStackTrace;

    /**
    * Async stack trace, if any.
    */
    private jpuppeteer.cdp.client.entity.runtime.StackTraceId asyncStackTraceId;

    public void setCallFrames (java.util.List<jpuppeteer.cdp.client.entity.debugger.CallFrame> callFrames) {
        this.callFrames = callFrames;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.debugger.CallFrame> getCallFrames() {
        return this.callFrames;
    }

    public void setAsyncStackTrace (jpuppeteer.cdp.client.entity.runtime.StackTrace asyncStackTrace) {
        this.asyncStackTrace = asyncStackTrace;
    }

    public jpuppeteer.cdp.client.entity.runtime.StackTrace getAsyncStackTrace() {
        return this.asyncStackTrace;
    }

    public void setAsyncStackTraceId (jpuppeteer.cdp.client.entity.runtime.StackTraceId asyncStackTraceId) {
        this.asyncStackTraceId = asyncStackTraceId;
    }

    public jpuppeteer.cdp.client.entity.runtime.StackTraceId getAsyncStackTraceId() {
        return this.asyncStackTraceId;
    }

    public RestartFrameResponse(java.util.List<jpuppeteer.cdp.client.entity.debugger.CallFrame> callFrames, jpuppeteer.cdp.client.entity.runtime.StackTrace asyncStackTrace, jpuppeteer.cdp.client.entity.runtime.StackTraceId asyncStackTraceId) {
        this.callFrames = callFrames;
        this.asyncStackTrace = asyncStackTrace;
        this.asyncStackTraceId = asyncStackTraceId;
    }

    public RestartFrameResponse(java.util.List<jpuppeteer.cdp.client.entity.debugger.CallFrame> callFrames) {
        this.callFrames = callFrames;
        this.asyncStackTrace = null;
        this.asyncStackTraceId = null;
    }

    public RestartFrameResponse() {
    }

}