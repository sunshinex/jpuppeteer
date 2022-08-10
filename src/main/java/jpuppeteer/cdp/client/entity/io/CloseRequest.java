package jpuppeteer.cdp.client.entity.io;

/**
*/
public class CloseRequest {

    /**
    * Handle of the stream to close.
    */
    private String handle;

    public void setHandle (String handle) {
        this.handle = handle;
    }

    public String getHandle() {
        return this.handle;
    }

    public CloseRequest(String handle) {
        this.handle = handle;
    }

    public CloseRequest() {
    }

}