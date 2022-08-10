package jpuppeteer.cdp.client.entity.domdebugger;

/**
*/
public class SetXHRBreakpointRequest {

    /**
    * Resource URL substring. All XHRs having this substring in the URL will get stopped upon.
    */
    private String url;

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public SetXHRBreakpointRequest(String url) {
        this.url = url;
    }

    public SetXHRBreakpointRequest() {
    }

}