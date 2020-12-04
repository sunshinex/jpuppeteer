package jpuppeteer.cdp.client.entity.input;

/**
*/
public class SynthesizeTapGestureRequest {

    /**
    * X coordinate of the start of the gesture in CSS pixels.
    */
    public final java.math.BigDecimal x;

    /**
    * Y coordinate of the start of the gesture in CSS pixels.
    */
    public final java.math.BigDecimal y;

    /**
    * Duration between touchdown and touchup events in ms (default: 50).
    */
    public final Integer duration;

    /**
    * Number of times to perform the tap (e.g. 2 for double tap, default: 1).
    */
    public final Integer tapCount;

    /**
    * Which type of input events to be generated (default: 'default', which queries the platform for the preferred input type).
    */
    public final String gestureSourceType;

    public SynthesizeTapGestureRequest(java.math.BigDecimal x, java.math.BigDecimal y, Integer duration, Integer tapCount, String gestureSourceType) {
        this.x = x;
        this.y = y;
        this.duration = duration;
        this.tapCount = tapCount;
        this.gestureSourceType = gestureSourceType;
    }

    public SynthesizeTapGestureRequest(java.math.BigDecimal x, java.math.BigDecimal y) {
        this.x = x;
        this.y = y;
        this.duration = null;
        this.tapCount = null;
        this.gestureSourceType = null;
    }

}