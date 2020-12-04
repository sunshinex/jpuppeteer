package jpuppeteer.cdp.client.entity.runtime;

/**
* Object private field descriptor.
*/
public class PrivatePropertyDescriptor {

    /**
    * Private property name.
    */
    public final String name;

    /**
    * The value associated with the private property.
    */
    public final jpuppeteer.cdp.client.entity.runtime.RemoteObject value;

    /**
    * A function which serves as a getter for the private property, or `undefined` if there is no getter (accessor descriptors only).
    */
    public final jpuppeteer.cdp.client.entity.runtime.RemoteObject get;

    /**
    * A function which serves as a setter for the private property, or `undefined` if there is no setter (accessor descriptors only).
    */
    public final jpuppeteer.cdp.client.entity.runtime.RemoteObject set;

    public PrivatePropertyDescriptor(String name, jpuppeteer.cdp.client.entity.runtime.RemoteObject value, jpuppeteer.cdp.client.entity.runtime.RemoteObject get, jpuppeteer.cdp.client.entity.runtime.RemoteObject set) {
        this.name = name;
        this.value = value;
        this.get = get;
        this.set = set;
    }

    public PrivatePropertyDescriptor(String name) {
        this.name = name;
        this.value = null;
        this.get = null;
        this.set = null;
    }

}