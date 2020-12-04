package jpuppeteer.cdp.client.entity.page;

/**
*/
public class PrintToPDFResponse {

    /**
    * Base64-encoded pdf data. Empty if |returnAsStream| is specified.
    */
    public final String data;

    /**
    * A handle of the stream that holds resulting PDF data.
    */
    public final String stream;

    public PrintToPDFResponse(String data, String stream) {
        this.data = data;
        this.stream = stream;
    }

    public PrintToPDFResponse(String data) {
        this.data = data;
        this.stream = null;
    }

}