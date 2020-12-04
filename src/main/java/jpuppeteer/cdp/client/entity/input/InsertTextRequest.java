package jpuppeteer.cdp.client.entity.input;

/**
*/
public class InsertTextRequest {

    /**
    * The text to insert.
    */
    public final String text;

    public InsertTextRequest(String text) {
        this.text = text;
    }

}