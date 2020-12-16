package jpuppeteer.cdp.client.entity.domsnapshot;

/**
* Table containing nodes.
* experimental
*/
public class NodeTreeSnapshot {

    /**
    * Parent node index.
    */
    public final java.util.List<Integer> parentIndex;

    /**
    * `Node`'s nodeType.
    */
    public final java.util.List<Integer> nodeType;

    /**
    * `Node`'s nodeName.
    */
    public final java.util.List<Integer> nodeName;

    /**
    * `Node`'s nodeValue.
    */
    public final java.util.List<Integer> nodeValue;

    /**
    * `Node`'s id, corresponds to DOM.Node.backendNodeId.
    */
    public final java.util.List<Integer> backendNodeId;

    /**
    * Attributes of an `Element` node. Flatten name, value pairs.
    */
    public final java.util.List<java.util.List<Integer>> attributes;

    /**
    * Only set for textarea elements, contains the text value.
    */
    public final RareStringData textValue;

    /**
    * Only set for input elements, contains the input's associated text value.
    */
    public final RareStringData inputValue;

    /**
    * Only set for radio and checkbox input elements, indicates if the element has been checked
    */
    public final RareBooleanData inputChecked;

    /**
    * Only set for option elements, indicates if the element has been selected
    */
    public final RareBooleanData optionSelected;

    /**
    * The index of the document in the list of the snapshot documents.
    */
    public final RareIntegerData contentDocumentIndex;

    /**
    * Type of a pseudo element node.
    */
    public final RareStringData pseudoType;

    /**
    * Whether this DOM node responds to mouse clicks. This includes nodes that have had click event listeners attached via JavaScript as well as anchor tags that naturally navigate when clicked.
    */
    public final RareBooleanData isClickable;

    /**
    * The selected url for nodes with a srcset attribute.
    */
    public final RareStringData currentSourceURL;

    /**
    * The url of the script (if any) that generates this node.
    */
    public final RareStringData originURL;

    public NodeTreeSnapshot(java.util.List<Integer> parentIndex, java.util.List<Integer> nodeType, java.util.List<Integer> nodeName, java.util.List<Integer> nodeValue, java.util.List<Integer> backendNodeId, java.util.List<java.util.List<Integer>> attributes, RareStringData textValue, RareStringData inputValue, RareBooleanData inputChecked, RareBooleanData optionSelected, RareIntegerData contentDocumentIndex, RareStringData pseudoType, RareBooleanData isClickable, RareStringData currentSourceURL, RareStringData originURL) {
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