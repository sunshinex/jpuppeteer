package jpuppeteer.cdp.client.entity.domstorage;

/**
* experimental
*/
public class GetDOMStorageItemsResponse {

    /**
    */
    private java.util.List<java.util.List<String>> entries;

    public void setEntries (java.util.List<java.util.List<String>> entries) {
        this.entries = entries;
    }

    public java.util.List<java.util.List<String>> getEntries() {
        return this.entries;
    }

    public GetDOMStorageItemsResponse(java.util.List<java.util.List<String>> entries) {
        this.entries = entries;
    }

    public GetDOMStorageItemsResponse() {
    }

}