package jpuppeteer.cdp.client.entity.domsnapshot;

/**
* A Node in the DOM tree.
* experimental
*/
public class DOMNode {

    /**
    * `Node`'s nodeType.
    */
    public final Integer nodeType;

    /**
    * `Node`'s nodeName.
    */
    public final String nodeName;

    /**
    * `Node`'s nodeValue.
    */
    public final String nodeValue;

    /**
    * Only set for textarea elements, contains the text value.
    */
    public final String textValue;

    /**
    * Only set for input elements, contains the input's associated text value.
    */
    public final String inputValue;

    /**
    * Only set for radio and checkbox input elements, indicates if the element has been checked
    */
    public final Boolean inputChecked;

    /**
    * Only set for option elements, indicates if the element has been selected
    */
    public final Boolean optionSelected;

    /**
    * `Node`'s id, corresponds to DOM.Node.backendNodeId.
    */
    public final Integer backendNodeId;

    /**
    * The indexes of the node's child nodes in the `domNodes` array returned by `getSnapshot`, if any.
    */
    public final java.util.List<Integer> childNodeIndexes;

    /**
    * Attributes of an `Element` node.
    */
    public final java.util.List<NameValue> attributes;

    /**
    * Indexes of pseudo elements associated with this node in the `domNodes` array returned by `getSnapshot`, if any.
    */
    public final java.util.List<Integer> pseudoElementIndexes;

    /**
    * The index of the node's related layout tree node in the `layoutTreeNodes` array returned by `getSnapshot`, if any.
    */
    public final Integer layoutNodeIndex;

    /**
    * Document URL that `Document` or `FrameOwner` node points to.
    */
    public final String documentURL;

    /**
    * Base URL that `Document` or `FrameOwner` node uses for URL completion.
    */
    public final String baseURL;

    /**
    * Only set for documents, contains the document's content language.
    */
    public final String contentLanguage;

    /**
    * Only set for documents, contains the document's character set encoding.
    */
    public final String documentEncoding;

    /**
    * `DocumentType` node's publicId.
    */
    public final String publicId;

    /**
    * `DocumentType` node's systemId.
    */
    public final String systemId;

    /**
    * Frame ID for frame owner elements and also for the document node.
    */
    public final String frameId;

    /**
    * The index of a frame owner element's content document in the `domNodes` array returned by `getSnapshot`, if any.
    */
    public final Integer contentDocumentIndex;

    /**
    * Type of a pseudo element node.
    */
    public final jpuppeteer.cdp.client.constant.dom.PseudoType pseudoType;

    /**
    * Shadow root type.
    */
    public final jpuppeteer.cdp.client.constant.dom.ShadowRootType shadowRootType;

    /**
    * Whether this DOM node responds to mouse clicks. This includes nodes that have had click event listeners attached via JavaScript as well as anchor tags that naturally navigate when clicked.
    */
    public final Boolean isClickable;

    /**
    * Details of the node's event listeners, if any.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.domdebugger.EventListener> eventListeners;

    /**
    * The selected url for nodes with a srcset attribute.
    */
    public final String currentSourceURL;

    /**
    * The url of the script (if any) that generates this node.
    */
    public final String originURL;

    /**
    * Scroll offsets, set when this node is a Document.
    */
    public final java.math.BigDecimal scrollOffsetX;

    /**
    */
    public final java.math.BigDecimal scrollOffsetY;

    public DOMNode(Integer nodeType, String nodeName, String nodeValue, String textValue, String inputValue, Boolean inputChecked, Boolean optionSelected, Integer backendNodeId, java.util.List<Integer> childNodeIndexes, java.util.List<NameValue> attributes, java.util.List<Integer> pseudoElementIndexes, Integer layoutNodeIndex, String documentURL, String baseURL, String contentLanguage, String documentEncoding, String publicId, String systemId, String frameId, Integer contentDocumentIndex, jpuppeteer.cdp.client.constant.dom.PseudoType pseudoType, jpuppeteer.cdp.client.constant.dom.ShadowRootType shadowRootType, Boolean isClickable, java.util.List<jpuppeteer.cdp.client.entity.domdebugger.EventListener> eventListeners, String currentSourceURL, String originURL, java.math.BigDecimal scrollOffsetX, java.math.BigDecimal scrollOffsetY) {
        this.nodeType = nodeType;
        this.nodeName = nodeName;
        this.nodeValue = nodeValue;
        this.textValue = textValue;
        this.inputValue = inputValue;
        this.inputChecked = inputChecked;
        this.optionSelected = optionSelected;
        this.backendNodeId = backendNodeId;
        this.childNodeIndexes = childNodeIndexes;
        this.attributes = attributes;
        this.pseudoElementIndexes = pseudoElementIndexes;
        this.layoutNodeIndex = layoutNodeIndex;
        this.documentURL = documentURL;
        this.baseURL = baseURL;
        this.contentLanguage = contentLanguage;
        this.documentEncoding = documentEncoding;
        this.publicId = publicId;
        this.systemId = systemId;
        this.frameId = frameId;
        this.contentDocumentIndex = contentDocumentIndex;
        this.pseudoType = pseudoType;
        this.shadowRootType = shadowRootType;
        this.isClickable = isClickable;
        this.eventListeners = eventListeners;
        this.currentSourceURL = currentSourceURL;
        this.originURL = originURL;
        this.scrollOffsetX = scrollOffsetX;
        this.scrollOffsetY = scrollOffsetY;
    }

    public DOMNode(Integer nodeType, String nodeName, String nodeValue, Integer backendNodeId) {
        this.nodeType = nodeType;
        this.nodeName = nodeName;
        this.nodeValue = nodeValue;
        this.textValue = null;
        this.inputValue = null;
        this.inputChecked = null;
        this.optionSelected = null;
        this.backendNodeId = backendNodeId;
        this.childNodeIndexes = null;
        this.attributes = null;
        this.pseudoElementIndexes = null;
        this.layoutNodeIndex = null;
        this.documentURL = null;
        this.baseURL = null;
        this.contentLanguage = null;
        this.documentEncoding = null;
        this.publicId = null;
        this.systemId = null;
        this.frameId = null;
        this.contentDocumentIndex = null;
        this.pseudoType = null;
        this.shadowRootType = null;
        this.isClickable = null;
        this.eventListeners = null;
        this.currentSourceURL = null;
        this.originURL = null;
        this.scrollOffsetX = null;
        this.scrollOffsetY = null;
    }

}