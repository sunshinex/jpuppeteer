package jpuppeteer.cdp.cdp.domain;

/**
* experimental
*/
public class DOMStorage {

    private jpuppeteer.cdp.CDPSession session;

    public DOMStorage(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * experimental
    */
    public void clear(jpuppeteer.cdp.cdp.entity.domstorage.ClearRequest request, int timeout) throws Exception {
        session.send("DOMStorage.clear", request, timeout);
    }


    /**
    * Disables storage tracking, prevents storage events from being sent to the client.
    * experimental
    */
    public void disable(int timeout) throws Exception {
        session.send("DOMStorage.disable", null, timeout);
    }


    /**
    * Enables storage tracking, storage events will now be delivered to the client.
    * experimental
    */
    public void enable(int timeout) throws Exception {
        session.send("DOMStorage.enable", null, timeout);
    }


    /**
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.domstorage.GetDOMStorageItemsResponse getDOMStorageItems(jpuppeteer.cdp.cdp.entity.domstorage.GetDOMStorageItemsRequest request, int timeout) throws Exception {
        return session.send("DOMStorage.getDOMStorageItems", request, jpuppeteer.cdp.cdp.entity.domstorage.GetDOMStorageItemsResponse.class, timeout);
    }


    /**
    * experimental
    */
    public void removeDOMStorageItem(jpuppeteer.cdp.cdp.entity.domstorage.RemoveDOMStorageItemRequest request, int timeout) throws Exception {
        session.send("DOMStorage.removeDOMStorageItem", request, timeout);
    }


    /**
    * experimental
    */
    public void setDOMStorageItem(jpuppeteer.cdp.cdp.entity.domstorage.SetDOMStorageItemRequest request, int timeout) throws Exception {
        session.send("DOMStorage.setDOMStorageItem", request, timeout);
    }

}