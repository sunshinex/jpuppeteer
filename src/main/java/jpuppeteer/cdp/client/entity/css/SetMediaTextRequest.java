package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class SetMediaTextRequest {

    /**
    */
    private String styleSheetId;

    /**
    */
    private jpuppeteer.cdp.client.entity.css.SourceRange range;

    /**
    */
    private String text;

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

    public void setText (String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public SetMediaTextRequest(String styleSheetId, jpuppeteer.cdp.client.entity.css.SourceRange range, String text) {
        this.styleSheetId = styleSheetId;
        this.range = range;
        this.text = text;
    }

    public SetMediaTextRequest() {
    }

}