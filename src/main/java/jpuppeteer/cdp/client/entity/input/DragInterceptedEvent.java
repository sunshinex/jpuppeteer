package jpuppeteer.cdp.client.entity.input;

/**
* Emitted only when `Input.setInterceptDrags` is enabled. Use this data with `Input.dispatchDragEvent` to restore normal drag and drop behavior.
*/
public class DragInterceptedEvent {

    /**
    */
    private jpuppeteer.cdp.client.entity.input.DragData data;

    public void setData (jpuppeteer.cdp.client.entity.input.DragData data) {
        this.data = data;
    }

    public jpuppeteer.cdp.client.entity.input.DragData getData() {
        return this.data;
    }

    public DragInterceptedEvent(jpuppeteer.cdp.client.entity.input.DragData data) {
        this.data = data;
    }

    public DragInterceptedEvent() {
    }

}