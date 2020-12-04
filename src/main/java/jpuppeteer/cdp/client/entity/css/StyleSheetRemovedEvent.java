package jpuppeteer.cdp.client.entity.css;

/**
* Fired whenever an active document stylesheet is removed.
* experimental
*/
public class StyleSheetRemovedEvent {

    /**
    * Identifier of the removed stylesheet.
    */
    public final String styleSheetId;

    public StyleSheetRemovedEvent(String styleSheetId) {
        this.styleSheetId = styleSheetId;
    }

}