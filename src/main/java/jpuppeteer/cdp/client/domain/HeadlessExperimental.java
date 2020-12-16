package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class HeadlessExperimental {

    private jpuppeteer.cdp.CDPSession session;

    public HeadlessExperimental(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Sends a BeginFrame to the target and returns when the frame was completed. Optionally captures a screenshot from the resulting frame. Requires that the target was created with enabled BeginFrameControl. Designed for use with --run-all-compositor-stages-before-draw, see also https://goo.gl/3zHXhB for more background.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.headlessexperimental.BeginFrameResponse> beginFrame(jpuppeteer.cdp.client.entity.headlessexperimental.BeginFrameRequest request) {
        return session.send("HeadlessExperimental.beginFrame", request, jpuppeteer.cdp.client.entity.headlessexperimental.BeginFrameResponse.class);
    }


    /**
    * Disables headless events for the target.
    */
    public io.netty.util.concurrent.Future disable() {
        return session.send("HeadlessExperimental.disable", null);
    }


    /**
    * Enables headless events for the target.
    */
    public io.netty.util.concurrent.Future enable() {
        return session.send("HeadlessExperimental.enable", null);
    }

}