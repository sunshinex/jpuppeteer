package jpuppeteer.cdp.client.entity.dom;

/**
* DOM interaction is implemented in terms of mirror objects that represent the actual DOM nodes. DOMNode is a base node mirror type.
*/
public class Node {

    /**
    * Node identifier that is passed into the rest of the DOM messages as the `nodeId`. Backend will only push node with given `id` once. It is aware of all requested nodes and will only fire DOM events for nodes known to the client.
    */
    public final Integer nodeId;

    /**
    * The id of the parent node if any.
    */
    public final Integer parentId;

    /**
    * The BackendNodeId for this node.
    */
    public final Integer backendNodeId;

    /**
    * `Node`'s nodeType.
    */
    public final Integer nodeType;

    /**
    * `Node`'s nodeName.
    */
    public final String nodeName;

    /**
    * `Node`'s localName.
    */
    public final String localName;

    /**
    * `Node`'s nodeValue.
    */
    public final String nodeValue;

    /**
    * Child count for `Container` nodes.
    */
    public final Integer childNodeCount;

    /**
    * Child nodes of this node when requested with children.
    */
    public final java.util.List<Node> children;

    /**
    * Attributes of the `Element` node in the form of flat array `[name1, value1, name2, value2]`.
    */
    public final java.util.List<String> attributes;

    /**
    * Document URL that `Document` or `FrameOwner` node points to.
    */
    public final String documentURL;

    /**
    * Base URL that `Document` or `FrameOwner` node uses for URL completion.
    */
    public final String baseURL;

    /**
    * `DocumentType`'s publicId.
    */
    public final String publicId;

    /**
    * `DocumentType`'s systemId.
    */
    public final String systemId;

    /**
    * `DocumentType`'s internalSubset.
    */
    public final String internalSubset;

    /**
    * `Document`'s XML version in case of XML documents.
    */
    public final String xmlVersion;

    /**
    * `Attr`'s name.
    */
    public final String name;

    /**
    * `Attr`'s value.
    */
    public final String value;

    /**
    * Pseudo element type for this node.
    */
    public final jpuppeteer.cdp.client.constant.dom.PseudoType pseudoType;

    /**
    * Shadow root type.
    */
    public final jpuppeteer.cdp.client.constant.dom.ShadowRootType shadowRootType;

    /**
    * Frame ID for frame owner elements.
    */
    public final String frameId;

    /**
    * Content document for frame owner elements.
    */
    public final Node contentDocument;

    /**
    * Shadow root list for given element host.
    */
    public final java.util.List<Node> shadowRoots;

    /**
    * Content document fragment for template elements.
    */
    public final Node templateContent;

    /**
    * Pseudo elements associated with this node.
    */
    public final java.util.List<Node> pseudoElements;

    /**
    * Import document for the HTMLImport links.
    */
    public final Node importedDocument;

    /**
    * Distributed nodes for given insertion point.
    */
    public final java.util.List<BackendNode> distributedNodes;

    /**
    * Whether the node is SVG.
    */
    public final Boolean isSVG;

    public Node(Integer nodeId, Integer parentId, Integer backendNodeId, Integer nodeType, String nodeName, String localName, String nodeValue, Integer childNodeCount, java.util.List<Node> children, java.util.List<String> attributes, String documentURL, String baseURL, String publicId, String systemId, String internalSubset, String xmlVersion, String name, String value, jpuppeteer.cdp.client.constant.dom.PseudoType pseudoType, jpuppeteer.cdp.client.constant.dom.ShadowRootType shadowRootType, String frameId, Node contentDocument, java.util.List<Node> shadowRoots, Node templateContent, java.util.List<Node> pseudoElements, Node importedDocument, java.util.List<BackendNode> distributedNodes, Boolean isSVG) {
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
    }

}