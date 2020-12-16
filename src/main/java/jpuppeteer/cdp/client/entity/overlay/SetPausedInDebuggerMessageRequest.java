package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetPausedInDebuggerMessageRequest {

    /**
    * The message to display, also triggers resume and step over controls.
    */
    public final String message;

    public SetPausedInDebuggerMessageRequest(String message) {
        this.message = message;
    }

    public SetPausedInDebuggerMessageRequest() {
        this.message = null;
    }

}