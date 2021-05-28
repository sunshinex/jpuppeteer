package jpuppeteer.cdp.client.entity.input;

/**
*/
public class DragData {

    /**
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.input.DragDataItem> items;

    /**
    * Bit field representing allowed drag operations. Copy = 1, Link = 2, Move = 16
    */
    public final Integer dragOperationsMask;

    public DragData(java.util.List<jpuppeteer.cdp.client.entity.input.DragDataItem> items, Integer dragOperationsMask) {
        this.items = items;
        this.dragOperationsMask = dragOperationsMask;
    }

}