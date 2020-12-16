package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* experimental
*/
public class GetHeapObjectIdResponse {

    /**
    * Id of the heap snapshot object corresponding to the passed remote object id.
    */
    public final String heapSnapshotObjectId;

    public GetHeapObjectIdResponse(String heapSnapshotObjectId) {
        this.heapSnapshotObjectId = heapSnapshotObjectId;
    }

}