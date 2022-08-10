package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* experimental
*/
public class AddInspectedHeapObjectRequest {

    /**
    * Heap snapshot object id to be accessible by means of $x command line API.
    */
    private String heapObjectId;

    public void setHeapObjectId (String heapObjectId) {
        this.heapObjectId = heapObjectId;
    }

    public String getHeapObjectId() {
        return this.heapObjectId;
    }

    public AddInspectedHeapObjectRequest(String heapObjectId) {
        this.heapObjectId = heapObjectId;
    }

    public AddInspectedHeapObjectRequest() {
    }

}