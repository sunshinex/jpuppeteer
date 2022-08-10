package jpuppeteer.cdp.client.entity.runtime;

/**
* Object private field descriptor.
*/
public class PrivatePropertyDescriptor {

    /**
    * Private property name.
    */
    private String name;

    /**
    * The value associated with the private property.
    */
    private jpuppeteer.cdp.client.entity.runtime.RemoteObject value;

    /**
    * A function which serves as a getter for the private property, or `undefined` if there is no getter (accessor descriptors only).
    */
    private jpuppeteer.cdp.client.entity.runtime.RemoteObject get;

    /**
    * A function which serves as a setter for the private property, or `undefined` if there is no setter (accessor descriptors only).
    */
    private jpuppeteer.cdp.client.entity.runtime.RemoteObject set;

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

    public void setGet (jpuppeteer.cdp.client.entity.runtime.RemoteObject get) {
        this.get = get;
    }

    public jpuppeteer.cdp.client.entity.runtime.RemoteObject getGet() {
        return this.get;
    }

    public void setSet (jpuppeteer.cdp.client.entity.runtime.RemoteObject set) {
        this.set = set;
    }

    public jpuppeteer.cdp.client.entity.runtime.RemoteObject getSet() {
        return this.set;
    }

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

    public PrivatePropertyDescriptor() {
    }

}