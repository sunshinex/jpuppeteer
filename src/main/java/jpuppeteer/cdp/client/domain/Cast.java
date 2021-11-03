package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class Cast {

    private jpuppeteer.cdp.CDPConnection connection;

    public Cast(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Starts observing for sinks that can be used for tab mirroring, and if set, sinks compatible with |presentationUrl| as well. When sinks are found, a |sinksUpdated| event is fired. Also starts observing for issue messages. When an issue is added or removed, an |issueUpdated| event is fired.
    */
    public io.netty.util.concurrent.Future enable(jpuppeteer.cdp.client.entity.cast.EnableRequest request) {
        return connection.send("Cast.enable", request);
    }


    /**
    * Stops observing for sinks and issues.
    */
    public io.netty.util.concurrent.Future disable() {
        return connection.send("Cast.disable", null);
    }


    /**
    * Sets a sink to be used when the web page requests the browser to choose a sink via Presentation API, Remote Playback API, or Cast SDK.
    */
    public io.netty.util.concurrent.Future setSinkToUse(jpuppeteer.cdp.client.entity.cast.SetSinkToUseRequest request) {
        return connection.send("Cast.setSinkToUse", request);
    }


    /**
    * Starts mirroring the tab to the sink.
    */
    public io.netty.util.concurrent.Future startTabMirroring(jpuppeteer.cdp.client.entity.cast.StartTabMirroringRequest request) {
        return connection.send("Cast.startTabMirroring", request);
    }


    /**
    * Stops the active Cast session on the sink.
    */
    public io.netty.util.concurrent.Future stopCasting(jpuppeteer.cdp.client.entity.cast.StopCastingRequest request) {
        return connection.send("Cast.stopCasting", request);
    }

}