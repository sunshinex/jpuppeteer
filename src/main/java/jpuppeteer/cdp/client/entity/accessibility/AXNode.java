package jpuppeteer.cdp.client.entity.accessibility;

/**
* A node in the accessibility tree.
* experimental
*/
public class AXNode {

    /**
    * Unique identifier for this node.
    */
    public final String nodeId;

    /**
    * Whether this node is ignored for accessibility
    */
    public final Boolean ignored;

    /**
    * Collection of reasons why this node is hidden.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXProperty> ignoredReasons;

    /**
    * This `Node`'s role, whether explicit or implicit.
    */
    public final jpuppeteer.cdp.client.entity.accessibility.AXValue role;

    /**
    * The accessible name for this `Node`.
    */
    public final jpuppeteer.cdp.client.entity.accessibility.AXValue name;

    /**
    * The accessible description for this `Node`.
    */
    public final jpuppeteer.cdp.client.entity.accessibility.AXValue description;

    /**
    * The value for this `Node`.
    */
    public final jpuppeteer.cdp.client.entity.accessibility.AXValue value;

    /**
    * All other properties
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXProperty> properties;

    /**
    * IDs for each of this node's child nodes.
    */
    public final java.util.List<String> childIds;

    /**
    * The backend ID for the associated DOM node, if any.
    */
    public final Integer backendDOMNodeId;

    public AXNode(String nodeId, Boolean ignored, java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXProperty> ignoredReasons, jpuppeteer.cdp.client.entity.accessibility.AXValue role, jpuppeteer.cdp.client.entity.accessibility.AXValue name, jpuppeteer.cdp.client.entity.accessibility.AXValue description, jpuppeteer.cdp.client.entity.accessibility.AXValue value, java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXProperty> properties, java.util.List<String> childIds, Integer backendDOMNodeId) {
        this.nodeId = nodeId;
        this.ignored = ignored;
        this.ignoredReasons = ignoredReasons;
        this.role = role;
        this.name = name;
        this.description = description;
        this.value = value;
        this.properties = properties;
        this.childIds = childIds;
        this.backendDOMNodeId = backendDOMNodeId;
    }

    public AXNode(String nodeId, Boolean ignored) {
        this.nodeId = nodeId;
        this.ignored = ignored;
        this.ignoredReasons = null;
        this.role = null;
        this.name = null;
        this.description = null;
        this.value = null;
        this.properties = null;
        this.childIds = null;
        this.backendDOMNodeId = null;
    }

}