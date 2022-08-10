package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetBlackboxedRangesRequest {

    /**
    * Id of the script.
    */
    private String scriptId;

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.entity.debugger.ScriptPosition> positions;

    public void setScriptId (String scriptId) {
        this.scriptId = scriptId;
    }

    public String getScriptId() {
        return this.scriptId;
    }

    public void setPositions (java.util.List<jpuppeteer.cdp.client.entity.debugger.ScriptPosition> positions) {
        this.positions = positions;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.debugger.ScriptPosition> getPositions() {
        return this.positions;
    }

    public SetBlackboxedRangesRequest(String scriptId, java.util.List<jpuppeteer.cdp.client.entity.debugger.ScriptPosition> positions) {
        this.scriptId = scriptId;
        this.positions = positions;
    }

    public SetBlackboxedRangesRequest() {
    }

}