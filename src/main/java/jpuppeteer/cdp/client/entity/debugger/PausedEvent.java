package jpuppeteer.cdp.client.entity.debugger;

/**
* Fired when the virtual machine stopped on breakpoint or exception or any other stop criteria.
*/
public class PausedEvent {

    /**
    * Call stack the virtual machine stopped on.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.debugger.CallFrame> callFrames;

    /**
    * Pause reason.
    */
    public final String reason;

    /**
    * Object containing break-specific auxiliary properties.
    */
    public final java.util.Map<String, Object> data;

    /**
    * Hit breakpoints IDs
    */
    public final java.util.List<String> hitBreakpoints;

    /**
    * Async stack trace, if any.
    */
    public final jpuppeteer.cdp.client.entity.runtime.StackTrace asyncStackTrace;

    /**
    * Async stack trace, if any.
    */
    public final jpuppeteer.cdp.client.entity.runtime.StackTraceId asyncStackTraceId;

    /**
    * Never present, will be removed.
    */
    public final jpuppeteer.cdp.client.entity.runtime.StackTraceId asyncCallStackTraceId;

    public PausedEvent(java.util.List<jpuppeteer.cdp.client.entity.debugger.CallFrame> callFrames, String reason, java.util.Map<String, Object> data, java.util.List<String> hitBreakpoints, jpuppeteer.cdp.client.entity.runtime.StackTrace asyncStackTrace, jpuppeteer.cdp.client.entity.runtime.StackTraceId asyncStackTraceId, jpuppeteer.cdp.client.entity.runtime.StackTraceId asyncCallStackTraceId) {
        this.callFrames = callFrames;
        this.reason = reason;
        this.data = data;
        this.hitBreakpoints = hitBreakpoints;
        this.asyncStackTrace = asyncStackTrace;
        this.asyncStackTraceId = asyncStackTraceId;
        this.asyncCallStackTraceId = asyncCallStackTraceId;
    }

    public PausedEvent(java.util.List<jpuppeteer.cdp.client.entity.debugger.CallFrame> callFrames, String reason) {
        this.callFrames = callFrames;
        this.reason = reason;
        this.data = null;
        this.hitBreakpoints = null;
        this.asyncStackTrace = null;
        this.asyncStackTraceId = null;
        this.asyncCallStackTraceId = null;
    }

}