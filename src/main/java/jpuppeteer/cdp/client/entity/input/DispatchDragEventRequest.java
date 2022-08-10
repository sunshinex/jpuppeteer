package jpuppeteer.cdp.client.entity.input;

/**
*/
public class DispatchDragEventRequest {

    /**
    * Type of the drag event.
    */
    private jpuppeteer.cdp.client.constant.input.DispatchDragEventRequestType type;

    /**
    * X coordinate of the event relative to the main frame's viewport in CSS pixels.
    */
    private java.math.BigDecimal x;

    /**
    * Y coordinate of the event relative to the main frame's viewport in CSS pixels. 0 refers to the top of the viewport and Y increases as it proceeds towards the bottom of the viewport.
    */
    private java.math.BigDecimal y;

    /**
    */
    private jpuppeteer.cdp.client.entity.input.DragData data;

    /**
    * Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8 (default: 0).
    */
    private Integer modifiers;

    public void setType (jpuppeteer.cdp.client.constant.input.DispatchDragEventRequestType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.input.DispatchDragEventRequestType getType() {
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

    public void setData (jpuppeteer.cdp.client.entity.input.DragData data) {
        this.data = data;
    }

    public jpuppeteer.cdp.client.entity.input.DragData getData() {
        return this.data;
    }

    public void setModifiers (Integer modifiers) {
        this.modifiers = modifiers;
    }

    public Integer getModifiers() {
        return this.modifiers;
    }

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

    public DispatchDragEventRequest() {
    }

}