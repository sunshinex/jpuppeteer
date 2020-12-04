package jpuppeteer.cdp.client.entity.runtime;

/**
* Mirror object referencing original JavaScript object.
*/
public class RemoteObject {

    /**
    * Object type.
    */
    public final String type;

    /**
    * Object subtype hint. Specified for `object` type values only.
    */
    public final String subtype;

    /**
    * Object class (constructor) name. Specified for `object` type values only.
    */
    public final String className;

    /**
    * Remote object value in case of primitive values or JSON values (if it was requested).
    */
    public final Object value;

    /**
    * Primitive value which can not be JSON-stringified does not have `value`, but gets this property.
    */
    public final String unserializableValue;

    /**
    * String representation of the object.
    */
    public final String description;

    /**
    * Unique object identifier (for non-primitive values).
    */
    public final String objectId;

    /**
    * Preview containing abbreviated property values. Specified for `object` type values only.
    */
    public final jpuppeteer.cdp.client.entity.runtime.ObjectPreview preview;

    /**
    */
    public final jpuppeteer.cdp.client.entity.runtime.CustomPreview customPreview;

    public RemoteObject(String type, String subtype, String className, Object value, String unserializableValue, String description, String objectId, jpuppeteer.cdp.client.entity.runtime.ObjectPreview preview, jpuppeteer.cdp.client.entity.runtime.CustomPreview customPreview) {
        this.type = type;
        this.subtype = subtype;
        this.className = className;
        this.value = value;
        this.unserializableValue = unserializableValue;
        this.description = description;
        this.objectId = objectId;
        this.preview = preview;
        this.customPreview = customPreview;
    }

    public RemoteObject(String type) {
        this.type = type;
        this.subtype = null;
        this.className = null;
        this.value = null;
        this.unserializableValue = null;
        this.description = null;
        this.objectId = null;
        this.preview = null;
        this.customPreview = null;
    }

}