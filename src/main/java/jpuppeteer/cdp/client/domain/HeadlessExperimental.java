package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class HeadlessExperimental {

    private jpuppeteer.cdp.CDPConnection connection;

    public HeadlessExperimental(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Sends a BeginFrame to the target and returns when the frame was completed. Optionally captures a screenshot from the resulting frame. Requires that the target was created with enabled BeginFrameControl. Designed for use with --run-all-compositor-stages-before-draw, see also https://goo.gl/3zHXhB for more background.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.headlessexperimental.BeginFrameResponse> beginFrame(jpuppeteer.cdp.client.entity.headlessexperimental.BeginFrameRequest request) {
        return connection.send("HeadlessExperimental.beginFrame", request, jpuppeteer.cdp.client.entity.headlessexperimental.BeginFrameResponse.class);
    }


    /**
    * Disables headless events for the target.
    */
    public jpuppeteer.util.XFuture<?> disable() {
        return connection.send("HeadlessExperimental.disable", null);
    }


    /**
    * Enables headless events for the target.
    */
    public jpuppeteer.util.XFuture<?> enable() {
        return connection.send("HeadlessExperimental.enable", null);
    }

}