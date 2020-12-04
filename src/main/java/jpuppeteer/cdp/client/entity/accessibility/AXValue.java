package jpuppeteer.cdp.client.entity.accessibility;

/**
* A single computed AX property.
* experimental
*/
public class AXValue {

    /**
    * The type of this value.
    */
    public final String type;

    /**
    * The computed value of this property.
    */
    public final Object value;

    /**
    * One or more related nodes, if applicable.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXRelatedNode> relatedNodes;

    /**
    * The sources which contributed to the computation of this property.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXValueSource> sources;

    public AXValue(String type, Object value, java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXRelatedNode> relatedNodes, java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXValueSource> sources) {
        this.type = type;
        this.value = value;
        this.relatedNodes = relatedNodes;
        this.sources = sources;
    }

    public AXValue(String type) {
        this.type = type;
        this.value = null;
        this.relatedNodes = null;
        this.sources = null;
    }

}