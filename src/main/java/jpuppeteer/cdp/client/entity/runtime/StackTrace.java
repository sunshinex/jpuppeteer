package jpuppeteer.cdp.client.entity.runtime;

/**
* Call frames for assertions or error messages.
*/
public class StackTrace {

    /**
    * String label of this stack trace. For async traces this may be a name of the function that initiated the async call.
    */
    public final String description;

    /**
    * JavaScript function name.
    */
    public final java.util.List<CallFrame> callFrames;

    /**
    * Asynchronous JavaScript stack trace that preceded this stack, if available.
    */
    public final StackTrace parent;

    /**
    * Asynchronous JavaScript stack trace that preceded this stack, if available.
    */
    public final StackTraceId parentId;

    public StackTrace(String description, java.util.List<CallFrame> callFrames, StackTrace parent, StackTraceId parentId) {
        this.description = description;
        this.callFrames = callFrames;
        this.parent = parent;
        this.parentId = parentId;
    }

    public StackTrace(java.util.List<CallFrame> callFrames) {
        this.description = null;
        this.callFrames = callFrames;
        this.parent = null;
        this.parentId = null;
    }

}