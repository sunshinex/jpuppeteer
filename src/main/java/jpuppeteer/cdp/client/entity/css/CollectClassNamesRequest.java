package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class CollectClassNamesRequest {

    /**
    */
    private String styleSheetId;

    public void setStyleSheetId (String styleSheetId) {
        this.styleSheetId = styleSheetId;
    }

    public String getStyleSheetId() {
        return this.styleSheetId;
    }

    public CollectClassNamesRequest(String styleSheetId) {
        this.styleSheetId = styleSheetId;
    }

    public CollectClassNamesRequest() {
    }

}