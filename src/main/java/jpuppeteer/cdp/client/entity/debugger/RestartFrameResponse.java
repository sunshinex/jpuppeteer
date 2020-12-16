package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class RestartFrameResponse {

    /**
    * New stack trace.
    */
    public final java.util.List<CallFrame> callFrames;

    /**
    * Async stack trace, if any.
    */
    public final jpuppeteer.cdp.client.entity.runtime.StackTrace asyncStackTrace;

    /**
    * Async stack trace, if any.
    */
    public final jpuppeteer.cdp.client.entity.runtime.StackTraceId asyncStackTraceId;

    public RestartFrameResponse(java.util.List<CallFrame> callFrames, jpuppeteer.cdp.client.entity.runtime.StackTrace asyncStackTrace, jpuppeteer.cdp.client.entity.runtime.StackTraceId asyncStackTraceId) {
        this.callFrames = callFrames;
        this.asyncStackTrace = asyncStackTrace;
        this.asyncStackTraceId = asyncStackTraceId;
    }

    public RestartFrameResponse(java.util.List<CallFrame> callFrames) {
        this.callFrames = callFrames;
        this.asyncStackTrace = null;
        this.asyncStackTraceId = null;
    }

}