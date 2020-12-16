package jpuppeteer.cdp.client.entity.domstorage;

/**
* experimental
*/
public class DomStorageItemRemovedEvent {

    /**
    */
    public final StorageId storageId;

    /**
    */
    public final String key;

    public DomStorageItemRemovedEvent(StorageId storageId, String key) {
        this.storageId = storageId;
        this.key = key;
    }

}