package jpuppeteer.cdp.cdp.domain;

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
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.headlessexperimental.BeginFrameResponse beginFrame(jpuppeteer.cdp.cdp.entity.headlessexperimental.BeginFrameRequest request, int timeout) throws Exception {
        return session.send("HeadlessExperimental.beginFrame", request, jpuppeteer.cdp.cdp.entity.headlessexperimental.BeginFrameResponse.class, timeout);
    }


    /**
    * Disables headless events for the target.
    * experimental
    */
    public void disable(int timeout) throws Exception {
        session.send("HeadlessExperimental.disable", null, timeout);
    }


    /**
    * Enables headless events for the target.
    * experimental
    */
    public void enable(int timeout) throws Exception {
        session.send("HeadlessExperimental.enable", null, timeout);
    }

}