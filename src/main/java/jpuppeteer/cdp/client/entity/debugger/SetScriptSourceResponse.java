package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetScriptSourceResponse {

    /**
    * New stack trace in case editing has happened while VM was stopped.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.debugger.CallFrame> callFrames;

    /**
    * Whether current call stack  was modified after applying the changes.
    */
    public final Boolean stackChanged;

    /**
    * Async stack trace, if any.
    */
    public final jpuppeteer.cdp.client.entity.runtime.StackTrace asyncStackTrace;

    /**
    * Async stack trace, if any.
    */
    public final jpuppeteer.cdp.client.entity.runtime.StackTraceId asyncStackTraceId;

    /**
    * Exception details if any.
    */
    public final jpuppeteer.cdp.client.entity.runtime.ExceptionDetails exceptionDetails;

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