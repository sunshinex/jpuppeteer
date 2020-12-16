package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* experimental
*/
public class StartTrackingHeapObjectsRequest {

    /**
    */
    public final Boolean trackAllocations;

    public StartTrackingHeapObjectsRequest(Boolean trackAllocations) {
        this.trackAllocations = trackAllocations;
    }

    public StartTrackingHeapObjectsRequest() {
        this.trackAllocations = null;
    }

}