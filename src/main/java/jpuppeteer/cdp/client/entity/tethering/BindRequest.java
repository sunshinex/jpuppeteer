package jpuppeteer.cdp.client.entity.tethering;

/**
* experimental
*/
public class BindRequest {

    /**
    * Port number to bind.
    */
    public final Integer port;

    public BindRequest(Integer port) {
        this.port = port;
    }

}