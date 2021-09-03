package jpuppeteer.cdp.client.entity.domstorage;

/**
* experimental
*/
public class DomStorageItemsClearedEvent {

    /**
    */
    public final jpuppeteer.cdp.client.entity.domstorage.StorageId storageId;

    public DomStorageItemsClearedEvent(jpuppeteer.cdp.client.entity.domstorage.StorageId storageId) {
        this.storageId = storageId;
    }

}