package jpuppeteer.cdp.client.entity.domstorage;

/**
* experimental
*/
public class RemoveDOMStorageItemRequest {

    /**
    */
    private jpuppeteer.cdp.client.entity.domstorage.StorageId storageId;

    /**
    */
    private String key;

    public void setStorageId (jpuppeteer.cdp.client.entity.domstorage.StorageId storageId) {
        this.storageId = storageId;
    }

    public jpuppeteer.cdp.client.entity.domstorage.StorageId getStorageId() {
        return this.storageId;
    }

    public void setKey (String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

    public RemoveDOMStorageItemRequest(jpuppeteer.cdp.client.entity.domstorage.StorageId storageId, String key) {
        this.storageId = storageId;
        this.key = key;
    }

    public RemoveDOMStorageItemRequest() {
    }

}