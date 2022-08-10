package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class SetRuleSelectorRequest {

    /**
    */
    private String styleSheetId;

    /**
    */
    private jpuppeteer.cdp.client.entity.css.SourceRange range;

    /**
    */
    private String selector;

    public void setStyleSheetId (String styleSheetId) {
        this.styleSheetId = styleSheetId;
    }

    public String getStyleSheetId() {
        return this.styleSheetId;
    }

    public void setRange (jpuppeteer.cdp.client.entity.css.SourceRange range) {
        this.range = range;
    }

    public jpuppeteer.cdp.client.entity.css.SourceRange getRange() {
        return this.range;
    }

    public void setSelector (String selector) {
        this.selector = selector;
    }

    public String getSelector() {
        return this.selector;
    }

    public SetRuleSelectorRequest(String styleSheetId, jpuppeteer.cdp.client.entity.css.SourceRange range, String selector) {
        this.styleSheetId = styleSheetId;
        this.range = range;
        this.selector = selector;
    }

    public SetRuleSelectorRequest() {
    }

}