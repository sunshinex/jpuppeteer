package jpuppeteer.cdp.client.entity.domsnapshot;

/**
* Table containing nodes.
* experimental
*/
public class NodeTreeSnapshot {

    /**
    * Parent node index.
    */
    private java.util.List<Integer> parentIndex;

    /**
    * `Node`'s nodeType.
    */
    private java.util.List<Integer> nodeType;

    /**
    * `Node`'s nodeName.
    */
    private java.util.List<Integer> nodeName;

    /**
    * `Node`'s nodeValue.
    */
    private java.util.List<Integer> nodeValue;

    /**
    * `Node`'s id, corresponds to DOM.Node.backendNodeId.
    */
    private java.util.List<Integer> backendNodeId;

    /**
    * Attributes of an `Element` node. Flatten name, value pairs.
    */
    private java.util.List<java.util.List<Integer>> attributes;

    /**
    * Only set for textarea elements, contains the text value.
    */
    private jpuppeteer.cdp.client.entity.domsnapshot.RareStringData textValue;

    /**
    * Only set for input elements, contains the input's associated text value.
    */
    private jpuppeteer.cdp.client.entity.domsnapshot.RareStringData inputValue;

    /**
    * Only set for radio and checkbox input elements, indicates if the element has been checked
    */
    private jpuppeteer.cdp.client.entity.domsnapshot.RareBooleanData inputChecked;

    /**
    * Only set for option elements, indicates if the element has been selected
    */
    private jpuppeteer.cdp.client.entity.domsnapshot.RareBooleanData optionSelected;

    /**
    * The index of the document in the list of the snapshot documents.
    */
    private jpuppeteer.cdp.client.entity.domsnapshot.RareIntegerData contentDocumentIndex;

    /**
    * Type of a pseudo element node.
    */
    private jpuppeteer.cdp.client.entity.domsnapshot.RareStringData pseudoType;

    /**
    * Whether this DOM node responds to mouse clicks. This includes nodes that have had click event listeners attached via JavaScript as well as anchor tags that naturally navigate when clicked.
    */
    private jpuppeteer.cdp.client.entity.domsnapshot.RareBooleanData isClickable;

    /**
    * The selected url for nodes with a srcset attribute.
    */
    private jpuppeteer.cdp.client.entity.domsnapshot.RareStringData currentSourceURL;

    /**
    * The url of the script (if any) that generates this node.
    */
    private jpuppeteer.cdp.client.entity.domsnapshot.RareStringData originURL;

    public void setParentIndex (java.util.List<Integer> parentIndex) {
        this.parentIndex = parentIndex;
    }

    public java.util.List<Integer> getParentIndex() {
        return this.parentIndex;
    }

    public void setNodeType (java.util.List<Integer> nodeType) {
        this.nodeType = nodeType;
    }

    public java.util.List<Integer> getNodeType() {
        return this.nodeType;
    }

    public void setNodeName (java.util.List<Integer> nodeName) {
        this.nodeName = nodeName;
    }

    public java.util.List<Integer> getNodeName() {
        return this.nodeName;
    }

    public void setNodeValue (java.util.List<Integer> nodeValue) {
        this.nodeValue = nodeValue;
    }

    public java.util.List<Integer> getNodeValue() {
        return this.nodeValue;
    }

    public void setBackendNodeId (java.util.List<Integer> backendNodeId) {
        this.backendNodeId = backendNodeId;
    }

    public java.util.List<Integer> getBackendNodeId() {
        return this.backendNodeId;
    }

    public void setAttributes (java.util.List<java.util.List<Integer>> attributes) {
        this.attributes = attributes;
    }

    public java.util.List<java.util.List<Integer>> getAttributes() {
        return this.attributes;
    }

    public void setTextValue (jpuppeteer.cdp.client.entity.domsnapshot.RareStringData textValue) {
        this.textValue = textValue;
    }

    public jpuppeteer.cdp.client.entity.domsnapshot.RareStringData getTextValue() {
        return this.textValue;
    }

    public void setInputValue (jpuppeteer.cdp.client.entity.domsnapshot.RareStringData inputValue) {
        this.inputValue = inputValue;
    }

    public jpuppeteer.cdp.client.entity.domsnapshot.RareStringData getInputValue() {
        return this.inputValue;
    }

    public void setInputChecked (jpuppeteer.cdp.client.entity.domsnapshot.RareBooleanData inputChecked) {
        this.inputChecked = inputChecked;
    }

    public jpuppeteer.cdp.client.entity.domsnapshot.RareBooleanData getInputChecked() {
        return this.inputChecked;
    }

    public void setOptionSelected (jpuppeteer.cdp.client.entity.domsnapshot.RareBooleanData optionSelected) {
        this.optionSelected = optionSelected;
    }

    public jpuppeteer.cdp.client.entity.domsnapshot.RareBooleanData getOptionSelected() {
        return this.optionSelected;
    }

    public void setContentDocumentIndex (jpuppeteer.cdp.client.entity.domsnapshot.RareIntegerData contentDocumentIndex) {
        this.contentDocumentIndex = contentDocumentIndex;
    }

    public jpuppeteer.cdp.client.entity.domsnapshot.RareIntegerData getContentDocumentIndex() {
        return this.contentDocumentIndex;
    }

    public void setPseudoType (jpuppeteer.cdp.client.entity.domsnapshot.RareStringData pseudoType) {
        this.pseudoType = pseudoType;
    }

    public jpuppeteer.cdp.client.entity.domsnapshot.RareStringData getPseudoType() {
        return this.pseudoType;
    }

    public void setIsClickable (jpuppeteer.cdp.client.entity.domsnapshot.RareBooleanData isClickable) {
        this.isClickable = isClickable;
    }

    public jpuppeteer.cdp.client.entity.domsnapshot.RareBooleanData getIsClickable() {
        return this.isClickable;
    }

    public void setCurrentSourceURL (jpuppeteer.cdp.client.entity.domsnapshot.RareStringData currentSourceURL) {
        this.currentSourceURL = currentSourceURL;
    }

    public jpuppeteer.cdp.client.entity.domsnapshot.RareStringData getCurrentSourceURL() {
        return this.currentSourceURL;
    }

    public void setOriginURL (jpuppeteer.cdp.client.entity.domsnapshot.RareStringData originURL) {
        this.originURL = originURL;
    }

    public jpuppeteer.cdp.client.entity.domsnapshot.RareStringData getOriginURL() {
        return this.originURL;
    }

    public NodeTreeSnapshot(java.util.List<Integer> parentIndex, java.util.List<Integer> nodeType, java.util.List<Integer> nodeName, java.util.List<Integer> nodeValue, java.util.List<Integer> backendNodeId, java.util.List<java.util.List<Integer>> attributes, jpuppeteer.cdp.client.entity.domsnapshot.RareStringData textValue, jpuppeteer.cdp.client.entity.domsnapshot.RareStringData inputValue, jpuppeteer.cdp.client.entity.domsnapshot.RareBooleanData inputChecked, jpuppeteer.cdp.client.entity.domsnapshot.RareBooleanData optionSelected, jpuppeteer.cdp.client.entity.domsnapshot.RareIntegerData contentDocumentIndex, jpuppeteer.cdp.client.entity.domsnapshot.RareStringData pseudoType, jpuppeteer.cdp.client.entity.domsnapshot.RareBooleanData isClickable, jpuppeteer.cdp.client.entity.domsnapshot.RareStringData currentSourceURL, jpuppeteer.cdp.client.entity.domsnapshot.RareStringData originURL) {
        this.parentIndex = parentIndex;
        this.nodeType = nodeType;
        this.nodeName = nodeName;
        this.nodeValue = nodeValue;
        this.backendNodeId = backendNodeId;
        this.attributes = attributes;
        this.textValue = textValue;
        this.inputValue = inputValue;
        this.inputChecked = inputChecked;
        this.optionSelected = optionSelected;
        this.contentDocumentIndex = contentDocumentIndex;
        this.pseudoType = pseudoType;
        this.isClickable = isClickable;
        this.currentSourceURL = currentSourceURL;
        this.originURL = originURL;
    }

    public NodeTreeSnapshot() {
        this.parentIndex = null;
        this.nodeType = null;
        this.nodeName = null;
        this.nodeValue = null;
        this.backendNodeId = null;
        this.attributes = null;
        this.textValue = null;
        this.inputValue = null;
        this.inputChecked = null;
        this.optionSelected = null;
        this.contentDocumentIndex = null;
        this.pseudoType = null;
        this.isClickable = null;
        this.currentSourceURL = null;
        this.originURL = null;
    }

}