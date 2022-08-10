package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class SetKeyframeKeyRequest {

    /**
    */
    private String styleSheetId;

    /**
    */
    private jpuppeteer.cdp.client.entity.css.SourceRange range;

    /**
    */
    private String keyText;

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

    public void setKeyText (String keyText) {
        this.keyText = keyText;
    }

    public String getKeyText() {
        return this.keyText;
    }

    public SetKeyframeKeyRequest(String styleSheetId, jpuppeteer.cdp.client.entity.css.SourceRange range, String keyText) {
        this.styleSheetId = styleSheetId;
        this.range = range;
        this.keyText = keyText;
    }

    public SetKeyframeKeyRequest() {
    }

}