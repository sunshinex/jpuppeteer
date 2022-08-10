package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class PropertyPreview {

    /**
    * Property name.
    */
    private String name;

    /**
    * Object type. Accessor means that the property itself is an accessor property.
    */
    private jpuppeteer.cdp.client.constant.runtime.PropertyPreviewType type;

    /**
    * User-friendly property value string.
    */
    private String value;

    /**
    * Nested value preview.
    */
    private jpuppeteer.cdp.client.entity.runtime.ObjectPreview valuePreview;

    /**
    * Object subtype hint. Specified for `object` type values only.
    */
    private jpuppeteer.cdp.client.constant.runtime.PropertyPreviewSubtype subtype;

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setType (jpuppeteer.cdp.client.constant.runtime.PropertyPreviewType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.runtime.PropertyPreviewType getType() {
        return this.type;
    }

    public void setValue (String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setValuePreview (jpuppeteer.cdp.client.entity.runtime.ObjectPreview valuePreview) {
        this.valuePreview = valuePreview;
    }

    public jpuppeteer.cdp.client.entity.runtime.ObjectPreview getValuePreview() {
        return this.valuePreview;
    }

    public void setSubtype (jpuppeteer.cdp.client.constant.runtime.PropertyPreviewSubtype subtype) {
        this.subtype = subtype;
    }

    public jpuppeteer.cdp.client.constant.runtime.PropertyPreviewSubtype getSubtype() {
        return this.subtype;
    }

    public PropertyPreview(String name, jpuppeteer.cdp.client.constant.runtime.PropertyPreviewType type, String value, jpuppeteer.cdp.client.entity.runtime.ObjectPreview valuePreview, jpuppeteer.cdp.client.constant.runtime.PropertyPreviewSubtype subtype) {
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

    public PropertyPreview() {
    }

}