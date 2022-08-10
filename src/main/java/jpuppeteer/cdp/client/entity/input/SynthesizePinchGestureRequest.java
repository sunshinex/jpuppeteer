package jpuppeteer.cdp.client.entity.input;

/**
*/
public class SynthesizePinchGestureRequest {

    /**
    * X coordinate of the start of the gesture in CSS pixels.
    */
    private java.math.BigDecimal x;

    /**
    * Y coordinate of the start of the gesture in CSS pixels.
    */
    private java.math.BigDecimal y;

    /**
    * Relative scale factor after zooming (>1.0 zooms in, <1.0 zooms out).
    */
    private java.math.BigDecimal scaleFactor;

    /**
    * Relative pointer speed in pixels per second (default: 800).
    */
    private Integer relativeSpeed;

    /**
    * Which type of input events to be generated (default: 'default', which queries the platform for the preferred input type).
    */
    private jpuppeteer.cdp.client.constant.input.GestureSourceType gestureSourceType;

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

    public void setScaleFactor (java.math.BigDecimal scaleFactor) {
        this.scaleFactor = scaleFactor;
    }

    public java.math.BigDecimal getScaleFactor() {
        return this.scaleFactor;
    }

    public void setRelativeSpeed (Integer relativeSpeed) {
        this.relativeSpeed = relativeSpeed;
    }

    public Integer getRelativeSpeed() {
        return this.relativeSpeed;
    }

    public void setGestureSourceType (jpuppeteer.cdp.client.constant.input.GestureSourceType gestureSourceType) {
        this.gestureSourceType = gestureSourceType;
    }

    public jpuppeteer.cdp.client.constant.input.GestureSourceType getGestureSourceType() {
        return this.gestureSourceType;
    }

    public SynthesizePinchGestureRequest(java.math.BigDecimal x, java.math.BigDecimal y, java.math.BigDecimal scaleFactor, Integer relativeSpeed, jpuppeteer.cdp.client.constant.input.GestureSourceType gestureSourceType) {
        this.x = x;
        this.y = y;
        this.scaleFactor = scaleFactor;
        this.relativeSpeed = relativeSpeed;
        this.gestureSourceType = gestureSourceType;
    }

    public SynthesizePinchGestureRequest(java.math.BigDecimal x, java.math.BigDecimal y, java.math.BigDecimal scaleFactor) {
        this.x = x;
        this.y = y;
        this.scaleFactor = scaleFactor;
        this.relativeSpeed = null;
        this.gestureSourceType = null;
    }

    public SynthesizePinchGestureRequest() {
    }

}