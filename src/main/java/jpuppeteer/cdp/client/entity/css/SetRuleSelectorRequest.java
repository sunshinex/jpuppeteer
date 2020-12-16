package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class SetRuleSelectorRequest {

    /**
    */
    public final String styleSheetId;

    /**
    */
    public final SourceRange range;

    /**
    */
    public final String selector;

    public SetRuleSelectorRequest(String styleSheetId, SourceRange range, String selector) {
        this.styleSheetId = styleSheetId;
        this.range = range;
        this.selector = selector;
    }

}