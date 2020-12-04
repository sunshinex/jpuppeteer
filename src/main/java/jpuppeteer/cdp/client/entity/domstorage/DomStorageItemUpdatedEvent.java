package jpuppeteer.cdp.client.entity.domstorage;

/**
* experimental
*/
public class DomStorageItemUpdatedEvent {

    /**
    */
    public final jpuppeteer.cdp.client.entity.domstorage.StorageId storageId;

    /**
    */
    public final String key;

    /**
    */
    public final String oldValue;

    /**
    */
    public final String newValue;

    public DomStorageItemUpdatedEvent(jpuppeteer.cdp.client.entity.domstorage.StorageId storageId, String key, String oldValue, String newValue) {
        this.storageId = storageId;
        this.key = key;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

}