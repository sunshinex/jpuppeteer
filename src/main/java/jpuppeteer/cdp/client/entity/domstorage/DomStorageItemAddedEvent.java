package jpuppeteer.cdp.client.entity.domstorage;

/**
* experimental
*/
public class DomStorageItemAddedEvent {

    /**
    */
    public final StorageId storageId;

    /**
    */
    public final String key;

    /**
    */
    public final String newValue;

    public DomStorageItemAddedEvent(StorageId storageId, String key, String newValue) {
        this.storageId = storageId;
        this.key = key;
        this.newValue = newValue;
    }

}