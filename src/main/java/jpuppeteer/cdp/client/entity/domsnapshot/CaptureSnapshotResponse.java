package jpuppeteer.cdp.client.entity.domsnapshot;

/**
* experimental
*/
public class CaptureSnapshotResponse {

    /**
    * The nodes in the DOM tree. The DOMNode at index 0 corresponds to the root document.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.DocumentSnapshot> documents;

    /**
    * Shared string table that all string properties refer to with indexes.
    */
    private java.util.List<String> strings;

    public void setDocuments (java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.DocumentSnapshot> documents) {
        this.documents = documents;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.DocumentSnapshot> getDocuments() {
        return this.documents;
    }

    public void setStrings (java.util.List<String> strings) {
        this.strings = strings;
    }

    public java.util.List<String> getStrings() {
        return this.strings;
    }

    public CaptureSnapshotResponse(java.util.List<jpuppeteer.cdp.client.entity.domsnapshot.DocumentSnapshot> documents, java.util.List<String> strings) {
        this.documents = documents;
        this.strings = strings;
    }

    public CaptureSnapshotResponse() {
    }

}