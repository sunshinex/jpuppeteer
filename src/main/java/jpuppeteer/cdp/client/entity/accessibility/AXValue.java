package jpuppeteer.cdp.client.entity.accessibility;

/**
* A single computed AX property.
* experimental
*/
public class AXValue {

    /**
    * The type of this value.
    */
    private jpuppeteer.cdp.client.constant.accessibility.AXValueType type;

    /**
    * The computed value of this property.
    */
    private Object value;

    /**
    * One or more related nodes, if applicable.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXRelatedNode> relatedNodes;

    /**
    * The sources which contributed to the computation of this property.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXValueSource> sources;

    public void setType (jpuppeteer.cdp.client.constant.accessibility.AXValueType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.accessibility.AXValueType getType() {
        return this.type;
    }

    public void setValue (Object value) {
        this.value = value;
    }

    public Object getValue() {
        return this.value;
    }

    public void setRelatedNodes (java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXRelatedNode> relatedNodes) {
        this.relatedNodes = relatedNodes;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXRelatedNode> getRelatedNodes() {
        return this.relatedNodes;
    }

    public void setSources (java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXValueSource> sources) {
        this.sources = sources;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXValueSource> getSources() {
        return this.sources;
    }

    public AXValue(jpuppeteer.cdp.client.constant.accessibility.AXValueType type, Object value, java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXRelatedNode> relatedNodes, java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXValueSource> sources) {
        this.type = type;
        this.value = value;
        this.relatedNodes = relatedNodes;
        this.sources = sources;
    }

    public AXValue(jpuppeteer.cdp.client.constant.accessibility.AXValueType type) {
        this.type = type;
        this.value = null;
        this.relatedNodes = null;
        this.sources = null;
    }

    public AXValue() {
    }

}