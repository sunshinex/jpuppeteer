package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class StepOverRequest {

    /**
    * The skipList specifies location ranges that should be skipped on step over.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.debugger.LocationRange> skipList;

    public void setSkipList (java.util.List<jpuppeteer.cdp.client.entity.debugger.LocationRange> skipList) {
        this.skipList = skipList;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.debugger.LocationRange> getSkipList() {
        return this.skipList;
    }

    public StepOverRequest(java.util.List<jpuppeteer.cdp.client.entity.debugger.LocationRange> skipList) {
        this.skipList = skipList;
    }

    public StepOverRequest() {
        this.skipList = null;
    }

}