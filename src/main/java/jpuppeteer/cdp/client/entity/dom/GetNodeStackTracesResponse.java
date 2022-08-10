package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetNodeStackTracesResponse {

    /**
    * Creation stack trace, if available.
    */
    private jpuppeteer.cdp.client.entity.runtime.StackTrace creation;

    public void setCreation (jpuppeteer.cdp.client.entity.runtime.StackTrace creation) {
        this.creation = creation;
    }

    public jpuppeteer.cdp.client.entity.runtime.StackTrace getCreation() {
        return this.creation;
    }

    public GetNodeStackTracesResponse(jpuppeteer.cdp.client.entity.runtime.StackTrace creation) {
        this.creation = creation;
    }

    public GetNodeStackTracesResponse() {
        this.creation = null;
    }

}