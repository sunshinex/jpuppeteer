package jpuppeteer.cdp.client.entity.runtime;

/**
* Object internal property descriptor. This property isn't normally visible in JavaScript code.
*/
public class InternalPropertyDescriptor {

    /**
    * Conventional property name.
    */
    private String name;

    /**
    * The value associated with the property.
    */
    private jpuppeteer.cdp.client.entity.runtime.RemoteObject value;

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setValue (jpuppeteer.cdp.client.entity.runtime.RemoteObject value) {
        this.value = value;
    }

    public jpuppeteer.cdp.client.entity.runtime.RemoteObject getValue() {
        return this.value;
    }

    public InternalPropertyDescriptor(String name, jpuppeteer.cdp.client.entity.runtime.RemoteObject value) {
        this.name = name;
        this.value = value;
    }

    public InternalPropertyDescriptor(String name) {
        this.name = name;
        this.value = null;
    }

    public InternalPropertyDescriptor() {
    }

}