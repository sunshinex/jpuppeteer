package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* experimental
*/
public class AddInspectedHeapObjectRequest {

    /**
    * Heap snapshot object id to be accessible by means of $x command line API.
    */
    public final String heapObjectId;

    public AddInspectedHeapObjectRequest(String heapObjectId) {
        this.heapObjectId = heapObjectId;
    }

}