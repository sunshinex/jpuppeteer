package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetBlackboxedRangesRequest {

    /**
    * Id of the script.
    */
    public final String scriptId;

    /**
    */
    public final java.util.List<ScriptPosition> positions;

    public SetBlackboxedRangesRequest(String scriptId, java.util.List<ScriptPosition> positions) {
        this.scriptId = scriptId;
        this.positions = positions;
    }

}