package jpuppeteer.cdp.client.entity.io;

/**
*/
public class ReadResponse {

    /**
    * Set if the data is base64-encoded
    */
    public final Boolean base64Encoded;

    /**
    * Data that were read.
    */
    public final String data;

    /**
    * Set if the end-of-file condition occurred while reading.
    */
    public final Boolean eof;

    public ReadResponse(Boolean base64Encoded, String data, Boolean eof) {
        this.base64Encoded = base64Encoded;
        this.data = data;
        this.eof = eof;
    }

    public ReadResponse(String data, Boolean eof) {
        this.base64Encoded = null;
        this.data = data;
        this.eof = eof;
    }

}