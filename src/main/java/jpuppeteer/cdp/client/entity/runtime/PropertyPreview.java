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
    public final String type;

    /**
    * User-friendly property value string.
    */
    public final String value;

    /**
    * Nested value preview.
    */
    public final jpuppeteer.cdp.client.entity.runtime.ObjectPreview valuePreview;

    /**
    * Object subtype hint. Specified for `object` type values only.
    */
    public final String subtype;

    public PropertyPreview(String name, String type, String value, jpuppeteer.cdp.client.entity.runtime.ObjectPreview valuePreview, String subtype) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.valuePreview = valuePreview;
        this.subtype = subtype;
    }

    public PropertyPreview(String name, String type) {
        this.name = name;
        this.type = type;
        this.value = null;
        this.valuePreview = null;
        this.subtype = null;
    }

}