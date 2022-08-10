package jpuppeteer.cdp.client.entity.input;

/**
*/
public class DispatchTouchEventRequest {

    /**
    * Type of the touch event. TouchEnd and TouchCancel must not contain any touch points, while TouchStart and TouchMove must contains at least one.
    */
    private jpuppeteer.cdp.client.constant.input.DispatchTouchEventRequestType type;

    /**
    * Active touch points on the touch device. One event per any changed point (compared to previous touch event in a sequence) is generated, emulating pressing/moving/releasing points one by one.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.input.TouchPoint> touchPoints;

    /**
    * Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8 (default: 0).
    */
    private Integer modifiers;

    /**
    * Time at which the event occurred.
    */
    private java.math.BigDecimal timestamp;

    public void setType (jpuppeteer.cdp.client.constant.input.DispatchTouchEventRequestType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.input.DispatchTouchEventRequestType getType() {
        return this.type;
    }

    public void setTouchPoints (java.util.List<jpuppeteer.cdp.client.entity.input.TouchPoint> touchPoints) {
        this.touchPoints = touchPoints;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.input.TouchPoint> getTouchPoints() {
        return this.touchPoints;
    }

    public void setModifiers (Integer modifiers) {
        this.modifiers = modifiers;
    }

    public Integer getModifiers() {
        return this.modifiers;
    }

    public void setTimestamp (java.math.BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public java.math.BigDecimal getTimestamp() {
        return this.timestamp;
    }

    public DispatchTouchEventRequest(jpuppeteer.cdp.client.constant.input.DispatchTouchEventRequestType type, java.util.List<jpuppeteer.cdp.client.entity.input.TouchPoint> touchPoints, Integer modifiers, java.math.BigDecimal timestamp) {
        this.type = type;
        this.touchPoints = touchPoints;
        this.modifiers = modifiers;
        this.timestamp = timestamp;
    }

    public DispatchTouchEventRequest(jpuppeteer.cdp.client.constant.input.DispatchTouchEventRequestType type, java.util.List<jpuppeteer.cdp.client.entity.input.TouchPoint> touchPoints) {
        this.type = type;
        this.touchPoints = touchPoints;
        this.modifiers = null;
        this.timestamp = null;
    }

    public DispatchTouchEventRequest() {
    }

}