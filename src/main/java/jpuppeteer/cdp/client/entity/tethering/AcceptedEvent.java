package jpuppeteer.cdp.client.entity.tethering;

/**
* Informs that port was successfully bound and got a specified connection id.
* experimental
*/
public class AcceptedEvent {

    /**
    * Port number that was successfully bound.
    */
    public final Integer port;

    /**
    * Connection id to be used.
    */
    public final String connectionId;

    public AcceptedEvent(Integer port, String connectionId) {
        this.port = port;
        this.connectionId = connectionId;
    }

}