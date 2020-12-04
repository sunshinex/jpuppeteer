package jpuppeteer.cdp.client.entity.input;

/**
*/
public class TouchPoint {

    /**
    * X coordinate of the event relative to the main frame's viewport in CSS pixels.
    */
    public final java.math.BigDecimal x;

    /**
    * Y coordinate of the event relative to the main frame's viewport in CSS pixels. 0 refers to the top of the viewport and Y increases as it proceeds towards the bottom of the viewport.
    */
    public final java.math.BigDecimal y;

    /**
    * X radius of the touch area (default: 1.0).
    */
    public final java.math.BigDecimal radiusX;

    /**
    * Y radius of the touch area (default: 1.0).
    */
    public final java.math.BigDecimal radiusY;

    /**
    * Rotation angle (default: 0.0).
    */
    public final java.math.BigDecimal rotationAngle;

    /**
    * Force (default: 1.0).
    */
    public final java.math.BigDecimal force;

    /**
    * Identifier used to track touch sources between events, must be unique within an event.
    */
    public final java.math.BigDecimal id;

    public TouchPoint(java.math.BigDecimal x, java.math.BigDecimal y, java.math.BigDecimal radiusX, java.math.BigDecimal radiusY, java.math.BigDecimal rotationAngle, java.math.BigDecimal force, java.math.BigDecimal id) {
        this.x = x;
        this.y = y;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        this.rotationAngle = rotationAngle;
        this.force = force;
        this.id = id;
    }

    public TouchPoint(java.math.BigDecimal x, java.math.BigDecimal y) {
        this.x = x;
        this.y = y;
        this.radiusX = null;
        this.radiusY = null;
        this.rotationAngle = null;
        this.force = null;
        this.id = null;
    }

}