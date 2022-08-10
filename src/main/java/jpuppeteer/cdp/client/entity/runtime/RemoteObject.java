package jpuppeteer.cdp.client.entity.runtime;

/**
* Mirror object referencing original JavaScript object.
*/
public class RemoteObject {

    /**
    * Object type.
    */
    private jpuppeteer.cdp.client.constant.runtime.RemoteObjectType type;

    /**
    * Object subtype hint. Specified for `object` type values only. NOTE: If you change anything here, make sure to also update `subtype` in `ObjectPreview` and `PropertyPreview` below.
    */
    private jpuppeteer.cdp.client.constant.runtime.RemoteObjectSubtype subtype;

    /**
    * Object class (constructor) name. Specified for `object` type values only.
    */
    private String className;

    /**
    * Remote object value in case of primitive values or JSON values (if it was requested).
    */
    private Object value;

    /**
    * Primitive value which can not be JSON-stringified does not have `value`, but gets this property.
    */
    private String unserializableValue;

    /**
    * String representation of the object.
    */
    private String description;

    /**
    * Unique object identifier (for non-primitive values).
    */
    private String objectId;

    /**
    * Preview containing abbreviated property values. Specified for `object` type values only.
    */
    private jpuppeteer.cdp.client.entity.runtime.ObjectPreview preview;

    /**
    */
    private jpuppeteer.cdp.client.entity.runtime.CustomPreview customPreview;

    public void setType (jpuppeteer.cdp.client.constant.runtime.RemoteObjectType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.runtime.RemoteObjectType getType() {
        return this.type;
    }

    public void setSubtype (jpuppeteer.cdp.client.constant.runtime.RemoteObjectSubtype subtype) {
        this.subtype = subtype;
    }

    public jpuppeteer.cdp.client.constant.runtime.RemoteObjectSubtype getSubtype() {
        return this.subtype;
    }

    public void setClassName (String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }

    public void setValue (Object value) {
        this.value = value;
    }

    public Object getValue() {
        return this.value;
    }

    public void setUnserializableValue (String unserializableValue) {
        this.unserializableValue = unserializableValue;
    }

    public String getUnserializableValue() {
        return this.unserializableValue;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setObjectId (String objectId) {
        this.objectId = objectId;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public void setPreview (jpuppeteer.cdp.client.entity.runtime.ObjectPreview preview) {
        this.preview = preview;
    }

    public jpuppeteer.cdp.client.entity.runtime.ObjectPreview getPreview() {
        return this.preview;
    }

    public void setCustomPreview (jpuppeteer.cdp.client.entity.runtime.CustomPreview customPreview) {
        this.customPreview = customPreview;
    }

    public jpuppeteer.cdp.client.entity.runtime.CustomPreview getCustomPreview() {
        return this.customPreview;
    }

    public RemoteObject(jpuppeteer.cdp.client.constant.runtime.RemoteObjectType type, jpuppeteer.cdp.client.constant.runtime.RemoteObjectSubtype subtype, String className, Object value, String unserializableValue, String description, String objectId, jpuppeteer.cdp.client.entity.runtime.ObjectPreview preview, jpuppeteer.cdp.client.entity.runtime.CustomPreview customPreview) {
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

    public RemoteObject(jpuppeteer.cdp.client.constant.runtime.RemoteObjectType type) {
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

    public RemoteObject() {
    }

}