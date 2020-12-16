package jpuppeteer.cdp.client.entity.runtime;

/**
* Represents function call argument. Either remote object id `objectId`, primitive `value`, unserializable primitive value or neither of (for undefined) them should be specified.
*/
public class CallArgument {

    /**
    * Primitive value or serializable javascript object.
    */
    public final Object value;

    /**
    * Primitive value which can not be JSON-stringified.
    */
    public final String unserializableValue;

    /**
    * Remote object handle.
    */
    public final String objectId;

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