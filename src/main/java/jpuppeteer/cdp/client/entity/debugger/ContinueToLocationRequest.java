package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class ContinueToLocationRequest {

    /**
    * Location to continue to.
    */
    public final jpuppeteer.cdp.client.entity.debugger.Location location;

    /**
    */
    public final String targetCallFrames;

    public ContinueToLocationRequest(jpuppeteer.cdp.client.entity.debugger.Location location, String targetCallFrames) {
        this.location = location;
        this.targetCallFrames = targetCallFrames;
    }

    public ContinueToLocationRequest(jpuppeteer.cdp.client.entity.debugger.Location location) {
        this.location = location;
        this.targetCallFrames = null;
    }

}