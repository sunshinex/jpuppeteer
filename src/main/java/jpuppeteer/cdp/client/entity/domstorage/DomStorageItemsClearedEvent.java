package jpuppeteer.cdp.client.entity.domstorage;

/**
* experimental
*/
public class DomStorageItemsClearedEvent {

    /**
    */
    public final StorageId storageId;

    public DomStorageItemsClearedEvent(StorageId storageId) {
        this.storageId = storageId;
    }

}