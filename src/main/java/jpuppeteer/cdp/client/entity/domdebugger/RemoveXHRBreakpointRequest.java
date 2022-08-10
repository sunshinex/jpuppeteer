package jpuppeteer.cdp.client.entity.domdebugger;

/**
*/
public class RemoveXHRBreakpointRequest {

    /**
    * Resource URL substring.
    */
    private String url;

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public RemoveXHRBreakpointRequest(String url) {
        this.url = url;
    }

    public RemoveXHRBreakpointRequest() {
    }

}