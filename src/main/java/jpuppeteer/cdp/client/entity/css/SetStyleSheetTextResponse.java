package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class SetStyleSheetTextResponse {

    /**
    * URL of source map associated with script (if any).
    */
    public final String sourceMapURL;

    public SetStyleSheetTextResponse(String sourceMapURL) {
        this.sourceMapURL = sourceMapURL;
    }

    public SetStyleSheetTextResponse() {
        this.sourceMapURL = null;
    }

}