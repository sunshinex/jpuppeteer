package jpuppeteer.cdp.client.entity.domstorage;

/**
* experimental
*/
public class RemoveDOMStorageItemRequest {

    /**
    */
    public final StorageId storageId;

    /**
    */
    public final String key;

    public RemoveDOMStorageItemRequest(StorageId storageId, String key) {
        this.storageId = storageId;
        this.key = key;
    }

}