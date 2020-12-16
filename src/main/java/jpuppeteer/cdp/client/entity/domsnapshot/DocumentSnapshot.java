package jpuppeteer.cdp.client.entity.domsnapshot;

/**
* Document snapshot.
* experimental
*/
public class DocumentSnapshot {

    /**
    * Document URL that `Document` or `FrameOwner` node points to.
    */
    public final Integer documentURL;

    /**
    * Document title.
    */
    public final Integer title;

    /**
    * Base URL that `Document` or `FrameOwner` node uses for URL completion.
    */
    public final Integer baseURL;

    /**
    * Contains the document's content language.
    */
    public final Integer contentLanguage;

    /**
    * Contains the document's character set encoding.
    */
    public final Integer encodingName;

    /**
    * `DocumentType` node's publicId.
    */
    public final Integer publicId;

    /**
    * `DocumentType` node's systemId.
    */
    public final Integer systemId;

    /**
    * Frame ID for frame owner elements and also for the document node.
    */
    public final Integer frameId;

    /**
    * A table with dom nodes.
    */
    public final NodeTreeSnapshot nodes;

    /**
    * The nodes in the layout tree.
    */
    public final LayoutTreeSnapshot layout;

    /**
    * The post-layout inline text nodes.
    */
    public final TextBoxSnapshot textBoxes;

    /**
    * Horizontal scroll offset.
    */
    public final java.math.BigDecimal scrollOffsetX;

    /**
    * Vertical scroll offset.
    */
    public final java.math.BigDecimal scrollOffsetY;

    /**
    * Document content width.
    */
    public final java.math.BigDecimal contentWidth;

    /**
    * Document content height.
    */
    public final java.math.BigDecimal contentHeight;

    public DocumentSnapshot(Integer documentURL, Integer title, Integer baseURL, Integer contentLanguage, Integer encodingName, Integer publicId, Integer systemId, Integer frameId, NodeTreeSnapshot nodes, LayoutTreeSnapshot layout, TextBoxSnapshot textBoxes, java.math.BigDecimal scrollOffsetX, java.math.BigDecimal scrollOffsetY, java.math.BigDecimal contentWidth, java.math.BigDecimal contentHeight) {
        this.documentURL = documentURL;
        this.title = title;
        this.baseURL = baseURL;
        this.contentLanguage = contentLanguage;
        this.encodingName = encodingName;
        this.publicId = publicId;
        this.systemId = systemId;
        this.frameId = frameId;
        this.nodes = nodes;
        this.layout = layout;
        this.textBoxes = textBoxes;
        this.scrollOffsetX = scrollOffsetX;
        this.scrollOffsetY = scrollOffsetY;
        this.contentWidth = contentWidth;
        this.contentHeight = contentHeight;
    }

    public DocumentSnapshot(Integer documentURL, Integer title, Integer baseURL, Integer contentLanguage, Integer encodingName, Integer publicId, Integer systemId, Integer frameId, NodeTreeSnapshot nodes, LayoutTreeSnapshot layout, TextBoxSnapshot textBoxes) {
        this.documentURL = documentURL;
        this.title = title;
        this.baseURL = baseURL;
        this.contentLanguage = contentLanguage;
        this.encodingName = encodingName;
        this.publicId = publicId;
        this.systemId = systemId;
        this.frameId = frameId;
        this.nodes = nodes;
        this.layout = layout;
        this.textBoxes = textBoxes;
        this.scrollOffsetX = null;
        this.scrollOffsetY = null;
        this.contentWidth = null;
        this.contentHeight = null;
    }

}