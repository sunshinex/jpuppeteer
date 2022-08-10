package jpuppeteer.cdp.client.entity.io;

/**
*/
public class ReadResponse {

    /**
    * Set if the data is base64-encoded
    */
    private Boolean base64Encoded;

    /**
    * Data that were read.
    */
    private String data;

    /**
    * Set if the end-of-file condition occurred while reading.
    */
    private Boolean eof;

    public void setBase64Encoded (Boolean base64Encoded) {
        this.base64Encoded = base64Encoded;
    }

    public Boolean getBase64Encoded() {
        return this.base64Encoded;
    }

    public void setData (String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    public void setEof (Boolean eof) {
        this.eof = eof;
    }

    public Boolean getEof() {
        return this.eof;
    }

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

    public ReadResponse() {
    }

}