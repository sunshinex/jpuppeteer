package jpuppeteer.cdp.client.entity.tracing;

/**
* experimental
*/
public class RecordClockSyncMarkerRequest {

    /**
    * The ID of this clock sync marker
    */
    private String syncId;

    public void setSyncId (String syncId) {
        this.syncId = syncId;
    }

    public String getSyncId() {
        return this.syncId;
    }

    public RecordClockSyncMarkerRequest(String syncId) {
        this.syncId = syncId;
    }

    public RecordClockSyncMarkerRequest() {
    }

}