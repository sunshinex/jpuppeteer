package jpuppeteer.cdp.client.entity.runtime;

/**
* Object containing abbreviated remote object value.
*/
public class ObjectPreview {

    /**
    * Object type.
    */
    private jpuppeteer.cdp.client.constant.runtime.ObjectPreviewType type;

    /**
    * Object subtype hint. Specified for `object` type values only.
    */
    private jpuppeteer.cdp.client.constant.runtime.ObjectPreviewSubtype subtype;

    /**
    * String representation of the object.
    */
    private String description;

    /**
    * True iff some of the properties or entries of the original object did not fit.
    */
    private Boolean overflow;

    /**
    * List of the properties.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.runtime.PropertyPreview> properties;

    /**
    * List of the entries. Specified for `map` and `set` subtype values only.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.runtime.EntryPreview> entries;

    public void setType (jpuppeteer.cdp.client.constant.runtime.ObjectPreviewType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.runtime.ObjectPreviewType getType() {
        return this.type;
    }

    public void setSubtype (jpuppeteer.cdp.client.constant.runtime.ObjectPreviewSubtype subtype) {
        this.subtype = subtype;
    }

    public jpuppeteer.cdp.client.constant.runtime.ObjectPreviewSubtype getSubtype() {
        return this.subtype;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setOverflow (Boolean overflow) {
        this.overflow = overflow;
    }

    public Boolean getOverflow() {
        return this.overflow;
    }

    public void setProperties (java.util.List<jpuppeteer.cdp.client.entity.runtime.PropertyPreview> properties) {
        this.properties = properties;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.runtime.PropertyPreview> getProperties() {
        return this.properties;
    }

    public void setEntries (java.util.List<jpuppeteer.cdp.client.entity.runtime.EntryPreview> entries) {
        this.entries = entries;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.runtime.EntryPreview> getEntries() {
        return this.entries;
    }

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

    public ObjectPreview() {
    }

}