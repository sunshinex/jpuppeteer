package jpuppeteer.cdp.client.entity.debugger;

/**
* Fired when the virtual machine stopped on breakpoint or exception or any other stop criteria.
*/
public class PausedEvent {

    /**
    * Call stack the virtual machine stopped on.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.debugger.CallFrame> callFrames;

    /**
    * Pause reason.
    */
    private jpuppeteer.cdp.client.constant.debugger.PausedEventReason reason;

    /**
    * Object containing break-specific auxiliary properties.
    */
    private java.util.Map<String, Object> data;

    /**
    * Hit breakpoints IDs
    */
    private java.util.List<String> hitBreakpoints;

    /**
    * Async stack trace, if any.
    */
    private jpuppeteer.cdp.client.entity.runtime.StackTrace asyncStackTrace;

    /**
    * Async stack trace, if any.
    */
    private jpuppeteer.cdp.client.entity.runtime.StackTraceId asyncStackTraceId;

    /**
    * Never present, will be removed.
    */
    private jpuppeteer.cdp.client.entity.runtime.StackTraceId asyncCallStackTraceId;

    public void setCallFrames (java.util.List<jpuppeteer.cdp.client.entity.debugger.CallFrame> callFrames) {
        this.callFrames = callFrames;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.debugger.CallFrame> getCallFrames() {
        return this.callFrames;
    }

    public void setReason (jpuppeteer.cdp.client.constant.debugger.PausedEventReason reason) {
        this.reason = reason;
    }

    public jpuppeteer.cdp.client.constant.debugger.PausedEventReason getReason() {
        return this.reason;
    }

    public void setData (java.util.Map<String, Object> data) {
        this.data = data;
    }

    public java.util.Map<String, Object> getData() {
        return this.data;
    }

    public void setHitBreakpoints (java.util.List<String> hitBreakpoints) {
        this.hitBreakpoints = hitBreakpoints;
    }

    public java.util.List<String> getHitBreakpoints() {
        return this.hitBreakpoints;
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

    public void setAsyncCallStackTraceId (jpuppeteer.cdp.client.entity.runtime.StackTraceId asyncCallStackTraceId) {
        this.asyncCallStackTraceId = asyncCallStackTraceId;
    }

    public jpuppeteer.cdp.client.entity.runtime.StackTraceId getAsyncCallStackTraceId() {
        return this.asyncCallStackTraceId;
    }

    public PausedEvent(java.util.List<jpuppeteer.cdp.client.entity.debugger.CallFrame> callFrames, jpuppeteer.cdp.client.constant.debugger.PausedEventReason reason, java.util.Map<String, Object> data, java.util.List<String> hitBreakpoints, jpuppeteer.cdp.client.entity.runtime.StackTrace asyncStackTrace, jpuppeteer.cdp.client.entity.runtime.StackTraceId asyncStackTraceId, jpuppeteer.cdp.client.entity.runtime.StackTraceId asyncCallStackTraceId) {
        this.callFrames = callFrames;
        this.reason = reason;
        this.data = data;
        this.hitBreakpoints = hitBreakpoints;
        this.asyncStackTrace = asyncStackTrace;
        this.asyncStackTraceId = asyncStackTraceId;
        this.asyncCallStackTraceId = asyncCallStackTraceId;
    }

    public PausedEvent(java.util.List<jpuppeteer.cdp.client.entity.debugger.CallFrame> callFrames, jpuppeteer.cdp.client.constant.debugger.PausedEventReason reason) {
        this.callFrames = callFrames;
        this.reason = reason;
        this.data = null;
        this.hitBreakpoints = null;
        this.asyncStackTrace = null;
        this.asyncStackTraceId = null;
        this.asyncCallStackTraceId = null;
    }

    public PausedEvent() {
    }

}