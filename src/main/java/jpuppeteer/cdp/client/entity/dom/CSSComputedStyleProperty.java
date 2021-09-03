package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class CSSComputedStyleProperty {

    /**
    * Computed style property name.
    */
    public final String name;

    /**
    * Computed style property value.
    */
    public final String value;

    public CSSComputedStyleProperty(String name, String value) {
        this.name = name;
        this.value = value;
    }

}