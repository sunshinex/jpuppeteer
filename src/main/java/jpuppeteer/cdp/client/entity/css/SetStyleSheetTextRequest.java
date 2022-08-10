package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class SetStyleSheetTextRequest {

    /**
    */
    private String styleSheetId;

    /**
    */
    private String text;

    public void setStyleSheetId (String styleSheetId) {
        this.styleSheetId = styleSheetId;
    }

    public String getStyleSheetId() {
        return this.styleSheetId;
    }

    public void setText (String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public SetStyleSheetTextRequest(String styleSheetId, String text) {
        this.styleSheetId = styleSheetId;
        this.text = text;
    }

    public SetStyleSheetTextRequest() {
    }

}