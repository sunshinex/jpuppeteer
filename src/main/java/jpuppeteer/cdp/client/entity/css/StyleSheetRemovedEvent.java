package jpuppeteer.cdp.client.entity.css;

/**
* Fired whenever an active document stylesheet is removed.
* experimental
*/
public class StyleSheetRemovedEvent {

    /**
    * Identifier of the removed stylesheet.
    */
    private String styleSheetId;

    public void setStyleSheetId (String styleSheetId) {
        this.styleSheetId = styleSheetId;
    }

    public String getStyleSheetId() {
        return this.styleSheetId;
    }

    public StyleSheetRemovedEvent(String styleSheetId) {
        this.styleSheetId = styleSheetId;
    }

    public StyleSheetRemovedEvent() {
    }

}