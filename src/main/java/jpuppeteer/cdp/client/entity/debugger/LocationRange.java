package jpuppeteer.cdp.client.entity.debugger;

/**
* Location range within one script.
*/
public class LocationRange {

    /**
    */
    public final String scriptId;

    /**
    */
    public final jpuppeteer.cdp.client.entity.debugger.ScriptPosition start;

    /**
    */
    public final jpuppeteer.cdp.client.entity.debugger.ScriptPosition end;

    public LocationRange(String scriptId, jpuppeteer.cdp.client.entity.debugger.ScriptPosition start, jpuppeteer.cdp.client.entity.debugger.ScriptPosition end) {
        this.scriptId = scriptId;
        this.start = start;
        this.end = end;
    }

}