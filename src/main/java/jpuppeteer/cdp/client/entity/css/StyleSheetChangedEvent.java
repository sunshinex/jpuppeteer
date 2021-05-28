package jpuppeteer.cdp.client.entity.css;

/**
* Fired whenever a stylesheet is changed as a result of the client operation.
* experimental
*/
public class StyleSheetChangedEvent {

    /**
    */
    public final String styleSheetId;

    public StyleSheetChangedEvent(String styleSheetId) {
        this.styleSheetId = styleSheetId;
    }

}