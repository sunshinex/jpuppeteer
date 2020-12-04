package jpuppeteer.cdp.client.entity.accessibility;

/**
* experimental
*/
public class AXProperty {

    /**
    * The name of this property.
    */
    public final String name;

    /**
    * The value of this property.
    */
    public final jpuppeteer.cdp.client.entity.accessibility.AXValue value;

    public AXProperty(String name, jpuppeteer.cdp.client.entity.accessibility.AXValue value) {
        this.name = name;
        this.value = value;
    }

}