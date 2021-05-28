package jpuppeteer.cdp.client.entity.domdebugger;

/**
*/
public class SetXHRBreakpointRequest {

    /**
    * Resource URL substring. All XHRs having this substring in the URL will get stopped upon.
    */
    public final String url;

    public SetXHRBreakpointRequest(String url) {
        this.url = url;
    }

}