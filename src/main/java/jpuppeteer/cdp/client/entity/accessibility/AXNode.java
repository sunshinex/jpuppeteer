package jpuppeteer.cdp.client.entity.accessibility;

/**
* A node in the accessibility tree.
* experimental
*/
public class AXNode {

    /**
    * Unique identifier for this node.
    */
    private String nodeId;

    /**
    * Whether this node is ignored for accessibility
    */
    private Boolean ignored;

    /**
    * Collection of reasons why this node is hidden.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXProperty> ignoredReasons;

    /**
    * This `Node`'s role, whether explicit or implicit.
    */
    private jpuppeteer.cdp.client.entity.accessibility.AXValue role;

    /**
    * The accessible name for this `Node`.
    */
    private jpuppeteer.cdp.client.entity.accessibility.AXValue name;

    /**
    * The accessible description for this `Node`.
    */
    private jpuppeteer.cdp.client.entity.accessibility.AXValue description;

    /**
    * The value for this `Node`.
    */
    private jpuppeteer.cdp.client.entity.accessibility.AXValue value;

    /**
    * All other properties
    */
    private java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXProperty> properties;

    /**
    * IDs for each of this node's child nodes.
    */
    private java.util.List<String> childIds;

    /**
    * The backend ID for the associated DOM node, if any.
    */
    private Integer backendDOMNodeId;

    public void setNodeId (String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeId() {
        return this.nodeId;
    }

    public void setIgnored (Boolean ignored) {
        this.ignored = ignored;
    }

    public Boolean getIgnored() {
        return this.ignored;
    }

    public void setIgnoredReasons (java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXProperty> ignoredReasons) {
        this.ignoredReasons = ignoredReasons;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXProperty> getIgnoredReasons() {
        return this.ignoredReasons;
    }

    public void setRole (jpuppeteer.cdp.client.entity.accessibility.AXValue role) {
        this.role = role;
    }

    public jpuppeteer.cdp.client.entity.accessibility.AXValue getRole() {
        return this.role;
    }

    public void setName (jpuppeteer.cdp.client.entity.accessibility.AXValue name) {
        this.name = name;
    }

    public jpuppeteer.cdp.client.entity.accessibility.AXValue getName() {
        return this.name;
    }

    public void setDescription (jpuppeteer.cdp.client.entity.accessibility.AXValue description) {
        this.description = description;
    }

    public jpuppeteer.cdp.client.entity.accessibility.AXValue getDescription() {
        return this.description;
    }

    public void setValue (jpuppeteer.cdp.client.entity.accessibility.AXValue value) {
        this.value = value;
    }

    public jpuppeteer.cdp.client.entity.accessibility.AXValue getValue() {
        return this.value;
    }

    public void setProperties (java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXProperty> properties) {
        this.properties = properties;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.accessibility.AXProperty> getProperties() {
        return this.properties;
    }

    public void setChildIds (java.util.List<String> childIds) {
        this.childIds = childIds;
    }

    public java.util.List<String> getChildIds() {
        return this.childIds;
    }

    public void setBackendDOMNodeId (Integer backendDOMNodeId) {
        this.backendDOMNodeId = backendDOMNodeId;
    }

    public Integer getBackendDOMNodeId() {
        return this.backendDOMNodeId;
    }

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

    public AXNode() {
    }

}