package jpuppeteer.cdp.client.entity.target;

/**
*/
public class SetRemoteLocationsRequest {

    /**
    * List of remote locations.
    */
    public final java.util.List<RemoteLocation> locations;

    public SetRemoteLocationsRequest(java.util.List<RemoteLocation> locations) {
        this.locations = locations;
    }

}