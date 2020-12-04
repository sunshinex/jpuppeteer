package jpuppeteer.cdp.client.entity.tethering;

/**
* experimental
*/
public class UnbindRequest {

    /**
    * Port number to unbind.
    */
    public final Integer port;

    public UnbindRequest(Integer port) {
        this.port = port;
    }

}