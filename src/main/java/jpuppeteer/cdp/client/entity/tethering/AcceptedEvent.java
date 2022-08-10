package jpuppeteer.cdp.client.entity.tethering;

/**
* Informs that port was successfully bound and got a specified connection id.
* experimental
*/
public class AcceptedEvent {

    /**
    * Port number that was successfully bound.
    */
    private Integer port;

    /**
    * Connection id to be used.
    */
    private String connectionId;

    public void setPort (Integer port) {
        this.port = port;
    }

    public Integer getPort() {
        return this.port;
    }

    public void setConnectionId (String connectionId) {
        this.connectionId = connectionId;
    }

    public String getConnectionId() {
        return this.connectionId;
    }

    public AcceptedEvent(Integer port, String connectionId) {
        this.port = port;
        this.connectionId = connectionId;
    }

    public AcceptedEvent() {
    }

}