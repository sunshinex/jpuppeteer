package jpuppeteer.cdp.cdp.entity.target;

/**
*/
@lombok.Setter
@lombok.Getter
@lombok.ToString
public class SetRemoteLocationsRequest {

    /**
    * List of remote locations.
    */
    private java.util.List<jpuppeteer.cdp.cdp.entity.target.RemoteLocation> locations;



}