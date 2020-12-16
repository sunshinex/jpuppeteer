package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class CollectClassNamesRequest {

    /**
    */
    public final String styleSheetId;

    public CollectClassNamesRequest(String styleSheetId) {
        this.styleSheetId = styleSheetId;
    }

}