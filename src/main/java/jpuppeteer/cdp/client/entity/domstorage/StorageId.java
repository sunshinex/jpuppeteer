package jpuppeteer.cdp.client.entity.domstorage;

/**
* DOM Storage identifier.
* experimental
*/
public class StorageId {

    /**
    * Security origin for the storage.
    */
    private String securityOrigin;

    /**
    * Whether the storage is local storage (not session storage).
    */
    private Boolean isLocalStorage;

    public void setSecurityOrigin (String securityOrigin) {
        this.securityOrigin = securityOrigin;
    }

    public String getSecurityOrigin() {
        return this.securityOrigin;
    }

    public void setIsLocalStorage (Boolean isLocalStorage) {
        this.isLocalStorage = isLocalStorage;
    }

    public Boolean getIsLocalStorage() {
        return this.isLocalStorage;
    }

    public StorageId(String securityOrigin, Boolean isLocalStorage) {
        this.securityOrigin = securityOrigin;
        this.isLocalStorage = isLocalStorage;
    }

    public StorageId() {
    }

}