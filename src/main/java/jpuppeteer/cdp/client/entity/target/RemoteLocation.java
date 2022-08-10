package jpuppeteer.cdp.client.entity.target;

/**
*/
public class RemoteLocation {

    /**
    */
    private String host;

    /**
    */
    private Integer port;

    public void setHost (String host) {
        this.host = host;
    }

    public String getHost() {
        return this.host;
    }

    public void setPort (Integer port) {
        this.port = port;
    }

    public Integer getPort() {
        return this.port;
    }

    public RemoteLocation(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    public RemoteLocation() {
    }

}