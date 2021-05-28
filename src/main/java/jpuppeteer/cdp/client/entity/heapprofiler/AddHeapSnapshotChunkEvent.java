package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* experimental
*/
public class AddHeapSnapshotChunkEvent {

    /**
    */
    public final String chunk;

    public AddHeapSnapshotChunkEvent(String chunk) {
        this.chunk = chunk;
    }

}