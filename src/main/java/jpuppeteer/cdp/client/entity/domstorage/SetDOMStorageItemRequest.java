package jpuppeteer.cdp.client.entity.domstorage;

/**
* experimental
*/
public class SetDOMStorageItemRequest {

    /**
    */
    public final jpuppeteer.cdp.client.entity.domstorage.StorageId storageId;

    /**
    */
    public final String key;

    /**
    */
    public final String value;

    public SetDOMStorageItemRequest(jpuppeteer.cdp.client.entity.domstorage.StorageId storageId, String key, String value) {
        this.storageId = storageId;
        this.key = key;
        this.value = value;
    }

}