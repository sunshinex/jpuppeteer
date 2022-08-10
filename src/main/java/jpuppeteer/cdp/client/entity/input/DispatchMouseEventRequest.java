package jpuppeteer.cdp.client.entity.input;

/**
*/
public class DispatchMouseEventRequest {

    /**
    * Type of the mouse event.
    */
    private jpuppeteer.cdp.client.constant.input.DispatchMouseEventRequestType type;

    /**
    * X coordinate of the event relative to the main frame's viewport in CSS pixels.
    */
    private java.math.BigDecimal x;

    /**
    * Y coordinate of the event relative to the main frame's viewport in CSS pixels. 0 refers to the top of the viewport and Y increases as it proceeds towards the bottom of the viewport.
    */
    private java.math.BigDecimal y;

    /**
    * Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8 (default: 0).
    */
    private Integer modifiers;

    /**
    * Time at which the event occurred.
    */
    private java.math.BigDecimal timestamp;

    /**
    * Mouse button (default: "none").
    */
    private jpuppeteer.cdp.client.constant.input.MouseButton button;

    /**
    * A number indicating which buttons are pressed on the mouse when a mouse event is triggered. Left=1, Right=2, Middle=4, Back=8, Forward=16, None=0.
    */
    private Integer buttons;

    /**
    * Number of times the mouse button was clicked (default: 0).
    */
    private Integer clickCount;

    /**
    * The normalized pressure, which has a range of [0,1] (default: 0).
    */
    private java.math.BigDecimal force;

    /**
    * The normalized tangential pressure, which has a range of [-1,1] (default: 0).
    */
    private java.math.BigDecimal tangentialPressure;

    /**
    * The plane angle between the Y-Z plane and the plane containing both the stylus axis and the Y axis, in degrees of the range [-90,90], a positive tiltX is to the right (default: 0).
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
    * X delta in CSS pixels for mouse wheel event (default: 0).
    */
    private java.math.BigDecimal deltaX;

    /**
    * Y delta in CSS pixels for mouse wheel event (default: 0).
    */
    private java.math.BigDecimal deltaY;

    /**
    * Pointer type (default: "mouse").
    */
    private jpuppeteer.cdp.client.constant.input.DispatchMouseEventRequestPointerType pointerType;

    public void setType (jpuppeteer.cdp.client.constant.input.DispatchMouseEventRequestType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.input.DispatchMouseEventRequestType getType() {
        return this.type;
    }

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

    public void setButton (jpuppeteer.cdp.client.constant.input.MouseButton button) {
        this.button = button;
    }

    public jpuppeteer.cdp.client.constant.input.MouseButton getButton() {
        return this.button;
    }

    public void setButtons (Integer buttons) {
        this.buttons = buttons;
    }

    public Integer getButtons() {
        return this.buttons;
    }

    public void setClickCount (Integer clickCount) {
        this.clickCount = clickCount;
    }

    public Integer getClickCount() {
        return this.clickCount;
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

    public void setDeltaX (java.math.BigDecimal deltaX) {
        this.deltaX = deltaX;
    }

    public java.math.BigDecimal getDeltaX() {
        return this.deltaX;
    }

    public void setDeltaY (java.math.BigDecimal deltaY) {
        this.deltaY = deltaY;
    }

    public java.math.BigDecimal getDeltaY() {
        return this.deltaY;
    }

    public void setPointerType (jpuppeteer.cdp.client.constant.input.DispatchMouseEventRequestPointerType pointerType) {
        this.pointerType = pointerType;
    }

    public jpuppeteer.cdp.client.constant.input.DispatchMouseEventRequestPointerType getPointerType() {
        return this.pointerType;
    }

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

    public DispatchMouseEventRequest() {
    }

}