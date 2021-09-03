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
    * The normalized tangential pressure, which has a range of [-1,1] (default: 0).
    */
    public final java.math.BigDecimal tangentialPressure;

    /**
    * The plane angle between the Y-Z plane and the plane containing both the stylus axis and the Y axis, in degrees of the range [-90,90], a positive tiltX is to the right (default: 0)
    */
    public final Integer tiltX;

    /**
    * The plane angle between the X-Z plane and the plane containing both the stylus axis and the X axis, in degrees of the range [-90,90], a positive tiltY is towards the user (default: 0).
    */
    public final Integer tiltY;

    /**
    * The clockwise rotation of a pen stylus around its own major axis, in degrees in the range [0,359] (default: 0).
    */
    public final Integer twist;

    /**
    * Identifier used to track touch sources between events, must be unique within an event.
    */
    public final java.math.BigDecimal id;

    public TouchPoint(java.math.BigDecimal x, java.math.BigDecimal y, java.math.BigDecimal radiusX, java.math.BigDecimal radiusY, java.math.BigDecimal rotationAngle, java.math.BigDecimal force, java.math.BigDecimal tangentialPressure, Integer tiltX, Integer tiltY, Integer twist, java.math.BigDecimal id) {
        this.x = x;
        this.y = y;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        this.rotationAngle = rotationAngle;
        this.force = force;
        this.tangentialPressure = tangentialPressure;
        this.tiltX = tiltX;
        this.tiltY = tiltY;
        this.twist = twist;
        this.id = id;
    }

    public TouchPoint(java.math.BigDecimal x, java.math.BigDecimal y) {
        this.x = x;
        this.y = y;
        this.radiusX = null;
        this.radiusY = null;
        this.rotationAngle = null;
        this.force = null;
        this.tangentialPressure = null;
        this.tiltX = null;
        this.tiltY = null;
        this.twist = null;
        this.id = null;
    }

}