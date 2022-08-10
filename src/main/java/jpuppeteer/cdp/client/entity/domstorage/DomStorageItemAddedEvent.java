package jpuppeteer.cdp.client.entity.domstorage;

/**
* experimental
*/
public class DomStorageItemAddedEvent {

    /**
    */
    private jpuppeteer.cdp.client.entity.domstorage.StorageId storageId;

    /**
    */
    private String key;

    /**
    */
    private String newValue;

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

    public void setNewValue (String newValue) {
        this.newValue = newValue;
    }

    public String getNewValue() {
        return this.newValue;
    }

    public DomStorageItemAddedEvent(jpuppeteer.cdp.client.entity.domstorage.StorageId storageId, String key, String newValue) {
        this.storageId = storageId;
        this.key = key;
        this.newValue = newValue;
    }

    public DomStorageItemAddedEvent() {
    }

}