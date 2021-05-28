package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class StepOverRequest {

    /**
    * The skipList specifies location ranges that should be skipped on step over.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.debugger.LocationRange> skipList;

    public StepOverRequest(java.util.List<jpuppeteer.cdp.client.entity.debugger.LocationRange> skipList) {
        this.skipList = skipList;
    }

    public StepOverRequest() {
        this.skipList = null;
    }

}