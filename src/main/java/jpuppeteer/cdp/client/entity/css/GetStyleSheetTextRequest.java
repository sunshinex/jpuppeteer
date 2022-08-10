package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class GetStyleSheetTextRequest {

    /**
    */
    private String styleSheetId;

    public void setStyleSheetId (String styleSheetId) {
        this.styleSheetId = styleSheetId;
    }

    public String getStyleSheetId() {
        return this.styleSheetId;
    }

    public GetStyleSheetTextRequest(String styleSheetId) {
        this.styleSheetId = styleSheetId;
    }

    public GetStyleSheetTextRequest() {
    }

}