package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class GetStyleSheetTextResponse {

    /**
    * The stylesheet text.
    */
    public final String text;

    public GetStyleSheetTextResponse(String text) {
        this.text = text;
    }

}