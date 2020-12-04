package jpuppeteer.cdp.client.entity.runtime;

/**
* If `debuggerId` is set stack trace comes from another debugger and can be resolved there. This allows to track cross-debugger calls. See `Runtime.StackTrace` and `Debugger.paused` for usages.
*/
public class StackTraceId {

    /**
    */
    public final String id;

    /**
    */
    public final String debuggerId;

    public StackTraceId(String id, String debuggerId) {
        this.id = id;
        this.debuggerId = debuggerId;
    }

    public StackTraceId(String id) {
        this.id = id;
        this.debuggerId = null;
    }

}