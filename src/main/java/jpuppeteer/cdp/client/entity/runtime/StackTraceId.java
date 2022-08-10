package jpuppeteer.cdp.client.entity.runtime;

/**
* If `debuggerId` is set stack trace comes from another debugger and can be resolved there. This allows to track cross-debugger calls. See `Runtime.StackTrace` and `Debugger.paused` for usages.
*/
public class StackTraceId {

    /**
    */
    private String id;

    /**
    */
    private String debuggerId;

    public void setId (String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setDebuggerId (String debuggerId) {
        this.debuggerId = debuggerId;
    }

    public String getDebuggerId() {
        return this.debuggerId;
    }

    public StackTraceId(String id, String debuggerId) {
        this.id = id;
        this.debuggerId = debuggerId;
    }

    public StackTraceId(String id) {
        this.id = id;
        this.debuggerId = null;
    }

    public StackTraceId() {
    }

}