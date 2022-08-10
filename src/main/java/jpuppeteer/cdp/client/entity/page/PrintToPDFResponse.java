package jpuppeteer.cdp.client.entity.page;

/**
*/
public class PrintToPDFResponse {

    /**
    * Base64-encoded pdf data. Empty if |returnAsStream| is specified. (Encoded as a base64 string when passed over JSON)
    */
    private String data;

    /**
    * A handle of the stream that holds resulting PDF data.
    */
    private String stream;

    public void setData (String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    public void setStream (String stream) {
        this.stream = stream;
    }

    public String getStream() {
        return this.stream;
    }

    public PrintToPDFResponse(String data, String stream) {
        this.data = data;
        this.stream = stream;
    }

    public PrintToPDFResponse(String data) {
        this.data = data;
        this.stream = null;
    }

    public PrintToPDFResponse() {
    }

}