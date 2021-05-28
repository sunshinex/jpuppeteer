package jpuppeteer.cdp.client.entity.domdebugger;

/**
*/
public class RemoveXHRBreakpointRequest {

    /**
    * Resource URL substring.
    */
    public final String url;

    public RemoveXHRBreakpointRequest(String url) {
        this.url = url;
    }

}