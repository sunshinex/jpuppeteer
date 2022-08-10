package jpuppeteer.cdp.client.entity.domsnapshot;

/**
* A Node in the DOM tree.
* experimental
*/
public class DOMNode {

    /**
    * `Node`'s nodeType.
    */
    private Integer nodeType;

    /**
    * `Node`'s nodeName.
    */
    private String nodeName;

    /**
    * `Node`'s nodeValue.
    */
    private String nodeValue;

    /**
    * Only set for textarea elements, contains the text value.
    */
    private String textValue;

    /**
    * Only set for input elements, contains the input's associated text value.
    */
    private String inputValue;

    /**
    * Only set for radio and checkbox input elements, indicates if the element has been checked
    */
    private Boolean inputChecked;

    /**
    * Only set for option elements, indicates if the element has been selected
    */
    private Boolean optionSelected;

    /**
    * `Node`'s id, corresponds to DOM.Node.backendNodeId.
    */
    private Integer backendNodeId;

    /**
    * The indexes of the node's child nodes in the `domNodes` array returned by `getSnapshot`, if any.
    */
    private java.util.List<Integer> childNodeIndexes;

    /**
    * Attributes of an `Element` node.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.NameValue> attributes;

    /**
    * Indexes of pseudo elements associated with this node in the `domNodes` array returned by `getSnapshot`, if any.
    */
    private java.util.List<Integer> pseudoElementIndexes;

    /**
    * The index of the node's related layout tree node in the `layoutTreeNodes` array returned by `getSnapshot`, if any.
    */
    private Integer layoutNodeIndex;

    /**
    * Document URL that `Document` or `FrameOwner` node points to.
    */
    private String documentURL;

    /**
    * Base URL that `Document` or `FrameOwner` node uses for URL completion.
    */
    private String baseURL;

    /**
    * Only set for documents, contains the document's content language.
    */
    private String contentLanguage;

    /**
    * Only set for documents, contains the document's character set encoding.
    */
    private String documentEncoding;

    /**
    * `DocumentType` node's publicId.
    */
    private String publicId;

    /**
    * `DocumentType` node's systemId.
    */
    private String systemId;

    /**
    * Frame ID for frame owner elements and also for the document node.
    */
    private String frameId;

    /**
    * The index of a frame owner element's content document in the `domNodes` array returned by `getSnapshot`, if any.
    */
    private Integer contentDocumentIndex;

    /**
    * Type of a pseudo element node.
    */
    private jpuppeteer.cdp.client.constant.dom.PseudoType pseudoType;

    /**
    * Shadow root type.
    */
    private jpuppeteer.cdp.client.constant.dom.ShadowRootType shadowRootType;

    /**
    * Whether this DOM node responds to mouse clicks. This includes nodes that have had click event listeners attached via JavaScript as well as anchor tags that naturally navigate when clicked.
    */
    private Boolean isClickable;

    /**
    * Details of the node's event listeners, if any.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.domdebugger.EventListener> eventListeners;

    /**
    * The selected url for nodes with a srcset attribute.
    */
    private String currentSourceURL;

    /**
    * The url of the script (if any) that generates this node.
    */
    private String originURL;

    /**
    * Scroll offsets, set when this node is a Document.
    */
    private java.math.BigDecimal scrollOffsetX;

    /**
    */
    private java.math.BigDecimal scrollOffsetY;

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

    public void setNodeValue (String nodeValue) {
        this.nodeValue = nodeValue;
    }

    public String getNodeValue() {
        return this.nodeValue;
    }

    public void setTextValue (String textValue) {
        this.textValue = textValue;
    }

    public String getTextValue() {
        return this.textValue;
    }

    public void setInputValue (String inputValue) {
        this.inputValue = inputValue;
    }

    public String getInputValue() {
        return this.inputValue;
    }

    public void setInputChecked (Boolean inputChecked) {
        this.inputChecked = inputChecked;
    }

    public Boolean getInputChecked() {
        return this.inputChecked;
    }

    public void setOptionSelected (Boolean optionSelected) {
        this.optionSelected = optionSelected;
    }

    public Boolean getOptionSelected() {
        return this.optionSelected;
    }

    public void setBackendNodeId (Integer backendNodeId) {
        this.backendNodeId = backendNodeId;
    }

    public Integer getBackendNodeId() {
        return this.backendNodeId;
    }

    public void setChildNodeIndexes (java.util.List<Integer> childNodeIndexes) {
        this.childNodeIndexes = childNodeIndexes;
    }

    public java.util.List<Integer> getChildNodeIndexes() {
        return this.childNodeIndexes;
    }

    public void setAttributes (java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.NameValue> attributes) {
        this.attributes = attributes;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.NameValue> getAttributes() {
        return this.attributes;
    }

    public void setPseudoElementIndexes (java.util.List<Integer> pseudoElementIndexes) {
        this.pseudoElementIndexes = pseudoElementIndexes;
    }

    public java.util.List<Integer> getPseudoElementIndexes() {
        return this.pseudoElementIndexes;
    }

    public void setLayoutNodeIndex (Integer layoutNodeIndex) {
        this.layoutNodeIndex = layoutNodeIndex;
    }

    public Integer getLayoutNodeIndex() {
        return this.layoutNodeIndex;
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

    public void setContentLanguage (String contentLanguage) {
        this.contentLanguage = contentLanguage;
    }

    public String getContentLanguage() {
        return this.contentLanguage;
    }

    public void setDocumentEncoding (String documentEncoding) {
        this.documentEncoding = documentEncoding;
    }

    public String getDocumentEncoding() {
        return this.documentEncoding;
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

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public void setContentDocumentIndex (Integer contentDocumentIndex) {
        this.contentDocumentIndex = contentDocumentIndex;
    }

    public Integer getContentDocumentIndex() {
        return this.contentDocumentIndex;
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

    public void setIsClickable (Boolean isClickable) {
        this.isClickable = isClickable;
    }

    public Boolean getIsClickable() {
        return this.isClickable;
    }

    public void setEventListeners (java.util.List<jpuppeteer.cdp.client.entity.domdebugger.EventListener> eventListeners) {
        this.eventListeners = eventListeners;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.domdebugger.EventListener> getEventListeners() {
        return this.eventListeners;
    }

    public void setCurrentSourceURL (String currentSourceURL) {
        this.currentSourceURL = currentSourceURL;
    }

    public String getCurrentSourceURL() {
        return this.currentSourceURL;
    }

    public void setOriginURL (String originURL) {
        this.originURL = originURL;
    }

    public String getOriginURL() {
        return this.originURL;
    }

    public void setScrollOffsetX (java.math.BigDecimal scrollOffsetX) {
        this.scrollOffsetX = scrollOffsetX;
    }

    public java.math.BigDecimal getScrollOffsetX() {
        return this.scrollOffsetX;
    }

    public void setScrollOffsetY (java.math.BigDecimal scrollOffsetY) {
        this.scrollOffsetY = scrollOffsetY;
    }

    public java.math.BigDecimal getScrollOffsetY() {
        return this.scrollOffsetY;
    }

    public DOMNode(Integer nodeType, String nodeName, String nodeValue, String textValue, String inputValue, Boolean inputChecked, Boolean optionSelected, Integer backendNodeId, java.util.List<Integer> childNodeIndexes, java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.NameValue> attributes, java.util.List<Integer> pseudoElementIndexes, Integer layoutNodeIndex, String documentURL, String baseURL, String contentLanguage, String documentEncoding, String publicId, String systemId, String frameId, Integer contentDocumentIndex, jpuppeteer.cdp.client.constant.dom.PseudoType pseudoType, jpuppeteer.cdp.client.constant.dom.ShadowRootType shadowRootType, Boolean isClickable, java.util.List<jpuppeteer.cdp.client.entity.domdebugger.EventListener> eventListeners, String currentSourceURL, String originURL, java.math.BigDecimal scrollOffsetX, java.math.BigDecimal scrollOffsetY) {
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

    public DOMNode() {
    }

}