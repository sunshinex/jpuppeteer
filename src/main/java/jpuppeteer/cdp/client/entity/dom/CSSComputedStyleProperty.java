package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class CSSComputedStyleProperty {

    /**
    * Computed style property name.
    */
    private String name;

    /**
    * Computed style property value.
    */
    private String value;

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setValue (String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public CSSComputedStyleProperty(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public CSSComputedStyleProperty() {
    }

}