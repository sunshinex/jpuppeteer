package jpuppeteer.cdp.client.entity.input;

/**
*/
public class EmulateTouchFromMouseEventRequest {

    /**
    * Type of the mouse event.
    */
    public final String type;

    /**
    * X coordinate of the mouse pointer in DIP.
    */
    public final Integer x;

    /**
    * Y coordinate of the mouse pointer in DIP.
    */
    public final Integer y;

    /**
    * Mouse button. Only "none", "left", "right" are supported.
    */
    public final String button;

    /**
    * Time at which the event occurred (default: current time).
    */
    public final java.math.BigDecimal timestamp;

    /**
    * X delta in DIP for mouse wheel event (default: 0).
    */
    public final java.math.BigDecimal deltaX;

    /**
    * Y delta in DIP for mouse wheel event (default: 0).
    */
    public final java.math.BigDecimal deltaY;

    /**
    * Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8 (default: 0).
    */
    public final Integer modifiers;

    /**
    * Number of times the mouse button was clicked (default: 0).
    */
    public final Integer clickCount;

    public EmulateTouchFromMouseEventRequest(String type, Integer x, Integer y, String button, java.math.BigDecimal timestamp, java.math.BigDecimal deltaX, java.math.BigDecimal deltaY, Integer modifiers, Integer clickCount) {
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

    public EmulateTouchFromMouseEventRequest(String type, Integer x, Integer y, String button) {
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

}