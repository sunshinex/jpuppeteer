package jpuppeteer.cdp.client.entity.domstorage;

/**
* experimental
*/
public class SetDOMStorageItemRequest {

    /**
    */
    public final StorageId storageId;

    /**
    */
    public final String key;

    /**
    */
    public final String value;

    public SetDOMStorageItemRequest(StorageId storageId, String key, String value) {
        this.storageId = storageId;
        this.key = key;
        this.value = value;
    }

}