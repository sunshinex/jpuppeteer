package jpuppeteer.cdp.client.entity.target;

/**
*/
public class RemoteLocation {

    /**
    */
    public final String host;

    /**
    */
    public final Integer port;

    public RemoteLocation(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

}