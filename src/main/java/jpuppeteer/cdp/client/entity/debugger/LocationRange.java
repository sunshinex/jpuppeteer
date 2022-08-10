package jpuppeteer.cdp.client.entity.debugger;

/**
* Location range within one script.
*/
public class LocationRange {

    /**
    */
    private String scriptId;

    /**
    */
    private jpuppeteer.cdp.client.entity.debugger.ScriptPosition start;

    /**
    */
    private jpuppeteer.cdp.client.entity.debugger.ScriptPosition end;

    public void setScriptId (String scriptId) {
        this.scriptId = scriptId;
    }

    public String getScriptId() {
        return this.scriptId;
    }

    public void setStart (jpuppeteer.cdp.client.entity.debugger.ScriptPosition start) {
        this.start = start;
    }

    public jpuppeteer.cdp.client.entity.debugger.ScriptPosition getStart() {
        return this.start;
    }

    public void setEnd (jpuppeteer.cdp.client.entity.debugger.ScriptPosition end) {
        this.end = end;
    }

    public jpuppeteer.cdp.client.entity.debugger.ScriptPosition getEnd() {
        return this.end;
    }

    public LocationRange(String scriptId, jpuppeteer.cdp.client.entity.debugger.ScriptPosition start, jpuppeteer.cdp.client.entity.debugger.ScriptPosition end) {
        this.scriptId = scriptId;
        this.start = start;
        this.end = end;
    }

    public LocationRange() {
    }

}