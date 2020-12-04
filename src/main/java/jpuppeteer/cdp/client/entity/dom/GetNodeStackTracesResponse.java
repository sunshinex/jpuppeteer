package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetNodeStackTracesResponse {

    /**
    * Creation stack trace, if available.
    */
    public final jpuppeteer.cdp.client.entity.runtime.StackTrace creation;

    public GetNodeStackTracesResponse(jpuppeteer.cdp.client.entity.runtime.StackTrace creation) {
        this.creation = creation;
    }

    public GetNodeStackTracesResponse() {
        this.creation = null;
    }

}