package jpuppeteer.cdp.client.entity.layertree;

/**
* Information about a compositing layer.
* experimental
*/
public class Layer {

    /**
    * The unique id for this layer.
    */
    private String layerId;

    /**
    * The id of parent (not present for root).
    */
    private String parentLayerId;

    /**
    * The backend id for the node associated with this layer.
    */
    private Integer backendNodeId;

    /**
    * Offset from parent layer, X coordinate.
    */
    private java.math.BigDecimal offsetX;

    /**
    * Offset from parent layer, Y coordinate.
    */
    private java.math.BigDecimal offsetY;

    /**
    * Layer width.
    */
    private java.math.BigDecimal width;

    /**
    * Layer height.
    */
    private java.math.BigDecimal height;

    /**
    * Transformation matrix for layer, default is identity matrix
    */
    private java.util.List<java.math.BigDecimal> transform;

    /**
    * Transform anchor point X, absent if no transform specified
    */
    private java.math.BigDecimal anchorX;

    /**
    * Transform anchor point Y, absent if no transform specified
    */
    private java.math.BigDecimal anchorY;

    /**
    * Transform anchor point Z, absent if no transform specified
    */
    private java.math.BigDecimal anchorZ;

    /**
    * Indicates how many time this layer has painted.
    */
    private Integer paintCount;

    /**
    * Indicates whether this layer hosts any content, rather than being used for transform/scrolling purposes only.
    */
    private Boolean drawsContent;

    /**
    * Set if layer is not visible.
    */
    private Boolean invisible;

    /**
    * Rectangles scrolling on main thread only.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.layertree.ScrollRect> scrollRects;

    /**
    * Sticky position constraint information
    */
    private jpuppeteer.cdp.client.entity.layertree.StickyPositionConstraint stickyPositionConstraint;

    public void setLayerId (String layerId) {
        this.layerId = layerId;
    }

    public String getLayerId() {
        return this.layerId;
    }

    public void setParentLayerId (String parentLayerId) {
        this.parentLayerId = parentLayerId;
    }

    public String getParentLayerId() {
        return this.parentLayerId;
    }

    public void setBackendNodeId (Integer backendNodeId) {
        this.backendNodeId = backendNodeId;
    }

    public Integer getBackendNodeId() {
        return this.backendNodeId;
    }

    public void setOffsetX (java.math.BigDecimal offsetX) {
        this.offsetX = offsetX;
    }

    public java.math.BigDecimal getOffsetX() {
        return this.offsetX;
    }

    public void setOffsetY (java.math.BigDecimal offsetY) {
        this.offsetY = offsetY;
    }

    public java.math.BigDecimal getOffsetY() {
        return this.offsetY;
    }

    public void setWidth (java.math.BigDecimal width) {
        this.width = width;
    }

    public java.math.BigDecimal getWidth() {
        return this.width;
    }

    public void setHeight (java.math.BigDecimal height) {
        this.height = height;
    }

    public java.math.BigDecimal getHeight() {
        return this.height;
    }

    public void setTransform (java.util.List<java.math.BigDecimal> transform) {
        this.transform = transform;
    }

    public java.util.List<java.math.BigDecimal> getTransform() {
        return this.transform;
    }

    public void setAnchorX (java.math.BigDecimal anchorX) {
        this.anchorX = anchorX;
    }

    public java.math.BigDecimal getAnchorX() {
        return this.anchorX;
    }

    public void setAnchorY (java.math.BigDecimal anchorY) {
        this.anchorY = anchorY;
    }

    public java.math.BigDecimal getAnchorY() {
        return this.anchorY;
    }

    public void setAnchorZ (java.math.BigDecimal anchorZ) {
        this.anchorZ = anchorZ;
    }

    public java.math.BigDecimal getAnchorZ() {
        return this.anchorZ;
    }

    public void setPaintCount (Integer paintCount) {
        this.paintCount = paintCount;
    }

    public Integer getPaintCount() {
        return this.paintCount;
    }

    public void setDrawsContent (Boolean drawsContent) {
        this.drawsContent = drawsContent;
    }

    public Boolean getDrawsContent() {
        return this.drawsContent;
    }

    public void setInvisible (Boolean invisible) {
        this.invisible = invisible;
    }

    public Boolean getInvisible() {
        return this.invisible;
    }

    public void setScrollRects (java.util.List<jpuppeteer.cdp.client.entity.layertree.ScrollRect> scrollRects) {
        this.scrollRects = scrollRects;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.layertree.ScrollRect> getScrollRects() {
        return this.scrollRects;
    }

    public void setStickyPositionConstraint (jpuppeteer.cdp.client.entity.layertree.StickyPositionConstraint stickyPositionConstraint) {
        this.stickyPositionConstraint = stickyPositionConstraint;
    }

    public jpuppeteer.cdp.client.entity.layertree.StickyPositionConstraint getStickyPositionConstraint() {
        return this.stickyPositionConstraint;
    }

    public Layer(String layerId, String parentLayerId, Integer backendNodeId, java.math.BigDecimal offsetX, java.math.BigDecimal offsetY, java.math.BigDecimal width, java.math.BigDecimal height, java.util.List<java.math.BigDecimal> transform, java.math.BigDecimal anchorX, java.math.BigDecimal anchorY, java.math.BigDecimal anchorZ, Integer paintCount, Boolean drawsContent, Boolean invisible, java.util.List<jpuppeteer.cdp.client.entity.layertree.ScrollRect> scrollRects, jpuppeteer.cdp.client.entity.layertree.StickyPositionConstraint stickyPositionConstraint) {
        this.layerId = layerId;
        this.parentLayerId = parentLayerId;
        this.backendNodeId = backendNodeId;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.width = width;
        this.height = height;
        this.transform = transform;
        this.anchorX = anchorX;
        this.anchorY = anchorY;
        this.anchorZ = anchorZ;
        this.paintCount = paintCount;
        this.drawsContent = drawsContent;
        this.invisible = invisible;
        this.scrollRects = scrollRects;
        this.stickyPositionConstraint = stickyPositionConstraint;
    }

    public Layer(String layerId, java.math.BigDecimal offsetX, java.math.BigDecimal offsetY, java.math.BigDecimal width, java.math.BigDecimal height, Integer paintCount, Boolean drawsContent) {
        this.layerId = layerId;
        this.parentLayerId = null;
        this.backendNodeId = null;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.width = width;
        this.height = height;
        this.transform = null;
        this.anchorX = null;
        this.anchorY = null;
        this.anchorZ = null;
        this.paintCount = paintCount;
        this.drawsContent = drawsContent;
        this.invisible = null;
        this.scrollRects = null;
        this.stickyPositionConstraint = null;
    }

    public Layer() {
    }

}