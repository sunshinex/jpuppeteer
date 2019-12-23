package jpuppeteer.cdp.cdp.domain;

/**
* experimental
*/
public class Cast {

    private jpuppeteer.cdp.CDPSession session;

    public Cast(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Starts observing for sinks that can be used for tab mirroring, and if set, sinks compatible with |presentationUrl| as well. When sinks are found, a |sinksUpdated| event is fired. Also starts observing for issue messages. When an issue is added or removed, an |issueUpdated| event is fired.
    * experimental
    */
    public void enable(jpuppeteer.cdp.cdp.entity.cast.EnableRequest request, int timeout) throws Exception {
        session.send("Cast.enable", request, timeout);
    }


    /**
    * Stops observing for sinks and issues.
    * experimental
    */
    public void disable(int timeout) throws Exception {
        session.send("Cast.disable", null, timeout);
    }


    /**
    * Sets a sink to be used when the web page requests the browser to choose a sink via Presentation API, Remote Playback API, or Cast SDK.
    * experimental
    */
    public void setSinkToUse(jpuppeteer.cdp.cdp.entity.cast.SetSinkToUseRequest request, int timeout) throws Exception {
        session.send("Cast.setSinkToUse", request, timeout);
    }


    /**
    * Starts mirroring the tab to the sink.
    * experimental
    */
    public void startTabMirroring(jpuppeteer.cdp.cdp.entity.cast.StartTabMirroringRequest request, int timeout) throws Exception {
        session.send("Cast.startTabMirroring", request, timeout);
    }


    /**
    * Stops the active Cast session on the sink.
    * experimental
    */
    public void stopCasting(jpuppeteer.cdp.cdp.entity.cast.StopCastingRequest request, int timeout) throws Exception {
        session.send("Cast.stopCasting", request, timeout);
    }

}