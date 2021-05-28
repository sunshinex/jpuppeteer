package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class CreateStyleSheetResponse {

    /**
    * Identifier of the created "via-inspector" stylesheet.
    */
    public final String styleSheetId;

    public CreateStyleSheetResponse(String styleSheetId) {
        this.styleSheetId = styleSheetId;
    }

}