package jpuppeteer.cdp.client.entity.runtime;

/**
* Call frames for assertions or error messages.
*/
public class StackTrace {

    /**
    * String label of this stack trace. For async traces this may be a name of the function that initiated the async call.
    */
    private String description;

    /**
    * JavaScript function name.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.runtime.CallFrame> callFrames;

    /**
    * Asynchronous JavaScript stack trace that preceded this stack, if available.
    */
    private jpuppeteer.cdp.client.entity.runtime.StackTrace parent;

    /**
    * Asynchronous JavaScript stack trace that preceded this stack, if available.
    */
    private jpuppeteer.cdp.client.entity.runtime.StackTraceId parentId;

    public void setDescription (String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setCallFrames (java.util.List<jpuppeteer.cdp.client.entity.runtime.CallFrame> callFrames) {
        this.callFrames = callFrames;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.runtime.CallFrame> getCallFrames() {
        return this.callFrames;
    }

    public void setParent (jpuppeteer.cdp.client.entity.runtime.StackTrace parent) {
        this.parent = parent;
    }

    public jpuppeteer.cdp.client.entity.runtime.StackTrace getParent() {
        return this.parent;
    }

    public void setParentId (jpuppeteer.cdp.client.entity.runtime.StackTraceId parentId) {
        this.parentId = parentId;
    }

    public jpuppeteer.cdp.client.entity.runtime.StackTraceId getParentId() {
        return this.parentId;
    }

    public StackTrace(String description, java.util.List<jpuppeteer.cdp.client.entity.runtime.CallFrame> callFrames, jpuppeteer.cdp.client.entity.runtime.StackTrace parent, jpuppeteer.cdp.client.entity.runtime.StackTraceId parentId) {
        this.description = description;
        this.callFrames = callFrames;
        this.parent = parent;
        this.parentId = parentId;
    }

    public StackTrace(java.util.List<jpuppeteer.cdp.client.entity.runtime.CallFrame> callFrames) {
        this.description = null;
        this.callFrames = callFrames;
        this.parent = null;
        this.parentId = null;
    }

    public StackTrace() {
    }

}