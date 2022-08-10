package jpuppeteer.cdp.client.entity.domstorage;

/**
* experimental
*/
public class ClearRequest {

    /**
    */
    private jpuppeteer.cdp.client.entity.domstorage.StorageId storageId;

    public void setStorageId (jpuppeteer.cdp.client.entity.domstorage.StorageId storageId) {
        this.storageId = storageId;
    }

    public jpuppeteer.cdp.client.entity.domstorage.StorageId getStorageId() {
        return this.storageId;
    }

    public ClearRequest(jpuppeteer.cdp.client.entity.domstorage.StorageId storageId) {
        this.storageId = storageId;
    }

    public ClearRequest() {
    }

}