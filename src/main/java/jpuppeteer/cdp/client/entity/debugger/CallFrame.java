package jpuppeteer.cdp.client.entity.debugger;

/**
* JavaScript call frame. Array of call frames form the call stack.
*/
public class CallFrame {

    /**
    * Call frame identifier. This identifier is only valid while the virtual machine is paused.
    */
    private String callFrameId;

    /**
    * Name of the JavaScript function called on this call frame.
    */
    private String functionName;

    /**
    * Location in the source code.
    */
    private jpuppeteer.cdp.client.entity.debugger.Location functionLocation;

    /**
    * Location in the source code.
    */
    private jpuppeteer.cdp.client.entity.debugger.Location location;

    /**
    * JavaScript script name or url.
    */
    private String url;

    /**
    * Scope chain for this call frame.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.debugger.Scope> scopeChain;

    /**
    * `this` object for this call frame.
    */
    private jpuppeteer.cdp.client.entity.runtime.RemoteObject self;

    /**
    * The value being returned, if the function is at return point.
    */
    private jpuppeteer.cdp.client.entity.runtime.RemoteObject returnValue;

    public void setCallFrameId (String callFrameId) {
        this.callFrameId = callFrameId;
    }

    public String getCallFrameId() {
        return this.callFrameId;
    }

    public void setFunctionName (String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionName() {
        return this.functionName;
    }

    public void setFunctionLocation (jpuppeteer.cdp.client.entity.debugger.Location functionLocation) {
        this.functionLocation = functionLocation;
    }

    public jpuppeteer.cdp.client.entity.debugger.Location getFunctionLocation() {
        return this.functionLocation;
    }

    public void setLocation (jpuppeteer.cdp.client.entity.debugger.Location location) {
        this.location = location;
    }

    public jpuppeteer.cdp.client.entity.debugger.Location getLocation() {
        return this.location;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setScopeChain (java.util.List<jpuppeteer.cdp.client.entity.debugger.Scope> scopeChain) {
        this.scopeChain = scopeChain;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.debugger.Scope> getScopeChain() {
        return this.scopeChain;
    }

    public void setSelf (jpuppeteer.cdp.client.entity.runtime.RemoteObject self) {
        this.self = self;
    }

    public jpuppeteer.cdp.client.entity.runtime.RemoteObject getSelf() {
        return this.self;
    }

    public void setReturnValue (jpuppeteer.cdp.client.entity.runtime.RemoteObject returnValue) {
        this.returnValue = returnValue;
    }

    public jpuppeteer.cdp.client.entity.runtime.RemoteObject getReturnValue() {
        return this.returnValue;
    }

    public CallFrame(String callFrameId, String functionName, jpuppeteer.cdp.client.entity.debugger.Location functionLocation, jpuppeteer.cdp.client.entity.debugger.Location location, String url, java.util.List<jpuppeteer.cdp.client.entity.debugger.Scope> scopeChain, jpuppeteer.cdp.client.entity.runtime.RemoteObject self, jpuppeteer.cdp.client.entity.runtime.RemoteObject returnValue) {
        this.callFrameId = callFrameId;
        this.functionName = functionName;
        this.functionLocation = functionLocation;
        this.location = location;
        this.url = url;
        this.scopeChain = scopeChain;
        this.self = self;
        this.returnValue = returnValue;
    }

    public CallFrame(String callFrameId, String functionName, jpuppeteer.cdp.client.entity.debugger.Location location, String url, java.util.List<jpuppeteer.cdp.client.entity.debugger.Scope> scopeChain, jpuppeteer.cdp.client.entity.runtime.RemoteObject self) {
        this.callFrameId = callFrameId;
        this.functionName = functionName;
        this.functionLocation = null;
        this.location = location;
        this.url = url;
        this.scopeChain = scopeChain;
        this.self = self;
        this.returnValue = null;
    }

    public CallFrame() {
    }

}