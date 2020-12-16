package jpuppeteer.cdp.client.entity.io;

/**
*/
public class CloseRequest {

    /**
    * Handle of the stream to close.
    */
    public final String handle;

    public CloseRequest(String handle) {
        this.handle = handle;
    }

}