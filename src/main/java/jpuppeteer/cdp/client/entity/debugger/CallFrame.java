package jpuppeteer.cdp.client.entity.debugger;

/**
* JavaScript call frame. Array of call frames form the call stack.
*/
public class CallFrame {

    /**
    * Call frame identifier. This identifier is only valid while the virtual machine is paused.
    */
    public final String callFrameId;

    /**
    * Name of the JavaScript function called on this call frame.
    */
    public final String functionName;

    /**
    * Location in the source code.
    */
    public final jpuppeteer.cdp.client.entity.debugger.Location functionLocation;

    /**
    * Location in the source code.
    */
    public final jpuppeteer.cdp.client.entity.debugger.Location location;

    /**
    * JavaScript script name or url.
    */
    public final String url;

    /**
    * Scope chain for this call frame.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.debugger.Scope> scopeChain;

    /**
    * `this` object for this call frame.
    */
    public final jpuppeteer.cdp.client.entity.runtime.RemoteObject self;

    /**
    * The value being returned, if the function is at return point.
    */
    public final jpuppeteer.cdp.client.entity.runtime.RemoteObject returnValue;

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

}