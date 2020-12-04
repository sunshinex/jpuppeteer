package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class SetStyleSheetTextRequest {

    /**
    */
    public final String styleSheetId;

    /**
    */
    public final String text;

    public SetStyleSheetTextRequest(String styleSheetId, String text) {
        this.styleSheetId = styleSheetId;
        this.text = text;
    }

}