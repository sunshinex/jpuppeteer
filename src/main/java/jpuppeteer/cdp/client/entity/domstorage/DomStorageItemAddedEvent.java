package jpuppeteer.cdp.client.entity.domstorage;

/**
* experimental
*/
public class DomStorageItemAddedEvent {

    /**
    */
    public final jpuppeteer.cdp.client.entity.domstorage.StorageId storageId;

    /**
    */
    public final String key;

    /**
    */
    public final String newValue;

    public DomStorageItemAddedEvent(jpuppeteer.cdp.client.entity.domstorage.StorageId storageId, String key, String newValue) {
        this.storageId = storageId;
        this.key = key;
        this.newValue = newValue;
    }

}