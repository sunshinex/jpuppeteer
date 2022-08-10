package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* experimental
*/
public class AddHeapSnapshotChunkEvent {

    /**
    */
    private String chunk;

    public void setChunk (String chunk) {
        this.chunk = chunk;
    }

    public String getChunk() {
        return this.chunk;
    }

    public AddHeapSnapshotChunkEvent(String chunk) {
        this.chunk = chunk;
    }

    public AddHeapSnapshotChunkEvent() {
    }

}