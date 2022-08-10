package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetScriptSourceResponse {

    /**
    * New stack trace in case editing has happened while VM was stopped.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.debugger.CallFrame> callFrames;

    /**
    * Whether current call stack  was modified after applying the changes.
    */
    private Boolean stackChanged;

    /**
    * Async stack trace, if any.
    */
    private jpuppeteer.cdp.client.entity.runtime.StackTrace asyncStackTrace;

    /**
    * Async stack trace, if any.
    */
    private jpuppeteer.cdp.client.entity.runtime.StackTraceId asyncStackTraceId;

    /**
    * Exception details if any.
    */
    private jpuppeteer.cdp.client.entity.runtime.ExceptionDetails exceptionDetails;

    public void setCallFrames (java.util.List<jpuppeteer.cdp.client.entity.debugger.CallFrame> callFrames) {
        this.callFrames = callFrames;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.debugger.CallFrame> getCallFrames() {
        return this.callFrames;
    }

    public void setStackChanged (Boolean stackChanged) {
        this.stackChanged = stackChanged;
    }

    public Boolean getStackChanged() {
        return this.stackChanged;
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

    public void setExceptionDetails (jpuppeteer.cdp.client.entity.runtime.ExceptionDetails exceptionDetails) {
        this.exceptionDetails = exceptionDetails;
    }

    public jpuppeteer.cdp.client.entity.runtime.ExceptionDetails getExceptionDetails() {
        return this.exceptionDetails;
    }

    public SetScriptSourceResponse(java.util.List<jpuppeteer.cdp.client.entity.debugger.CallFrame> callFrames, Boolean stackChanged, jpuppeteer.cdp.client.entity.runtime.StackTrace asyncStackTrace, jpuppeteer.cdp.client.entity.runtime.StackTraceId asyncStackTraceId, jpuppeteer.cdp.client.entity.runtime.ExceptionDetails exceptionDetails) {
        this.callFrames = callFrames;
        this.stackChanged = stackChanged;
        this.asyncStackTrace = asyncStackTrace;
        this.asyncStackTraceId = asyncStackTraceId;
        this.exceptionDetails = exceptionDetails;
    }

    public SetScriptSourceResponse() {
        this.callFrames = null;
        this.stackChanged = null;
        this.asyncStackTrace = null;
        this.asyncStackTraceId = null;
        this.exceptionDetails = null;
    }

}