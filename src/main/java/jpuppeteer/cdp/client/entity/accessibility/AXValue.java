package jpuppeteer.cdp.client.entity.accessibility;

/**
* A single computed AX property.
* experimental
*/
public class AXValue {

    /**
    * The type of this value.
    */
    public final jpuppeteer.cdp.client.constant.accessibility.AXValueType type;

    /**
    * The computed value of this property.
    */
    public final Object value;

    /**
    * One or more related nodes, if applicable.
    */
    public final java.util.List<AXRelatedNode> relatedNodes;

    /**
    * The sources which contributed to the computation of this property.
    */
    public final java.util.List<AXValueSource> sources;

    public AXValue(jpuppeteer.cdp.client.constant.accessibility.AXValueType type, Object value, java.util.List<AXRelatedNode> relatedNodes, java.util.List<AXValueSource> sources) {
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

}