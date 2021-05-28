package jpuppeteer.cdp.client.entity.domstorage;

/**
* DOM Storage identifier.
* experimental
*/
public class StorageId {

    /**
    * Security origin for the storage.
    */
    public final String securityOrigin;

    /**
    * Whether the storage is local storage (not session storage).
    */
    public final Boolean isLocalStorage;

    public StorageId(String securityOrigin, Boolean isLocalStorage) {
        this.securityOrigin = securityOrigin;
        this.isLocalStorage = isLocalStorage;
    }

}