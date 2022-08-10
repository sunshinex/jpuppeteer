package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class SnapshotCommandLogResponse {

    /**
    * The array of canvas function calls.
    */
    private java.util.List<java.util.Map<String, Object>> commandLog;

    public void setCommandLog (java.util.List<java.util.Map<String, Object>> commandLog) {
        this.commandLog = commandLog;
    }

    public java.util.List<java.util.Map<String, Object>> getCommandLog() {
        return this.commandLog;
    }

    public SnapshotCommandLogResponse(java.util.List<java.util.Map<String, Object>> commandLog) {
        this.commandLog = commandLog;
    }

    public SnapshotCommandLogResponse() {
    }

}