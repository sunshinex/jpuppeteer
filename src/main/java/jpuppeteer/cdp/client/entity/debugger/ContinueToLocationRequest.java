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
    public final jpuppeteer.cdp.client.constant.debugger.ContinueToLocationRequestTargetCallFrames targetCallFrames;

    public ContinueToLocationRequest(jpuppeteer.cdp.client.entity.debugger.Location location, jpuppeteer.cdp.client.constant.debugger.ContinueToLocationRequestTargetCallFrames targetCallFrames) {
        this.location = location;
        this.targetCallFrames = targetCallFrames;
    }

    public ContinueToLocationRequest(jpuppeteer.cdp.client.entity.debugger.Location location) {
        this.location = location;
        this.targetCallFrames = null;
    }

}