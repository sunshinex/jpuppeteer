package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class EnableResponse {

    /**
    * Unique identifier of the debugger.
    */
    public final String debuggerId;

    public EnableResponse(String debuggerId) {
        this.debuggerId = debuggerId;
    }

}