package jpuppeteer.cdp.client.entity.css;

/**
* Fired whenever a stylesheet is changed as a result of the client operation.
* experimental
*/
public class StyleSheetChangedEvent {

    /**
    */
    private String styleSheetId;

    public void setStyleSheetId (String styleSheetId) {
        this.styleSheetId = styleSheetId;
    }

    public String getStyleSheetId() {
        return this.styleSheetId;
    }

    public StyleSheetChangedEvent(String styleSheetId) {
        this.styleSheetId = styleSheetId;
    }

    public StyleSheetChangedEvent() {
    }

}