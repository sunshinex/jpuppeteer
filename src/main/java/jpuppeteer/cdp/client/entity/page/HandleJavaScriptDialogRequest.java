package jpuppeteer.cdp.client.entity.page;

/**
*/
public class HandleJavaScriptDialogRequest {

    /**
    * Whether to accept or dismiss the dialog.
    */
    private Boolean accept;

    /**
    * The text to enter into the dialog prompt before accepting. Used only if this is a prompt dialog.
    */
    private String promptText;

    public void setAccept (Boolean accept) {
        this.accept = accept;
    }

    public Boolean getAccept() {
        return this.accept;
    }

    public void setPromptText (String promptText) {
        this.promptText = promptText;
    }

    public String getPromptText() {
        return this.promptText;
    }

    public HandleJavaScriptDialogRequest(Boolean accept, String promptText) {
        this.accept = accept;
        this.promptText = promptText;
    }

    public HandleJavaScriptDialogRequest(Boolean accept) {
        this.accept = accept;
        this.promptText = null;
    }

    public HandleJavaScriptDialogRequest() {
    }

}