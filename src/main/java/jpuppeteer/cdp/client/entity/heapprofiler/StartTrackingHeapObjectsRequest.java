package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* experimental
*/
public class StartTrackingHeapObjectsRequest {

    /**
    */
    private Boolean trackAllocations;

    public void setTrackAllocations (Boolean trackAllocations) {
        this.trackAllocations = trackAllocations;
    }

    public Boolean getTrackAllocations() {
        return this.trackAllocations;
    }

    public StartTrackingHeapObjectsRequest(Boolean trackAllocations) {
        this.trackAllocations = trackAllocations;
    }

    public StartTrackingHeapObjectsRequest() {
        this.trackAllocations = null;
    }

}