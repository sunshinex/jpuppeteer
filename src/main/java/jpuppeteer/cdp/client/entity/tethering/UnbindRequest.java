package jpuppeteer.cdp.client.entity.tethering;

/**
* experimental
*/
public class UnbindRequest {

    /**
    * Port number to unbind.
    */
    private Integer port;

    public void setPort (Integer port) {
        this.port = port;
    }

    public Integer getPort() {
        return this.port;
    }

    public UnbindRequest(Integer port) {
        this.port = port;
    }

    public UnbindRequest() {
    }

}