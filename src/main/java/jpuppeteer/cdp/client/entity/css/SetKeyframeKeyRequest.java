package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class SetKeyframeKeyRequest {

    /**
    */
    public final String styleSheetId;

    /**
    */
    public final SourceRange range;

    /**
    */
    public final String keyText;

    public SetKeyframeKeyRequest(String styleSheetId, SourceRange range, String keyText) {
        this.styleSheetId = styleSheetId;
        this.range = range;
        this.keyText = keyText;
    }

}