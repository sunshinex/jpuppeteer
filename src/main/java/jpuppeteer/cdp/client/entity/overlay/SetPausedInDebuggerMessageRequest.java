package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetPausedInDebuggerMessageRequest {

    /**
    * The message to display, also triggers resume and step over controls.
    */
    private String message;

    public void setMessage (String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public SetPausedInDebuggerMessageRequest(String message) {
        this.message = message;
    }

    public SetPausedInDebuggerMessageRequest() {
        this.message = null;
    }

}