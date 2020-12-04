package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class CollectClassNamesResponse {

    /**
    * Class name list.
    */
    public final java.util.List<String> classNames;

    public CollectClassNamesResponse(java.util.List<String> classNames) {
        this.classNames = classNames;
    }

}