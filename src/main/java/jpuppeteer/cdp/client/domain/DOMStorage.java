package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class DOMStorage {

    private jpuppeteer.cdp.CDPSession session;

    public DOMStorage(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    */
    public io.netty.util.concurrent.Future clear(jpuppeteer.cdp.client.entity.domstorage.ClearRequest request) {
        return session.send("DOMStorage.clear", request);
    }


    /**
    * Disables storage tracking, prevents storage events from being sent to the client.
    */
    public io.netty.util.concurrent.Future disable() {
        return session.send("DOMStorage.disable", null);
    }


    /**
    * Enables storage tracking, storage events will now be delivered to the client.
    */
    public io.netty.util.concurrent.Future enable() {
        return session.send("DOMStorage.enable", null);
    }


    /**
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.domstorage.GetDOMStorageItemsResponse> getDOMStorageItems(jpuppeteer.cdp.client.entity.domstorage.GetDOMStorageItemsRequest request) {
        return session.send("DOMStorage.getDOMStorageItems", request, jpuppeteer.cdp.client.entity.domstorage.GetDOMStorageItemsResponse.class);
    }


    /**
    */
    public io.netty.util.concurrent.Future removeDOMStorageItem(jpuppeteer.cdp.client.entity.domstorage.RemoveDOMStorageItemRequest request) {
        return session.send("DOMStorage.removeDOMStorageItem", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future setDOMStorageItem(jpuppeteer.cdp.client.entity.domstorage.SetDOMStorageItemRequest request) {
        return session.send("DOMStorage.setDOMStorageItem", request);
    }

}