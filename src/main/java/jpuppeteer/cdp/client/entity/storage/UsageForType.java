package jpuppeteer.cdp.client.entity.storage;

/**
* Usage for a storage type.
* experimental
*/
public class UsageForType {

    /**
    * Name of storage type.
    */
    private jpuppeteer.cdp.client.constant.storage.StorageType storageType;

    /**
    * Storage usage (bytes).
    */
    private java.math.BigDecimal usage;

    public void setStorageType (jpuppeteer.cdp.client.constant.storage.StorageType storageType) {
        this.storageType = storageType;
    }

    public jpuppeteer.cdp.client.constant.storage.StorageType getStorageType() {
        return this.storageType;
    }

    public void setUsage (java.math.BigDecimal usage) {
        this.usage = usage;
    }

    public java.math.BigDecimal getUsage() {
        return this.usage;
    }

    public UsageForType(jpuppeteer.cdp.client.constant.storage.StorageType storageType, java.math.BigDecimal usage) {
        this.storageType = storageType;
        this.usage = usage;
    }

    public UsageForType() {
    }

}