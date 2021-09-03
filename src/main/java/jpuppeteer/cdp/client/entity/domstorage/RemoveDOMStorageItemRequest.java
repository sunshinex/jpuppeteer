package jpuppeteer.cdp.client.entity.domstorage;

/**
* experimental
*/
public class RemoveDOMStorageItemRequest {

    /**
    */
    public final jpuppeteer.cdp.client.entity.domstorage.StorageId storageId;

    /**
    */
    public final String key;

    public RemoveDOMStorageItemRequest(jpuppeteer.cdp.client.entity.domstorage.StorageId storageId, String key) {
        this.storageId = storageId;
        this.key = key;
    }

}