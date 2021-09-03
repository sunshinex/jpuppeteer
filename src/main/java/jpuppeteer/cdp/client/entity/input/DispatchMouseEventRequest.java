package jpuppeteer.cdp.client.entity.input;

/**
*/
public class DispatchMouseEventRequest {

    /**
    * Type of the mouse event.
    */
    public final jpuppeteer.cdp.client.constant.input.DispatchMouseEventRequestType type;

    /**
    * X coordinate of the event relative to the main frame's viewport in CSS pixels.
    */
    public final java.math.BigDecimal x;

    /**
    * Y coordinate of the event relative to the main frame's viewport in CSS pixels. 0 refers to the top of the viewport and Y increases as it proceeds towards the bottom of the viewport.
    */
    public final java.math.BigDecimal y;

    /**
    * Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8 (default: 0).
    */
    public final Integer modifiers;

    /**
    * Time at which the event occurred.
    */
    public final java.math.BigDecimal timestamp;

    /**
    * Mouse button (default: "none").
    */
    public final jpuppeteer.cdp.client.constant.input.MouseButton button;

    /**
    * A number indicating which buttons are pressed on the mouse when a mouse event is triggered. Left=1, Right=2, Middle=4, Back=8, Forward=16, None=0.
    */
    public final Integer buttons;

    /**
    * Number of times the mouse button was clicked (default: 0).
    */
    public final Integer clickCount;

    /**
    * The normalized pressure, which has a range of [0,1] (default: 0).
    */
    public final java.math.BigDecimal force;

    /**
    * The normalized tangential pressure, which has a range of [-1,1] (default: 0).
    */
    public final java.math.BigDecimal tangentialPressure;

    /**
    * The plane angle between the Y-Z plane and the plane containing both the stylus axis and the Y axis, in degrees of the range [-90,90], a positive tiltX is to the right (default: 0).
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
    * X delta in CSS pixels for mouse wheel event (default: 0).
    */
    public final java.math.BigDecimal deltaX;

    /**
    * Y delta in CSS pixels for mouse wheel event (default: 0).
    */
    public final java.math.BigDecimal deltaY;

    /**
    * Pointer type (default: "mouse").
    */
    public final jpuppeteer.cdp.client.constant.input.DispatchMouseEventRequestPointerType pointerType;

    public DispatchMouseEventRequest(jpuppeteer.cdp.client.constant.input.DispatchMouseEventRequestType type, java.math.BigDecimal x, java.math.BigDecimal y, Integer modifiers, java.math.BigDecimal timestamp, jpuppeteer.cdp.client.constant.input.MouseButton button, Integer buttons, Integer clickCount, java.math.BigDecimal force, java.math.BigDecimal tangentialPressure, Integer tiltX, Integer tiltY, Integer twist, java.math.BigDecimal deltaX, java.math.BigDecimal deltaY, jpuppeteer.cdp.client.constant.input.DispatchMouseEventRequestPointerType pointerType) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.modifiers = modifiers;
        this.timestamp = timestamp;
        this.button = button;
        this.buttons = buttons;
        this.clickCount = clickCount;
        this.force = force;
        this.tangentialPressure = tangentialPressure;
        this.tiltX = tiltX;
        this.tiltY = tiltY;
        this.twist = twist;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.pointerType = pointerType;
    }

    public DispatchMouseEventRequest(jpuppeteer.cdp.client.constant.input.DispatchMouseEventRequestType type, java.math.BigDecimal x, java.math.BigDecimal y) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.modifiers = null;
        this.timestamp = null;
        this.button = null;
        this.buttons = null;
        this.clickCount = null;
        this.force = null;
        this.tangentialPressure = null;
        this.tiltX = null;
        this.tiltY = null;
        this.twist = null;
        this.deltaX = null;
        this.deltaY = null;
        this.pointerType = null;
    }

}