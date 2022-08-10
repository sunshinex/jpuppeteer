package jpuppeteer.cdp.client.entity.input;

/**
*/
public class SynthesizeScrollGestureRequest {

    /**
    * X coordinate of the start of the gesture in CSS pixels.
    */
    private java.math.BigDecimal x;

    /**
    * Y coordinate of the start of the gesture in CSS pixels.
    */
    private java.math.BigDecimal y;

    /**
    * The distance to scroll along the X axis (positive to scroll left).
    */
    private java.math.BigDecimal xDistance;

    /**
    * The distance to scroll along the Y axis (positive to scroll up).
    */
    private java.math.BigDecimal yDistance;

    /**
    * The number of additional pixels to scroll back along the X axis, in addition to the given distance.
    */
    private java.math.BigDecimal xOverscroll;

    /**
    * The number of additional pixels to scroll back along the Y axis, in addition to the given distance.
    */
    private java.math.BigDecimal yOverscroll;

    /**
    * Prevent fling (default: true).
    */
    private Boolean preventFling;

    /**
    * Swipe speed in pixels per second (default: 800).
    */
    private Integer speed;

    /**
    * Which type of input events to be generated (default: 'default', which queries the platform for the preferred input type).
    */
    private jpuppeteer.cdp.client.constant.input.GestureSourceType gestureSourceType;

    /**
    * The number of times to repeat the gesture (default: 0).
    */
    private Integer repeatCount;

    /**
    * The number of milliseconds delay between each repeat. (default: 250).
    */
    private Integer repeatDelayMs;

    /**
    * The name of the interaction markers to generate, if not empty (default: "").
    */
    private String interactionMarkerName;

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

    public void setXDistance (java.math.BigDecimal xDistance) {
        this.xDistance = xDistance;
    }

    public java.math.BigDecimal getXDistance() {
        return this.xDistance;
    }

    public void setYDistance (java.math.BigDecimal yDistance) {
        this.yDistance = yDistance;
    }

    public java.math.BigDecimal getYDistance() {
        return this.yDistance;
    }

    public void setXOverscroll (java.math.BigDecimal xOverscroll) {
        this.xOverscroll = xOverscroll;
    }

    public java.math.BigDecimal getXOverscroll() {
        return this.xOverscroll;
    }

    public void setYOverscroll (java.math.BigDecimal yOverscroll) {
        this.yOverscroll = yOverscroll;
    }

    public java.math.BigDecimal getYOverscroll() {
        return this.yOverscroll;
    }

    public void setPreventFling (Boolean preventFling) {
        this.preventFling = preventFling;
    }

    public Boolean getPreventFling() {
        return this.preventFling;
    }

    public void setSpeed (Integer speed) {
        this.speed = speed;
    }

    public Integer getSpeed() {
        return this.speed;
    }

    public void setGestureSourceType (jpuppeteer.cdp.client.constant.input.GestureSourceType gestureSourceType) {
        this.gestureSourceType = gestureSourceType;
    }

    public jpuppeteer.cdp.client.constant.input.GestureSourceType getGestureSourceType() {
        return this.gestureSourceType;
    }

    public void setRepeatCount (Integer repeatCount) {
        this.repeatCount = repeatCount;
    }

    public Integer getRepeatCount() {
        return this.repeatCount;
    }

    public void setRepeatDelayMs (Integer repeatDelayMs) {
        this.repeatDelayMs = repeatDelayMs;
    }

    public Integer getRepeatDelayMs() {
        return this.repeatDelayMs;
    }

    public void setInteractionMarkerName (String interactionMarkerName) {
        this.interactionMarkerName = interactionMarkerName;
    }

    public String getInteractionMarkerName() {
        return this.interactionMarkerName;
    }

    public SynthesizeScrollGestureRequest(java.math.BigDecimal x, java.math.BigDecimal y, java.math.BigDecimal xDistance, java.math.BigDecimal yDistance, java.math.BigDecimal xOverscroll, java.math.BigDecimal yOverscroll, Boolean preventFling, Integer speed, jpuppeteer.cdp.client.constant.input.GestureSourceType gestureSourceType, Integer repeatCount, Integer repeatDelayMs, String interactionMarkerName) {
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

    public SynthesizeScrollGestureRequest() {
    }

}