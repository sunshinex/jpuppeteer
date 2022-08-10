package jpuppeteer.cdp.client.entity.input;

/**
*/
public class SynthesizeTapGestureRequest {

    /**
    * X coordinate of the start of the gesture in CSS pixels.
    */
    private java.math.BigDecimal x;

    /**
    * Y coordinate of the start of the gesture in CSS pixels.
    */
    private java.math.BigDecimal y;

    /**
    * Duration between touchdown and touchup events in ms (default: 50).
    */
    private Integer duration;

    /**
    * Number of times to perform the tap (e.g. 2 for double tap, default: 1).
    */
    private Integer tapCount;

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

    public void setDuration (Integer duration) {
        this.duration = duration;
    }

    public Integer getDuration() {
        return this.duration;
    }

    public void setTapCount (Integer tapCount) {
        this.tapCount = tapCount;
    }

    public Integer getTapCount() {
        return this.tapCount;
    }

    public void setGestureSourceType (jpuppeteer.cdp.client.constant.input.GestureSourceType gestureSourceType) {
        this.gestureSourceType = gestureSourceType;
    }

    public jpuppeteer.cdp.client.constant.input.GestureSourceType getGestureSourceType() {
        return this.gestureSourceType;
    }

    public SynthesizeTapGestureRequest(java.math.BigDecimal x, java.math.BigDecimal y, Integer duration, Integer tapCount, jpuppeteer.cdp.client.constant.input.GestureSourceType gestureSourceType) {
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

    public SynthesizeTapGestureRequest() {
    }

}