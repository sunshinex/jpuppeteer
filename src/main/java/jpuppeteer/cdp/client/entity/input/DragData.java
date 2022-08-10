package jpuppeteer.cdp.client.entity.input;

/**
*/
public class DragData {

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.entity.input.DragDataItem> items;

    /**
    * Bit field representing allowed drag operations. Copy = 1, Link = 2, Move = 16
    */
    private Integer dragOperationsMask;

    public void setItems (java.util.List<jpuppeteer.cdp.client.entity.input.DragDataItem> items) {
        this.items = items;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.input.DragDataItem> getItems() {
        return this.items;
    }

    public void setDragOperationsMask (Integer dragOperationsMask) {
        this.dragOperationsMask = dragOperationsMask;
    }

    public Integer getDragOperationsMask() {
        return this.dragOperationsMask;
    }

    public DragData(java.util.List<jpuppeteer.cdp.client.entity.input.DragDataItem> items, Integer dragOperationsMask) {
        this.items = items;
        this.dragOperationsMask = dragOperationsMask;
    }

    public DragData() {
    }

}