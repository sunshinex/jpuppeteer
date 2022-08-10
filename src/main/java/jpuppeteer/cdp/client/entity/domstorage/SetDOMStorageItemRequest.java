package jpuppeteer.cdp.client.entity.domstorage;

/**
* experimental
*/
public class SetDOMStorageItemRequest {

    /**
    */
    private jpuppeteer.cdp.client.entity.domstorage.StorageId storageId;

    /**
    */
    private String key;

    /**
    */
    private String value;

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

    public void setValue (String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public SetDOMStorageItemRequest(jpuppeteer.cdp.client.entity.domstorage.StorageId storageId, String key, String value) {
        this.storageId = storageId;
        this.key = key;
        this.value = value;
    }

    public SetDOMStorageItemRequest() {
    }

}