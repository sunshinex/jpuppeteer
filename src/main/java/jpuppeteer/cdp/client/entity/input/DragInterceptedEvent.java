package jpuppeteer.cdp.client.entity.input;

/**
* Emitted only when `Input.setInterceptDrags` is enabled. Use this data with `Input.dispatchDragEvent` to restore normal drag and drop behavior.
*/
public class DragInterceptedEvent {

    /**
    */
    public final jpuppeteer.cdp.client.entity.input.DragData data;

    public DragInterceptedEvent(jpuppeteer.cdp.client.entity.input.DragData data) {
        this.data = data;
    }

}