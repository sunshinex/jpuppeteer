package jpuppeteer.cdp.client.entity.domsnapshot;

/**
* Document snapshot.
* experimental
*/
public class DocumentSnapshot {

    /**
    * Document URL that `Document` or `FrameOwner` node points to.
    */
    private Integer documentURL;

    /**
    * Document title.
    */
    private Integer title;

    /**
    * Base URL that `Document` or `FrameOwner` node uses for URL completion.
    */
    private Integer baseURL;

    /**
    * Contains the document's content language.
    */
    private Integer contentLanguage;

    /**
    * Contains the document's character set encoding.
    */
    private Integer encodingName;

    /**
    * `DocumentType` node's publicId.
    */
    private Integer publicId;

    /**
    * `DocumentType` node's systemId.
    */
    private Integer systemId;

    /**
    * Frame ID for frame owner elements and also for the document node.
    */
    private Integer frameId;

    /**
    * A table with dom nodes.
    */
    private jpuppeteer.cdp.client.entity.domsnapshot.NodeTreeSnapshot nodes;

    /**
    * The nodes in the layout tree.
    */
    private jpuppeteer.cdp.client.entity.domsnapshot.LayoutTreeSnapshot layout;

    /**
    * The post-layout inline text nodes.
    */
    private jpuppeteer.cdp.client.entity.domsnapshot.TextBoxSnapshot textBoxes;

    /**
    * Horizontal scroll offset.
    */
    private java.math.BigDecimal scrollOffsetX;

    /**
    * Vertical scroll offset.
    */
    private java.math.BigDecimal scrollOffsetY;

    /**
    * Document content width.
    */
    private java.math.BigDecimal contentWidth;

    /**
    * Document content height.
    */
    private java.math.BigDecimal contentHeight;

    public void setDocumentURL (Integer documentURL) {
        this.documentURL = documentURL;
    }

    public Integer getDocumentURL() {
        return this.documentURL;
    }

    public void setTitle (Integer title) {
        this.title = title;
    }

    public Integer getTitle() {
        return this.title;
    }

    public void setBaseURL (Integer baseURL) {
        this.baseURL = baseURL;
    }

    public Integer getBaseURL() {
        return this.baseURL;
    }

    public void setContentLanguage (Integer contentLanguage) {
        this.contentLanguage = contentLanguage;
    }

    public Integer getContentLanguage() {
        return this.contentLanguage;
    }

    public void setEncodingName (Integer encodingName) {
        this.encodingName = encodingName;
    }

    public Integer getEncodingName() {
        return this.encodingName;
    }

    public void setPublicId (Integer publicId) {
        this.publicId = publicId;
    }

    public Integer getPublicId() {
        return this.publicId;
    }

    public void setSystemId (Integer systemId) {
        this.systemId = systemId;
    }

    public Integer getSystemId() {
        return this.systemId;
    }

    public void setFrameId (Integer frameId) {
        this.frameId = frameId;
    }

    public Integer getFrameId() {
        return this.frameId;
    }

    public void setNodes (jpuppeteer.cdp.client.entity.domsnapshot.NodeTreeSnapshot nodes) {
        this.nodes = nodes;
    }

    public jpuppeteer.cdp.client.entity.domsnapshot.NodeTreeSnapshot getNodes() {
        return this.nodes;
    }

    public void setLayout (jpuppeteer.cdp.client.entity.domsnapshot.LayoutTreeSnapshot layout) {
        this.layout = layout;
    }

    public jpuppeteer.cdp.client.entity.domsnapshot.LayoutTreeSnapshot getLayout() {
        return this.layout;
    }

    public void setTextBoxes (jpuppeteer.cdp.client.entity.domsnapshot.TextBoxSnapshot textBoxes) {
        this.textBoxes = textBoxes;
    }

    public jpuppeteer.cdp.client.entity.domsnapshot.TextBoxSnapshot getTextBoxes() {
        return this.textBoxes;
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

    public void setContentWidth (java.math.BigDecimal contentWidth) {
        this.contentWidth = contentWidth;
    }

    public java.math.BigDecimal getContentWidth() {
        return this.contentWidth;
    }

    public void setContentHeight (java.math.BigDecimal contentHeight) {
        this.contentHeight = contentHeight;
    }

    public java.math.BigDecimal getContentHeight() {
        return this.contentHeight;
    }

    public DocumentSnapshot(Integer documentURL, Integer title, Integer baseURL, Integer contentLanguage, Integer encodingName, Integer publicId, Integer systemId, Integer frameId, jpuppeteer.cdp.client.entity.domsnapshot.NodeTreeSnapshot nodes, jpuppeteer.cdp.client.entity.domsnapshot.LayoutTreeSnapshot layout, jpuppeteer.cdp.client.entity.domsnapshot.TextBoxSnapshot textBoxes, java.math.BigDecimal scrollOffsetX, java.math.BigDecimal scrollOffsetY, java.math.BigDecimal contentWidth, java.math.BigDecimal contentHeight) {
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

    public DocumentSnapshot(Integer documentURL, Integer title, Integer baseURL, Integer contentLanguage, Integer encodingName, Integer publicId, Integer systemId, Integer frameId, jpuppeteer.cdp.client.entity.domsnapshot.NodeTreeSnapshot nodes, jpuppeteer.cdp.client.entity.domsnapshot.LayoutTreeSnapshot layout, jpuppeteer.cdp.client.entity.domsnapshot.TextBoxSnapshot textBoxes) {
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

    public DocumentSnapshot() {
    }

}