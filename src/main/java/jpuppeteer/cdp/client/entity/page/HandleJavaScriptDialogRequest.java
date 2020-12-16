package jpuppeteer.cdp.client.entity.page;

/**
*/
public class HandleJavaScriptDialogRequest {

    /**
    * Whether to accept or dismiss the dialog.
    */
    public final Boolean accept;

    /**
    * The text to enter into the dialog prompt before accepting. Used only if this is a prompt dialog.
    */
    public final String promptText;

    public HandleJavaScriptDialogRequest(Boolean accept, String promptText) {
        this.accept = accept;
        this.promptText = promptText;
    }

    public HandleJavaScriptDialogRequest(Boolean accept) {
        this.accept = accept;
        this.promptText = null;
    }

}