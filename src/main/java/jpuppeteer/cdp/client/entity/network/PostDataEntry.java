package jpuppeteer.cdp.client.entity.network;

/**
* Post data entry for HTTP request
*/
public class PostDataEntry {

    /**
    */
    private String bytes;

    public void setBytes (String bytes) {
        this.bytes = bytes;
    }

    public String getBytes() {
        return this.bytes;
    }

    public PostDataEntry(String bytes) {
        this.bytes = bytes;
    }

    public PostDataEntry() {
        this.bytes = null;
    }

}