package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class SnapshotCommandLogResponse {

    /**
    * The array of canvas function calls.
    */
    public final java.util.List<java.util.Map<String, Object>> commandLog;

    public SnapshotCommandLogResponse(java.util.List<java.util.Map<String, Object>> commandLog) {
        this.commandLog = commandLog;
    }

}