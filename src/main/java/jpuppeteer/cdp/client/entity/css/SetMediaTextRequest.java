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
    public final jpuppeteer.cdp.client.entity.css.SourceRange range;

    /**
    */
    public final String text;

    public SetMediaTextRequest(String styleSheetId, jpuppeteer.cdp.client.entity.css.SourceRange range, String text) {
        this.styleSheetId = styleSheetId;
        this.range = range;
        this.text = text;
    }

}