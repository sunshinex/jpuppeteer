package jpuppeteer.cdp.client.entity.runtime;

/**
* Represents function call argument. Either remote object id `objectId`, primitive `value`, unserializable primitive value or neither of (for undefined) them should be specified.
*/
public class CallArgument {

    /**
    * Primitive value or serializable javascript object.
    */
    private Object value;

    /**
    * Primitive value which can not be JSON-stringified.
    */
    private String unserializableValue;

    /**
    * Remote object handle.
    */
    private String objectId;

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

    public void setObjectId (String objectId) {
        this.objectId = objectId;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public CallArgument(Object value, String unserializableValue, String objectId) {
        this.value = value;
        this.unserializableValue = unserializableValue;
        this.objectId = objectId;
    }

    public CallArgument() {
        this.value = null;
        this.unserializableValue = null;
        this.objectId = null;
    }

}