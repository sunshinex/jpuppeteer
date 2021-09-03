package jpuppeteer.cdp.client.entity.runtime;

/**
* Object property descriptor.
*/
public class PropertyDescriptor {

    /**
    * Property name or symbol description.
    */
    public final String name;

    /**
    * The value associated with the property.
    */
    public final jpuppeteer.cdp.client.entity.runtime.RemoteObject value;

    /**
    * True if the value associated with the property may be changed (data descriptors only).
    */
    public final Boolean writable;

    /**
    * A function which serves as a getter for the property, or `undefined` if there is no getter (accessor descriptors only).
    */
    public final jpuppeteer.cdp.client.entity.runtime.RemoteObject get;

    /**
    * A function which serves as a setter for the property, or `undefined` if there is no setter (accessor descriptors only).
    */
    public final jpuppeteer.cdp.client.entity.runtime.RemoteObject set;

    /**
    * True if the type of this property descriptor may be changed and if the property may be deleted from the corresponding object.
    */
    public final Boolean configurable;

    /**
    * True if this property shows up during enumeration of the properties on the corresponding object.
    */
    public final Boolean enumerable;

    /**
    * True if the result was thrown during the evaluation.
    */
    public final Boolean wasThrown;

    /**
    * True if the property is owned for the object.
    */
    public final Boolean isOwn;

    /**
    * Property symbol object, if the property is of the `symbol` type.
    */
    public final jpuppeteer.cdp.client.entity.runtime.RemoteObject symbol;

    public PropertyDescriptor(String name, jpuppeteer.cdp.client.entity.runtime.RemoteObject value, Boolean writable, jpuppeteer.cdp.client.entity.runtime.RemoteObject get, jpuppeteer.cdp.client.entity.runtime.RemoteObject set, Boolean configurable, Boolean enumerable, Boolean wasThrown, Boolean isOwn, jpuppeteer.cdp.client.entity.runtime.RemoteObject symbol) {
        this.name = name;
        this.value = value;
        this.writable = writable;
        this.get = get;
        this.set = set;
        this.configurable = configurable;
        this.enumerable = enumerable;
        this.wasThrown = wasThrown;
        this.isOwn = isOwn;
        this.symbol = symbol;
    }

    public PropertyDescriptor(String name, Boolean configurable, Boolean enumerable) {
        this.name = name;
        this.value = null;
        this.writable = null;
        this.get = null;
        this.set = null;
        this.configurable = configurable;
        this.enumerable = enumerable;
        this.wasThrown = null;
        this.isOwn = null;
        this.symbol = null;
    }

}