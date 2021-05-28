package jpuppeteer.cdp.client.entity.network;

/**
* Post data entry for HTTP request
*/
public class PostDataEntry {

    /**
    */
    public final String bytes;

    public PostDataEntry(String bytes) {
        this.bytes = bytes;
    }

    public PostDataEntry() {
        this.bytes = null;
    }

}