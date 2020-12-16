package jpuppeteer.cdp.client.entity.layertree;

/**
* Information about a compositing layer.
* experimental
*/
public class Layer {

    /**
    * The unique id for this layer.
    */
    public final String layerId;

    /**
    * The id of parent (not present for root).
    */
    public final String parentLayerId;

    /**
    * The backend id for the node associated with this layer.
    */
    public final Integer backendNodeId;

    /**
    * Offset from parent layer, X coordinate.
    */
    public final java.math.BigDecimal offsetX;

    /**
    * Offset from parent layer, Y coordinate.
    */
    public final java.math.BigDecimal offsetY;

    /**
    * Layer width.
    */
    public final java.math.BigDecimal width;

    /**
    * Layer height.
    */
    public final java.math.BigDecimal height;

    /**
    * Transformation matrix for layer, default is identity matrix
    */
    public final java.util.List<java.math.BigDecimal> transform;

    /**
    * Transform anchor point X, absent if no transform specified
    */
    public final java.math.BigDecimal anchorX;

    /**
    * Transform anchor point Y, absent if no transform specified
    */
    public final java.math.BigDecimal anchorY;

    /**
    * Transform anchor point Z, absent if no transform specified
    */
    public final java.math.BigDecimal anchorZ;

    /**
    * Indicates how many time this layer has painted.
    */
    public final Integer paintCount;

    /**
    * Indicates whether this layer hosts any content, rather than being used for transform/scrolling purposes only.
    */
    public final Boolean drawsContent;

    /**
    * Set if layer is not visible.
    */
    public final Boolean invisible;

    /**
    * Rectangles scrolling on main thread only.
    */
    public final java.util.List<ScrollRect> scrollRects;

    /**
    * Sticky position constraint information
    */
    public final StickyPositionConstraint stickyPositionConstraint;

    public Layer(String layerId, String parentLayerId, Integer backendNodeId, java.math.BigDecimal offsetX, java.math.BigDecimal offsetY, java.math.BigDecimal width, java.math.BigDecimal height, java.util.List<java.math.BigDecimal> transform, java.math.BigDecimal anchorX, java.math.BigDecimal anchorY, java.math.BigDecimal anchorZ, Integer paintCount, Boolean drawsContent, Boolean invisible, java.util.List<ScrollRect> scrollRects, StickyPositionConstraint stickyPositionConstraint) {
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

}