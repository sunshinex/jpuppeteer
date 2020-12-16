package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class SetMediaTextRequest {

    /**
    */
    public final String styleSheetId;

    /**
    */
    public final SourceRange range;

    /**
    */
    public final String text;

    public SetMediaTextRequest(String styleSheetId, SourceRange range, String text) {
        this.styleSheetId = styleSheetId;
        this.range = range;
        this.text = text;
    }

}