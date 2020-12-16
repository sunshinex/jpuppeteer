package jpuppeteer.cdp.client.entity.storage;

/**
* experimental
*/
public class ClearDataForOriginRequest {

    /**
    * Security origin.
    */
    public final String origin;

    /**
    * Comma separated list of StorageType to clear.
    */
    public final String storageTypes;

    public ClearDataForOriginRequest(String origin, String storageTypes) {
        this.origin = origin;
        this.storageTypes = storageTypes;
    }

}