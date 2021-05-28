package jpuppeteer.cdp.client.entity.target;

/**
*/
public class SetAutoAttachRequest {

    /**
    * Whether to auto-attach to related targets.
    */
    public final Boolean autoAttach;

    /**
    * Whether to pause new targets when attaching to them. Use `Runtime.runIfWaitingForDebugger` to run paused targets.
    */
    public final Boolean waitForDebuggerOnStart;

    /**
    * Enables "flat" access to the session via specifying sessionId attribute in the commands. We plan to make this the default, deprecate non-flattened mode, and eventually retire it. See crbug.com/991325.
    */
    public final Boolean flatten;

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

}