package jpuppeteer.cdp.client.entity.target;

/**
*/
public class SetRemoteLocationsRequest {

    /**
    * List of remote locations.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.target.RemoteLocation> locations;

    public void setLocations (java.util.List<jpuppeteer.cdp.client.entity.target.RemoteLocation> locations) {
        this.locations = locations;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.target.RemoteLocation> getLocations() {
        return this.locations;
    }

    public SetRemoteLocationsRequest(java.util.List<jpuppeteer.cdp.client.entity.target.RemoteLocation> locations) {
        this.locations = locations;
    }

    public SetRemoteLocationsRequest() {
    }

}