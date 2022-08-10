package jpuppeteer.cdp.client.entity.runtime;

/**
* Object property descriptor.
*/
public class PropertyDescriptor {

    /**
    * Property name or symbol description.
    */
    private String name;

    /**
    * The value associated with the property.
    */
    private jpuppeteer.cdp.client.entity.runtime.RemoteObject value;

    /**
    * True if the value associated with the property may be changed (data descriptors only).
    */
    private Boolean writable;

    /**
    * A function which serves as a getter for the property, or `undefined` if there is no getter (accessor descriptors only).
    */
    private jpuppeteer.cdp.client.entity.runtime.RemoteObject get;

    /**
    * A function which serves as a setter for the property, or `undefined` if there is no setter (accessor descriptors only).
    */
    private jpuppeteer.cdp.client.entity.runtime.RemoteObject set;

    /**
    * True if the type of this property descriptor may be changed and if the property may be deleted from the corresponding object.
    */
    private Boolean configurable;

    /**
    * True if this property shows up during enumeration of the properties on the corresponding object.
    */
    private Boolean enumerable;

    /**
    * True if the result was thrown during the evaluation.
    */
    private Boolean wasThrown;

    /**
    * True if the property is owned for the object.
    */
    private Boolean isOwn;

    /**
    * Property symbol object, if the property is of the `symbol` type.
    */
    private jpuppeteer.cdp.client.entity.runtime.RemoteObject symbol;

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

    public void setWritable (Boolean writable) {
        this.writable = writable;
    }

    public Boolean getWritable() {
        return this.writable;
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

    public void setConfigurable (Boolean configurable) {
        this.configurable = configurable;
    }

    public Boolean getConfigurable() {
        return this.configurable;
    }

    public void setEnumerable (Boolean enumerable) {
        this.enumerable = enumerable;
    }

    public Boolean getEnumerable() {
        return this.enumerable;
    }

    public void setWasThrown (Boolean wasThrown) {
        this.wasThrown = wasThrown;
    }

    public Boolean getWasThrown() {
        return this.wasThrown;
    }

    public void setIsOwn (Boolean isOwn) {
        this.isOwn = isOwn;
    }

    public Boolean getIsOwn() {
        return this.isOwn;
    }

    public void setSymbol (jpuppeteer.cdp.client.entity.runtime.RemoteObject symbol) {
        this.symbol = symbol;
    }

    public jpuppeteer.cdp.client.entity.runtime.RemoteObject getSymbol() {
        return this.symbol;
    }

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

    public PropertyDescriptor() {
    }

}