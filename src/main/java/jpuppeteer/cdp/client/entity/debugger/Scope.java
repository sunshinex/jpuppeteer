package jpuppeteer.cdp.client.entity.debugger;

/**
* Scope description.
*/
public class Scope {

    /**
    * Scope type.
    */
    public final jpuppeteer.cdp.client.constant.debugger.ScopeType type;

    /**
    * Object representing the scope. For `global` and `with` scopes it represents the actual object; for the rest of the scopes, it is artificial transient object enumerating scope variables as its properties.
    */
    public final jpuppeteer.cdp.client.entity.runtime.RemoteObject object;

    /**
    */
    public final String name;

    /**
    * Location in the source code where scope starts
    */
    public final jpuppeteer.cdp.client.entity.debugger.Location startLocation;

    /**
    * Location in the source code where scope ends
    */
    public final jpuppeteer.cdp.client.entity.debugger.Location endLocation;

    public Scope(jpuppeteer.cdp.client.constant.debugger.ScopeType type, jpuppeteer.cdp.client.entity.runtime.RemoteObject object, String name, jpuppeteer.cdp.client.entity.debugger.Location startLocation, jpuppeteer.cdp.client.entity.debugger.Location endLocation) {
        this.type = type;
        this.object = object;
        this.name = name;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
    }

    public Scope(jpuppeteer.cdp.client.constant.debugger.ScopeType type, jpuppeteer.cdp.client.entity.runtime.RemoteObject object) {
        this.type = type;
        this.object = object;
        this.name = null;
        this.startLocation = null;
        this.endLocation = null;
    }

}