package jpuppeteer.cdp.client.entity.storage;

/**
* Usage for a storage type.
* experimental
*/
public class UsageForType {

    /**
    * Name of storage type.
    */
    public final jpuppeteer.cdp.client.constant.storage.StorageType storageType;

    /**
    * Storage usage (bytes).
    */
    public final java.math.BigDecimal usage;

    public UsageForType(jpuppeteer.cdp.client.constant.storage.StorageType storageType, java.math.BigDecimal usage) {
        this.storageType = storageType;
        this.usage = usage;
    }

}