package jpuppeteer.cdp.client.entity.input;

/**
*/
public class TouchPoint {

    /**
    * X coordinate of the event relative to the main frame's viewport in CSS pixels.
    */
    private java.math.BigDecimal x;

    /**
    * Y coordinate of the event relative to the main frame's viewport in CSS pixels. 0 refers to the top of the viewport and Y increases as it proceeds towards the bottom of the viewport.
    */
    private java.math.BigDecimal y;

    /**
    * X radius of the touch area (default: 1.0).
    */
    private java.math.BigDecimal radiusX;

    /**
    * Y radius of the touch area (default: 1.0).
    */
    private java.math.BigDecimal radiusY;

    /**
    * Rotation angle (default: 0.0).
    */
    private java.math.BigDecimal rotationAngle;

    /**
    * Force (default: 1.0).
    */
    private java.math.BigDecimal force;

    /**
    * The normalized tangential pressure, which has a range of [-1,1] (default: 0).
    */
    private java.math.BigDecimal tangentialPressure;

    /**
    * The plane angle between the Y-Z plane and the plane containing both the stylus axis and the Y axis, in degrees of the range [-90,90], a positive tiltX is to the right (default: 0)
    */
    private Integer tiltX;

    /**
    * The plane angle between the X-Z plane and the plane containing both the stylus axis and the X axis, in degrees of the range [-90,90], a positive tiltY is towards the user (default: 0).
    */
    private Integer tiltY;

    /**
    * The clockwise rotation of a pen stylus around its own major axis, in degrees in the range [0,359] (default: 0).
    */
    private Integer twist;

    /**
    * Identifier used to track touch sources between events, must be unique within an event.
    */
    private java.math.BigDecimal id;

    public void setX (java.math.BigDecimal x) {
        this.x = x;
    }

    public java.math.BigDecimal getX() {
        return this.x;
    }

    public void setY (java.math.BigDecimal y) {
        this.y = y;
    }

    public java.math.BigDecimal getY() {
        return this.y;
    }

    public void setRadiusX (java.math.BigDecimal radiusX) {
        this.radiusX = radiusX;
    }

    public java.math.BigDecimal getRadiusX() {
        return this.radiusX;
    }

    public void setRadiusY (java.math.BigDecimal radiusY) {
        this.radiusY = radiusY;
    }

    public java.math.BigDecimal getRadiusY() {
        return this.radiusY;
    }

    public void setRotationAngle (java.math.BigDecimal rotationAngle) {
        this.rotationAngle = rotationAngle;
    }

    public java.math.BigDecimal getRotationAngle() {
        return this.rotationAngle;
    }

    public void setForce (java.math.BigDecimal force) {
        this.force = force;
    }

    public java.math.BigDecimal getForce() {
        return this.force;
    }

    public void setTangentialPressure (java.math.BigDecimal tangentialPressure) {
        this.tangentialPressure = tangentialPressure;
    }

    public java.math.BigDecimal getTangentialPressure() {
        return this.tangentialPressure;
    }

    public void setTiltX (Integer tiltX) {
        this.tiltX = tiltX;
    }

    public Integer getTiltX() {
        return this.tiltX;
    }

    public void setTiltY (Integer tiltY) {
        this.tiltY = tiltY;
    }

    public Integer getTiltY() {
        return this.tiltY;
    }

    public void setTwist (Integer twist) {
        this.twist = twist;
    }

    public Integer getTwist() {
        return this.twist;
    }

    public void setId (java.math.BigDecimal id) {
        this.id = id;
    }

    public java.math.BigDecimal getId() {
        return this.id;
    }

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

    public TouchPoint() {
    }

}