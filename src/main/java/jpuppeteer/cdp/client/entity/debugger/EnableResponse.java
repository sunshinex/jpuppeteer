package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class EnableResponse {

    /**
    * Unique identifier of the debugger.
    */
    private String debuggerId;

    public void setDebuggerId (String debuggerId) {
        this.debuggerId = debuggerId;
    }

    public String getDebuggerId() {
        return this.debuggerId;
    }

    public EnableResponse(String debuggerId) {
        this.debuggerId = debuggerId;
    }

    public EnableResponse() {
    }

}