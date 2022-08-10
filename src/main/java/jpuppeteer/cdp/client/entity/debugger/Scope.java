package jpuppeteer.cdp.client.entity.debugger;

/**
* Scope description.
*/
public class Scope {

    /**
    * Scope type.
    */
    private jpuppeteer.cdp.client.constant.debugger.ScopeType type;

    /**
    * Object representing the scope. For `global` and `with` scopes it represents the actual object; for the rest of the scopes, it is artificial transient object enumerating scope variables as its properties.
    */
    private jpuppeteer.cdp.client.entity.runtime.RemoteObject object;

    /**
    */
    private String name;

    /**
    * Location in the source code where scope starts
    */
    private jpuppeteer.cdp.client.entity.debugger.Location startLocation;

    /**
    * Location in the source code where scope ends
    */
    private jpuppeteer.cdp.client.entity.debugger.Location endLocation;

    public void setType (jpuppeteer.cdp.client.constant.debugger.ScopeType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.debugger.ScopeType getType() {
        return this.type;
    }

    public void setObject (jpuppeteer.cdp.client.entity.runtime.RemoteObject object) {
        this.object = object;
    }

    public jpuppeteer.cdp.client.entity.runtime.RemoteObject getObject() {
        return this.object;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setStartLocation (jpuppeteer.cdp.client.entity.debugger.Location startLocation) {
        this.startLocation = startLocation;
    }

    public jpuppeteer.cdp.client.entity.debugger.Location getStartLocation() {
        return this.startLocation;
    }

    public void setEndLocation (jpuppeteer.cdp.client.entity.debugger.Location endLocation) {
        this.endLocation = endLocation;
    }

    public jpuppeteer.cdp.client.entity.debugger.Location getEndLocation() {
        return this.endLocation;
    }

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

    public Scope() {
    }

}