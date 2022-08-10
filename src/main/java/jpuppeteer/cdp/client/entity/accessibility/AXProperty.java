package jpuppeteer.cdp.client.entity.accessibility;

/**
* experimental
*/
public class AXProperty {

    /**
    * The name of this property.
    */
    private jpuppeteer.cdp.client.constant.accessibility.AXPropertyName name;

    /**
    * The value of this property.
    */
    private jpuppeteer.cdp.client.entity.accessibility.AXValue value;

    public void setName (jpuppeteer.cdp.client.constant.accessibility.AXPropertyName name) {
        this.name = name;
    }

    public jpuppeteer.cdp.client.constant.accessibility.AXPropertyName getName() {
        return this.name;
    }

    public void setValue (jpuppeteer.cdp.client.entity.accessibility.AXValue value) {
        this.value = value;
    }

    public jpuppeteer.cdp.client.entity.accessibility.AXValue getValue() {
        return this.value;
    }

    public AXProperty(jpuppeteer.cdp.client.constant.accessibility.AXPropertyName name, jpuppeteer.cdp.client.entity.accessibility.AXValue value) {
        this.name = name;
        this.value = value;
    }

    public AXProperty() {
    }

}