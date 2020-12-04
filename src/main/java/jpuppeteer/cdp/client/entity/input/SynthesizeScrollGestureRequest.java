package jpuppeteer.cdp.client.entity.input;

/**
*/
public class SynthesizeScrollGestureRequest {

    /**
    * X coordinate of the start of the gesture in CSS pixels.
    */
    public final java.math.BigDecimal x;

    /**
    * Y coordinate of the start of the gesture in CSS pixels.
    */
    public final java.math.BigDecimal y;

    /**
    * The distance to scroll along the X axis (positive to scroll left).
    */
    public final java.math.BigDecimal xDistance;

    /**
    * The distance to scroll along the Y axis (positive to scroll up).
    */
    public final java.math.BigDecimal yDistance;

    /**
    * The number of additional pixels to scroll back along the X axis, in addition to the given distance.
    */
    public final java.math.BigDecimal xOverscroll;

    /**
    * The number of additional pixels to scroll back along the Y axis, in addition to the given distance.
    */
    public final java.math.BigDecimal yOverscroll;

    /**
    * Prevent fling (default: true).
    */
    public final Boolean preventFling;

    /**
    * Swipe speed in pixels per second (default: 800).
    */
    public final Integer speed;

    /**
    * Which type of input events to be generated (default: 'default', which queries the platform for the preferred input type).
    */
    public final String gestureSourceType;

    /**
    * The number of times to repeat the gesture (default: 0).
    */
    public final Integer repeatCount;

    /**
    * The number of milliseconds delay between each repeat. (default: 250).
    */
    public final Integer repeatDelayMs;

    /**
    * The name of the interaction markers to generate, if not empty (default: "").
    */
    public final String interactionMarkerName;

    public SynthesizeScrollGestureRequest(java.math.BigDecimal x, java.math.BigDecimal y, java.math.BigDecimal xDistance, java.math.BigDecimal yDistance, java.math.BigDecimal xOverscroll, java.math.BigDecimal yOverscroll, Boolean preventFling, Integer speed, String gestureSourceType, Integer repeatCount, Integer repeatDelayMs, String interactionMarkerName) {
        this.x = x;
        this.y = y;
        this.xDistance = xDistance;
        this.yDistance = yDistance;
        this.xOverscroll = xOverscroll;
        this.yOverscroll = yOverscroll;
        this.preventFling = preventFling;
        this.speed = speed;
        this.gestureSourceType = gestureSourceType;
        this.repeatCount = repeatCount;
        this.repeatDelayMs = repeatDelayMs;
        this.interactionMarkerName = interactionMarkerName;
    }

    public SynthesizeScrollGestureRequest(java.math.BigDecimal x, java.math.BigDecimal y) {
        this.x = x;
        this.y = y;
        this.xDistance = null;
        this.yDistance = null;
        this.xOverscroll = null;
        this.yOverscroll = null;
        this.preventFling = null;
        this.speed = null;
        this.gestureSourceType = null;
        this.repeatCount = null;
        this.repeatDelayMs = null;
        this.interactionMarkerName = null;
    }

}