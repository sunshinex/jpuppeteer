package jpuppeteer.cdp.client.entity.tethering;

/**
* experimental
*/
public class BindRequest {

    /**
    * Port number to bind.
    */
    private Integer port;

    public void setPort (Integer port) {
        this.port = port;
    }

    public Integer getPort() {
        return this.port;
    }

    public BindRequest(Integer port) {
        this.port = port;
    }

    public BindRequest() {
    }

}