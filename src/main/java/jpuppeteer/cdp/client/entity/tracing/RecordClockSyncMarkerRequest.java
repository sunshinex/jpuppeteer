package jpuppeteer.cdp.client.entity.tracing;

/**
* experimental
*/
public class RecordClockSyncMarkerRequest {

    /**
    * The ID of this clock sync marker
    */
    public final String syncId;

    public RecordClockSyncMarkerRequest(String syncId) {
        this.syncId = syncId;
    }

}