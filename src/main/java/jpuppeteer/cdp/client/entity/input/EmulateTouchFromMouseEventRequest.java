package jpuppeteer.cdp.client.entity.input;

/**
*/
public class EmulateTouchFromMouseEventRequest {

    /**
    * Type of the mouse event.
    */
    private jpuppeteer.cdp.client.constant.input.EmulateTouchFromMouseEventRequestType type;

    /**
    * X coordinate of the mouse pointer in DIP.
    */
    private Integer x;

    /**
    * Y coordinate of the mouse pointer in DIP.
    */
    private Integer y;

    /**
    * Mouse button. Only "none", "left", "right" are supported.
    */
    private jpuppeteer.cdp.client.constant.input.MouseButton button;

    /**
    * Time at which the event occurred (default: current time).
    */
    private java.math.BigDecimal timestamp;

    /**
    * X delta in DIP for mouse wheel event (default: 0).
    */
    private java.math.BigDecimal deltaX;

    /**
    * Y delta in DIP for mouse wheel event (default: 0).
    */
    private java.math.BigDecimal deltaY;

    /**
    * Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8 (default: 0).
    */
    private Integer modifiers;

    /**
    * Number of times the mouse button was clicked (default: 0).
    */
    private Integer clickCount;

    public void setType (jpuppeteer.cdp.client.constant.input.EmulateTouchFromMouseEventRequestType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.input.EmulateTouchFromMouseEventRequestType getType() {
        return this.type;
    }

    public void setX (Integer x) {
        this.x = x;
    }

    public Integer getX() {
        return this.x;
    }

    public void setY (Integer y) {
        this.y = y;
    }

    public Integer getY() {
        return this.y;
    }

    public void setButton (jpuppeteer.cdp.client.constant.input.MouseButton button) {
        this.button = button;
    }

    public jpuppeteer.cdp.client.constant.input.MouseButton getButton() {
        return this.button;
    }

    public void setTimestamp (java.math.BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public java.math.BigDecimal getTimestamp() {
        return this.timestamp;
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

    public void setModifiers (Integer modifiers) {
        this.modifiers = modifiers;
    }

    public Integer getModifiers() {
        return this.modifiers;
    }

    public void setClickCount (Integer clickCount) {
        this.clickCount = clickCount;
    }

    public Integer getClickCount() {
        return this.clickCount;
    }

    public EmulateTouchFromMouseEventRequest(jpuppeteer.cdp.client.constant.input.EmulateTouchFromMouseEventRequestType type, Integer x, Integer y, jpuppeteer.cdp.client.constant.input.MouseButton button, java.math.BigDecimal timestamp, java.math.BigDecimal deltaX, java.math.BigDecimal deltaY, Integer modifiers, Integer clickCount) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.button = button;
        this.timestamp = timestamp;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.modifiers = modifiers;
        this.clickCount = clickCount;
    }

    public EmulateTouchFromMouseEventRequest(jpuppeteer.cdp.client.constant.input.EmulateTouchFromMouseEventRequestType type, Integer x, Integer y, jpuppeteer.cdp.client.constant.input.MouseButton button) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.button = button;
        this.timestamp = null;
        this.deltaX = null;
        this.deltaY = null;
        this.modifiers = null;
        this.clickCount = null;
    }

    public EmulateTouchFromMouseEventRequest() {
    }

}