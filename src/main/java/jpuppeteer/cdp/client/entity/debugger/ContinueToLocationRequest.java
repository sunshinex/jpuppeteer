package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class ContinueToLocationRequest {

    /**
    * Location to continue to.
    */
    private jpuppeteer.cdp.client.entity.debugger.Location location;

    /**
    */
    private jpuppeteer.cdp.client.constant.debugger.ContinueToLocationRequestTargetCallFrames targetCallFrames;

    public void setLocation (jpuppeteer.cdp.client.entity.debugger.Location location) {
        this.location = location;
    }

    public jpuppeteer.cdp.client.entity.debugger.Location getLocation() {
        return this.location;
    }

    public void setTargetCallFrames (jpuppeteer.cdp.client.constant.debugger.ContinueToLocationRequestTargetCallFrames targetCallFrames) {
        this.targetCallFrames = targetCallFrames;
    }

    public jpuppeteer.cdp.client.constant.debugger.ContinueToLocationRequestTargetCallFrames getTargetCallFrames() {
        return this.targetCallFrames;
    }

    public ContinueToLocationRequest(jpuppeteer.cdp.client.entity.debugger.Location location, jpuppeteer.cdp.client.constant.debugger.ContinueToLocationRequestTargetCallFrames targetCallFrames) {
        this.location = location;
        this.targetCallFrames = targetCallFrames;
    }

    public ContinueToLocationRequest(jpuppeteer.cdp.client.entity.debugger.Location location) {
        this.location = location;
        this.targetCallFrames = null;
    }

    public ContinueToLocationRequest() {
    }

}