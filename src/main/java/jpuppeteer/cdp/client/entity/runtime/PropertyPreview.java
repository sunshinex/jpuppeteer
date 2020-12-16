package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class PropertyPreview {

    /**
    * Property name.
    */
    public final String name;

    /**
    * Object type. Accessor means that the property itself is an accessor property.
    */
    public final jpuppeteer.cdp.client.constant.runtime.PropertyPreviewType type;

    /**
    * User-friendly property value string.
    */
    public final String value;

    /**
    * Nested value preview.
    */
    public final ObjectPreview valuePreview;

    /**
    * Object subtype hint. Specified for `object` type values only.
    */
    public final jpuppeteer.cdp.client.constant.runtime.PropertyPreviewSubtype subtype;

    public PropertyPreview(String name, jpuppeteer.cdp.client.constant.runtime.PropertyPreviewType type, String value, ObjectPreview valuePreview, jpuppeteer.cdp.client.constant.runtime.PropertyPreviewSubtype subtype) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.valuePreview = valuePreview;
        this.subtype = subtype;
    }

    public PropertyPreview(String name, jpuppeteer.cdp.client.constant.runtime.PropertyPreviewType type) {
        this.name = name;
        this.type = type;
        this.value = null;
        this.valuePreview = null;
        this.subtype = null;
    }

}