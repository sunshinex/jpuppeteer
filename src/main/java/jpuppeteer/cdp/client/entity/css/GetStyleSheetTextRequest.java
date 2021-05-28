package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class GetStyleSheetTextRequest {

    /**
    */
    public final String styleSheetId;

    public GetStyleSheetTextRequest(String styleSheetId) {
        this.styleSheetId = styleSheetId;
    }

}