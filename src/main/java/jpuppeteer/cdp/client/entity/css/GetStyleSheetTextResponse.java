package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class GetStyleSheetTextResponse {

    /**
    * The stylesheet text.
    */
    private String text;

    public void setText (String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public GetStyleSheetTextResponse(String text) {
        this.text = text;
    }

    public GetStyleSheetTextResponse() {
    }

}