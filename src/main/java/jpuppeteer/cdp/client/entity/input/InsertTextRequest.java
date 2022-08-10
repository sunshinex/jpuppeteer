package jpuppeteer.cdp.client.entity.input;

/**
*/
public class InsertTextRequest {

    /**
    * The text to insert.
    */
    private String text;

    public void setText (String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public InsertTextRequest(String text) {
        this.text = text;
    }

    public InsertTextRequest() {
    }

}