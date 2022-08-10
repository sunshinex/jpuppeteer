package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class SetStyleSheetTextResponse {

    /**
    * URL of source map associated with script (if any).
    */
    private String sourceMapURL;

    public void setSourceMapURL (String sourceMapURL) {
        this.sourceMapURL = sourceMapURL;
    }

    public String getSourceMapURL() {
        return this.sourceMapURL;
    }

    public SetStyleSheetTextResponse(String sourceMapURL) {
        this.sourceMapURL = sourceMapURL;
    }

    public SetStyleSheetTextResponse() {
        this.sourceMapURL = null;
    }

}