package jpuppeteer.cdp.client.entity.input;

/**
*/
public class SynthesizePinchGestureRequest {

    /**
    * X coordinate of the start of the gesture in CSS pixels.
    */
    public final java.math.BigDecimal x;

    /**
    * Y coordinate of the start of the gesture in CSS pixels.
    */
    public final java.math.BigDecimal y;

    /**
    * Relative scale factor after zooming (>1.0 zooms in, <1.0 zooms out).
    */
    public final java.math.BigDecimal scaleFactor;

    /**
    * Relative pointer speed in pixels per second (default: 800).
    */
    public final Integer relativeSpeed;

    /**
    * Which type of input events to be generated (default: 'default', which queries the platform for the preferred input type).
    */
    public final jpuppeteer.cdp.client.constant.input.GestureSourceType gestureSourceType;

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

}