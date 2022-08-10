package jpuppeteer.cdp.client.entity.target;

/**
*/
public class SetAutoAttachRequest {

    /**
    * Whether to auto-attach to related targets.
    */
    private Boolean autoAttach;

    /**
    * Whether to pause new targets when attaching to them. Use `Runtime.runIfWaitingForDebugger` to run paused targets.
    */
    private Boolean waitForDebuggerOnStart;

    /**
    * Enables "flat" access to the session via specifying sessionId attribute in the commands. We plan to make this the default, deprecate non-flattened mode, and eventually retire it. See crbug.com/991325.
    */
    private Boolean flatten;

    public void setAutoAttach (Boolean autoAttach) {
        this.autoAttach = autoAttach;
    }

    public Boolean getAutoAttach() {
        return this.autoAttach;
    }

    public void setWaitForDebuggerOnStart (Boolean waitForDebuggerOnStart) {
        this.waitForDebuggerOnStart = waitForDebuggerOnStart;
    }

    public Boolean getWaitForDebuggerOnStart() {
        return this.waitForDebuggerOnStart;
    }

    public void setFlatten (Boolean flatten) {
        this.flatten = flatten;
    }

    public Boolean getFlatten() {
        return this.flatten;
    }

    public SetAutoAttachRequest(Boolean autoAttach, Boolean waitForDebuggerOnStart, Boolean flatten) {
        this.autoAttach = autoAttach;
        this.waitForDebuggerOnStart = waitForDebuggerOnStart;
        this.flatten = flatten;
    }

    public SetAutoAttachRequest(Boolean autoAttach, Boolean waitForDebuggerOnStart) {
        this.autoAttach = autoAttach;
        this.waitForDebuggerOnStart = waitForDebuggerOnStart;
        this.flatten = null;
    }

    public SetAutoAttachRequest() {
    }

}