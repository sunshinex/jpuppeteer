package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class CreateStyleSheetResponse {

    /**
    * Identifier of the created "via-inspector" stylesheet.
    */
    private String styleSheetId;

    public void setStyleSheetId (String styleSheetId) {
        this.styleSheetId = styleSheetId;
    }

    public String getStyleSheetId() {
        return this.styleSheetId;
    }

    public CreateStyleSheetResponse(String styleSheetId) {
        this.styleSheetId = styleSheetId;
    }

    public CreateStyleSheetResponse() {
    }

}