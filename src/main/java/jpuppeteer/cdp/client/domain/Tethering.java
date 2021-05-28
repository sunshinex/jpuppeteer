package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class Tethering {

    private jpuppeteer.cdp.CDPSession session;

    public Tethering(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Request browser port binding.
    */
    public io.netty.util.concurrent.Future bind(jpuppeteer.cdp.client.entity.tethering.BindRequest request) {
        return session.send("Tethering.bind", request);
    }


    /**
    * Request browser port unbinding.
    */
    public io.netty.util.concurrent.Future unbind(jpuppeteer.cdp.client.entity.tethering.UnbindRequest request) {
        return session.send("Tethering.unbind", request);
    }

}