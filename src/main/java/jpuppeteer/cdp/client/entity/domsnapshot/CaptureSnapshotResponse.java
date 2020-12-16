package jpuppeteer.cdp.client.entity.domsnapshot;

/**
* experimental
*/
public class CaptureSnapshotResponse {

    /**
    * The nodes in the DOM tree. The DOMNode at index 0 corresponds to the root document.
    */
    public final java.util.List<DocumentSnapshot> documents;

    /**
    * Shared string table that all string properties refer to with indexes.
    */
    public final java.util.List<String> strings;

    public CaptureSnapshotResponse(java.util.List<DocumentSnapshot> documents, java.util.List<String> strings) {
        this.documents = documents;
        this.strings = strings;
    }

}