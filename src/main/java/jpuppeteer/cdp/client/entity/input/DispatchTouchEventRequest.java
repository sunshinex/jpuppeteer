package jpuppeteer.cdp.client.entity.input;

/**
*/
public class DispatchTouchEventRequest {

    /**
    * Type of the touch event. TouchEnd and TouchCancel must not contain any touch points, while TouchStart and TouchMove must contains at least one.
    */
    public final jpuppeteer.cdp.client.constant.input.DispatchTouchEventRequestType type;

    /**
    * Active touch points on the touch device. One event per any changed point (compared to previous touch event in a sequence) is generated, emulating pressing/moving/releasing points one by one.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.input.TouchPoint> touchPoints;

    /**
    * Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8 (default: 0).
    */
    public final Integer modifiers;

    /**
    * Time at which the event occurred.
    */
    public final java.math.BigDecimal timestamp;

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

}