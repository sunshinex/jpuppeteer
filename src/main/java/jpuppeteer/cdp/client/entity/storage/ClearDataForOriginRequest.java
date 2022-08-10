package jpuppeteer.cdp.client.entity.storage;

/**
* experimental
*/
public class ClearDataForOriginRequest {

    /**
    * Security origin.
    */
    private String origin;

    /**
    * Comma separated list of StorageType to clear.
    */
    private String storageTypes;

    public void setOrigin (String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setStorageTypes (String storageTypes) {
        this.storageTypes = storageTypes;
    }

    public String getStorageTypes() {
        return this.storageTypes;
    }

    public ClearDataForOriginRequest(String origin, String storageTypes) {
        this.origin = origin;
        this.storageTypes = storageTypes;
    }

    public ClearDataForOriginRequest() {
    }

}