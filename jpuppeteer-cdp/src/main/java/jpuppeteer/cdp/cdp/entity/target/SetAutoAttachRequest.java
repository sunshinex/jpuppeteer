package jpuppeteer.cdp.cdp.entity.target;

/**
*/
@lombok.Setter
@lombok.Getter
@lombok.ToString
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

    /**
    * Auto-attach to the targets created via window.open from current target.
    */
    private Boolean windowOpen;



}