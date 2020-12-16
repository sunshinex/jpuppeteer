package jpuppeteer.cdp.client.entity.domstorage;

/**
* experimental
*/
public class GetDOMStorageItemsRequest {

    /**
    */
    public final StorageId storageId;

    public GetDOMStorageItemsRequest(StorageId storageId) {
        this.storageId = storageId;
    }

}