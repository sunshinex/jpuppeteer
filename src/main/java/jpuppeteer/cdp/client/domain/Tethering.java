package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class Tethering {

    private jpuppeteer.cdp.CDPConnection connection;

    public Tethering(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Request browser port binding.
    */
    public jpuppeteer.util.XFuture<?> bind(jpuppeteer.cdp.client.entity.tethering.BindRequest request) {
        return connection.send("Tethering.bind", request);
    }


    /**
    * Request browser port unbinding.
    */
    public jpuppeteer.util.XFuture<?> unbind(jpuppeteer.cdp.client.entity.tethering.UnbindRequest request) {
        return connection.send("Tethering.unbind", request);
    }

}