package jpuppeteer.cdp.cdp.domain;

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
    * experimental
    */
    public void bind(jpuppeteer.cdp.cdp.entity.tethering.BindRequest request, int timeout) throws Exception {
        session.send("Tethering.bind", request, timeout);
    }


    /**
    * Request browser port unbinding.
    * experimental
    */
    public void unbind(jpuppeteer.cdp.cdp.entity.tethering.UnbindRequest request, int timeout) throws Exception {
        session.send("Tethering.unbind", request, timeout);
    }

}