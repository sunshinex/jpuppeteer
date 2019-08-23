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
    * Enables "flat" access to the session via specifying sessionId attribute in the commands.
    */
    private Boolean flatten;



}