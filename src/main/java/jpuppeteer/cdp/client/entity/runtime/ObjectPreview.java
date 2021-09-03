package jpuppeteer.cdp.client.entity.runtime;

/**
* Object containing abbreviated remote object value.
*/
public class ObjectPreview {

    /**
    * Object type.
    */
    public final jpuppeteer.cdp.client.constant.runtime.ObjectPreviewType type;

    /**
    * Object subtype hint. Specified for `object` type values only.
    */
    public final jpuppeteer.cdp.client.constant.runtime.ObjectPreviewSubtype subtype;

    /**
    * String representation of the object.
    */
    public final String description;

    /**
    * True iff some of the properties or entries of the original object did not fit.
    */
    public final Boolean overflow;

    /**
    * List of the properties.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.runtime.PropertyPreview> properties;

    /**
    * List of the entries. Specified for `map` and `set` subtype values only.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.runtime.EntryPreview> entries;

    public ObjectPreview(jpuppeteer.cdp.client.constant.runtime.ObjectPreviewType type, jpuppeteer.cdp.client.constant.runtime.ObjectPreviewSubtype subtype, String description, Boolean overflow, java.util.List<jpuppeteer.cdp.client.entity.runtime.PropertyPreview> properties, java.util.List<jpuppeteer.cdp.client.entity.runtime.EntryPreview> entries) {
        this.type = type;
        this.subtype = subtype;
        this.description = description;
        this.overflow = overflow;
        this.properties = properties;
        this.entries = entries;
    }

    public ObjectPreview(jpuppeteer.cdp.client.constant.runtime.ObjectPreviewType type, Boolean overflow, java.util.List<jpuppeteer.cdp.client.entity.runtime.PropertyPreview> properties) {
        this.type = type;
        this.subtype = null;
        this.description = null;
        this.overflow = overflow;
        this.properties = properties;
        this.entries = null;
    }

}