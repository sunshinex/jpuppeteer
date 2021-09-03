package jpuppeteer.cdp.client.entity.input;

/**
*/
public class DispatchDragEventRequest {

    /**
    * Type of the drag event.
    */
    public final jpuppeteer.cdp.client.constant.input.DispatchDragEventRequestType type;

    /**
    * X coordinate of the event relative to the main frame's viewport in CSS pixels.
    */
    public final java.math.BigDecimal x;

    /**
    * Y coordinate of the event relative to the main frame's viewport in CSS pixels. 0 refers to the top of the viewport and Y increases as it proceeds towards the bottom of the viewport.
    */
    public final java.math.BigDecimal y;

    /**
    */
    public final jpuppeteer.cdp.client.entity.input.DragData data;

    /**
    * Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8 (default: 0).
    */
    public final Integer modifiers;

    public DispatchDragEventRequest(jpuppeteer.cdp.client.constant.input.DispatchDragEventRequestType type, java.math.BigDecimal x, java.math.BigDecimal y, jpuppeteer.cdp.client.entity.input.DragData data, Integer modifiers) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.data = data;
        this.modifiers = modifiers;
    }

    public DispatchDragEventRequest(jpuppeteer.cdp.client.constant.input.DispatchDragEventRequestType type, java.math.BigDecimal x, java.math.BigDecimal y, jpuppeteer.cdp.client.entity.input.DragData data) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.data = data;
        this.modifiers = null;
    }

}