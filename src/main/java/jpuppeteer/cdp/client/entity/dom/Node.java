package jpuppeteer.cdp.client.entity.dom;

/**
* DOM interaction is implemented in terms of mirror objects that represent the actual DOM nodes. DOMNode is a base node mirror type.
*/
public class Node {

    /**
    * Node identifier that is passed into the rest of the DOM messages as the `nodeId`. Backend will only push node with given `id` once. It is aware of all requested nodes and will only fire DOM events for nodes known to the client.
    */
    private Integer nodeId;

    /**
    * The id of the parent node if any.
    */
    private Integer parentId;

    /**
    * The BackendNodeId for this node.
    */
    private Integer backendNodeId;

    /**
    * `Node`'s nodeType.
    */
    private Integer nodeType;

    /**
    * `Node`'s nodeName.
    */
    private String nodeName;

    /**
    * `Node`'s localName.
    */
    private String localName;

    /**
    * `Node`'s nodeValue.
    */
    private String nodeValue;

    /**
    * Child count for `Container` nodes.
    */
    private Integer childNodeCount;

    /**
    * Child nodes of this node when requested with children.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.dom.Node> children;

    /**
    * Attributes of the `Element` node in the form of flat array `[name1, value1, name2, value2]`.
    */
    private java.util.List<String> attributes;

    /**
    * Document URL that `Document` or `FrameOwner` node points to.
    */
    private String documentURL;

    /**
    * Base URL that `Document` or `FrameOwner` node uses for URL completion.
    */
    private String baseURL;

    /**
    * `DocumentType`'s publicId.
    */
    private String publicId;

    /**
    * `DocumentType`'s systemId.
    */
    private String systemId;

    /**
    * `DocumentType`'s internalSubset.
    */
    private String internalSubset;

    /**
    * `Document`'s XML version in case of XML documents.
    */
    private String xmlVersion;

    /**
    * `Attr`'s name.
    */
    private String name;

    /**
    * `Attr`'s value.
    */
    private String value;

    /**
    * Pseudo element type for this node.
    */
    private jpuppeteer.cdp.client.constant.dom.PseudoType pseudoType;

    /**
    * Shadow root type.
    */
    private jpuppeteer.cdp.client.constant.dom.ShadowRootType shadowRootType;

    /**
    * Frame ID for frame owner elements.
    */
    private String frameId;

    /**
    * Content document for frame owner elements.
    */
    private jpuppeteer.cdp.client.entity.dom.Node contentDocument;

    /**
    * Shadow root list for given element host.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.dom.Node> shadowRoots;

    /**
    * Content document fragment for template elements.
    */
    private jpuppeteer.cdp.client.entity.dom.Node templateContent;

    /**
    * Pseudo elements associated with this node.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.dom.Node> pseudoElements;

    /**
    * Deprecated, as the HTML Imports API has been removed (crbug.com/937746). This property used to return the imported document for the HTMLImport links. The property is always undefined now.
    */
    private jpuppeteer.cdp.client.entity.dom.Node importedDocument;

    /**
    * Distributed nodes for given insertion point.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.dom.BackendNode> distributedNodes;

    /**
    * Whether the node is SVG.
    */
    private Boolean isSVG;

    /**
    */
    private jpuppeteer.cdp.client.constant.dom.CompatibilityMode compatibilityMode;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public void setParentId (Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public void setBackendNodeId (Integer backendNodeId) {
        this.backendNodeId = backendNodeId;
    }

    public Integer getBackendNodeId() {
        return this.backendNodeId;
    }

    public void setNodeType (Integer nodeType) {
        this.nodeType = nodeType;
    }

    public Integer getNodeType() {
        return this.nodeType;
    }

    public void setNodeName (String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeName() {
        return this.nodeName;
    }

    public void setLocalName (String localName) {
        this.localName = localName;
    }

    public String getLocalName() {
        return this.localName;
    }

    public void setNodeValue (String nodeValue) {
        this.nodeValue = nodeValue;
    }

    public String getNodeValue() {
        return this.nodeValue;
    }

    public void setChildNodeCount (Integer childNodeCount) {
        this.childNodeCount = childNodeCount;
    }

    public Integer getChildNodeCount() {
        return this.childNodeCount;
    }

    public void setChildren (java.util.List<jpuppeteer.cdp.client.entity.dom.Node> children) {
        this.children = children;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.dom.Node> getChildren() {
        return this.children;
    }

    public void setAttributes (java.util.List<String> attributes) {
        this.attributes = attributes;
    }

    public java.util.List<String> getAttributes() {
        return this.attributes;
    }

    public void setDocumentURL (String documentURL) {
        this.documentURL = documentURL;
    }

    public String getDocumentURL() {
        return this.documentURL;
    }

    public void setBaseURL (String baseURL) {
        this.baseURL = baseURL;
    }

    public String getBaseURL() {
        return this.baseURL;
    }

    public void setPublicId (String publicId) {
        this.publicId = publicId;
    }

    public String getPublicId() {
        return this.publicId;
    }

    public void setSystemId (String systemId) {
        this.systemId = systemId;
    }

    public String getSystemId() {
        return this.systemId;
    }

    public void setInternalSubset (String internalSubset) {
        this.internalSubset = internalSubset;
    }

    public String getInternalSubset() {
        return this.internalSubset;
    }

    public void setXmlVersion (String xmlVersion) {
        this.xmlVersion = xmlVersion;
    }

    public String getXmlVersion() {
        return this.xmlVersion;
    }

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

    public void setPseudoType (jpuppeteer.cdp.client.constant.dom.PseudoType pseudoType) {
        this.pseudoType = pseudoType;
    }

    public jpuppeteer.cdp.client.constant.dom.PseudoType getPseudoType() {
        return this.pseudoType;
    }

    public void setShadowRootType (jpuppeteer.cdp.client.constant.dom.ShadowRootType shadowRootType) {
        this.shadowRootType = shadowRootType;
    }

    public jpuppeteer.cdp.client.constant.dom.ShadowRootType getShadowRootType() {
        return this.shadowRootType;
    }

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public void setContentDocument (jpuppeteer.cdp.client.entity.dom.Node contentDocument) {
        this.contentDocument = contentDocument;
    }

    public jpuppeteer.cdp.client.entity.dom.Node getContentDocument() {
        return this.contentDocument;
    }

    public void setShadowRoots (java.util.List<jpuppeteer.cdp.client.entity.dom.Node> shadowRoots) {
        this.shadowRoots = shadowRoots;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.dom.Node> getShadowRoots() {
        return this.shadowRoots;
    }

    public void setTemplateContent (jpuppeteer.cdp.client.entity.dom.Node templateContent) {
        this.templateContent = templateContent;
    }

    public jpuppeteer.cdp.client.entity.dom.Node getTemplateContent() {
        return this.templateContent;
    }

    public void setPseudoElements (java.util.List<jpuppeteer.cdp.client.entity.dom.Node> pseudoElements) {
        this.pseudoElements = pseudoElements;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.dom.Node> getPseudoElements() {
        return this.pseudoElements;
    }

    public void setImportedDocument (jpuppeteer.cdp.client.entity.dom.Node importedDocument) {
        this.importedDocument = importedDocument;
    }

    public jpuppeteer.cdp.client.entity.dom.Node getImportedDocument() {
        return this.importedDocument;
    }

    public void setDistributedNodes (java.util.List<jpuppeteer.cdp.client.entity.dom.BackendNode> distributedNodes) {
        this.distributedNodes = distributedNodes;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.dom.BackendNode> getDistributedNodes() {
        return this.distributedNodes;
    }

    public void setIsSVG (Boolean isSVG) {
        this.isSVG = isSVG;
    }

    public Boolean getIsSVG() {
        return this.isSVG;
    }

    public void setCompatibilityMode (jpuppeteer.cdp.client.constant.dom.CompatibilityMode compatibilityMode) {
        this.compatibilityMode = compatibilityMode;
    }

    public jpuppeteer.cdp.client.constant.dom.CompatibilityMode getCompatibilityMode() {
        return this.compatibilityMode;
    }

    public Node(Integer nodeId, Integer parentId, Integer backendNodeId, Integer nodeType, String nodeName, String localName, String nodeValue, Integer childNodeCount, java.util.List<jpuppeteer.cdp.client.entity.dom.Node> children, java.util.List<String> attributes, String documentURL, String baseURL, String publicId, String systemId, String internalSubset, String xmlVersion, String name, String value, jpuppeteer.cdp.client.constant.dom.PseudoType pseudoType, jpuppeteer.cdp.client.constant.dom.ShadowRootType shadowRootType, String frameId, jpuppeteer.cdp.client.entity.dom.Node contentDocument, java.util.List<jpuppeteer.cdp.client.entity.dom.Node> shadowRoots, jpuppeteer.cdp.client.entity.dom.Node templateContent, java.util.List<jpuppeteer.cdp.client.entity.dom.Node> pseudoElements, jpuppeteer.cdp.client.entity.dom.Node importedDocument, java.util.List<jpuppeteer.cdp.client.entity.dom.BackendNode> distributedNodes, Boolean isSVG, jpuppeteer.cdp.client.constant.dom.CompatibilityMode compatibilityMode) {
        this.nodeId = nodeId;
        this.parentId = parentId;
        this.backendNodeId = backendNodeId;
        this.nodeType = nodeType;
        this.nodeName = nodeName;
        this.localName = localName;
        this.nodeValue = nodeValue;
        this.childNodeCount = childNodeCount;
        this.children = children;
        this.attributes = attributes;
        this.documentURL = documentURL;
        this.baseURL = baseURL;
        this.publicId = publicId;
        this.systemId = systemId;
        this.internalSubset = internalSubset;
        this.xmlVersion = xmlVersion;
        this.name = name;
        this.value = value;
        this.pseudoType = pseudoType;
        this.shadowRootType = shadowRootType;
        this.frameId = frameId;
        this.contentDocument = contentDocument;
        this.shadowRoots = shadowRoots;
        this.templateContent = templateContent;
        this.pseudoElements = pseudoElements;
        this.importedDocument = importedDocument;
        this.distributedNodes = distributedNodes;
        this.isSVG = isSVG;
        this.compatibilityMode = compatibilityMode;
    }

    public Node(Integer nodeId, Integer backendNodeId, Integer nodeType, String nodeName, String localName, String nodeValue) {
        this.nodeId = nodeId;
        this.parentId = null;
        this.backendNodeId = backendNodeId;
        this.nodeType = nodeType;
        this.nodeName = nodeName;
        this.localName = localName;
        this.nodeValue = nodeValue;
        this.childNodeCount = null;
        this.children = null;
        this.attributes = null;
        this.documentURL = null;
        this.baseURL = null;
        this.publicId = null;
        this.systemId = null;
        this.internalSubset = null;
        this.xmlVersion = null;
        this.name = null;
        this.value = null;
        this.pseudoType = null;
        this.shadowRootType = null;
        this.frameId = null;
        this.contentDocument = null;
        this.shadowRoots = null;
        this.templateContent = null;
        this.pseudoElements = null;
        this.importedDocument = null;
        this.distributedNodes = null;
        this.isSVG = null;
        this.compatibilityMode = null;
    }

    public Node() {
    }

}