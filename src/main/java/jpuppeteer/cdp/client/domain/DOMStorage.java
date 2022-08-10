package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class DOMStorage {

    private jpuppeteer.cdp.CDPConnection connection;

    public DOMStorage(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    */
    public jpuppeteer.util.XFuture<?> clear(jpuppeteer.cdp.client.entity.domstorage.ClearRequest request) {
        return connection.send("DOMStorage.clear", request);
    }


    /**
    * Disables storage tracking, prevents storage events from being sent to the client.
    */
    public jpuppeteer.util.XFuture<?> disable() {
        return connection.send("DOMStorage.disable", null);
    }


    /**
    * Enables storage tracking, storage events will now be delivered to the client.
    */
    public jpuppeteer.util.XFuture<?> enable() {
        return connection.send("DOMStorage.enable", null);
    }


    /**
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.domstorage.GetDOMStorageItemsResponse> getDOMStorageItems(jpuppeteer.cdp.client.entity.domstorage.GetDOMStorageItemsRequest request) {
        return connection.send("DOMStorage.getDOMStorageItems", request, jpuppeteer.cdp.client.entity.domstorage.GetDOMStorageItemsResponse.class);
    }


    /**
    */
    public jpuppeteer.util.XFuture<?> removeDOMStorageItem(jpuppeteer.cdp.client.entity.domstorage.RemoveDOMStorageItemRequest request) {
        return connection.send("DOMStorage.removeDOMStorageItem", request);
    }


    /**
    */
    public jpuppeteer.util.XFuture<?> setDOMStorageItem(jpuppeteer.cdp.client.entity.domstorage.SetDOMStorageItemRequest request) {
        return connection.send("DOMStorage.setDOMStorageItem", request);
    }

}