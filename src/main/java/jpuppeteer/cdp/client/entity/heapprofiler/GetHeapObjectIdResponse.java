package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* experimental
*/
public class GetHeapObjectIdResponse {

    /**
    * Id of the heap snapshot object corresponding to the passed remote object id.
    */
    private String heapSnapshotObjectId;

    public void setHeapSnapshotObjectId (String heapSnapshotObjectId) {
        this.heapSnapshotObjectId = heapSnapshotObjectId;
    }

    public String getHeapSnapshotObjectId() {
        return this.heapSnapshotObjectId;
    }

    public GetHeapObjectIdResponse(String heapSnapshotObjectId) {
        this.heapSnapshotObjectId = heapSnapshotObjectId;
    }

    public GetHeapObjectIdResponse() {
    }

}