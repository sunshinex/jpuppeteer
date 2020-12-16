package jpuppeteer.cdp.client.entity.runtime;

/**
* Object internal property descriptor. This property isn't normally visible in JavaScript code.
*/
public class InternalPropertyDescriptor {

    /**
    * Conventional property name.
    */
    public final String name;

    /**
    * The value associated with the property.
    */
    public final RemoteObject value;

    public InternalPropertyDescriptor(String name, RemoteObject value) {
        this.name = name;
        this.value = value;
    }

    public InternalPropertyDescriptor(String name) {
        this.name = name;
        this.value = null;
    }

}