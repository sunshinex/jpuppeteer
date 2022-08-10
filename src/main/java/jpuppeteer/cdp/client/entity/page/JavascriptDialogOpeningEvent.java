package jpuppeteer.cdp.client.entity.page;

/**
* Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) is about to open.
*/
public class JavascriptDialogOpeningEvent {

    /**
    * Frame url.
    */
    private String url;

    /**
    * Message that will be displayed by the dialog.
    */
    private String message;

    /**
    * Dialog type.
    */
    private jpuppeteer.cdp.client.constant.page.DialogType type;

    /**
    * True iff browser is capable showing or acting on the given dialog. When browser has no dialog handler for given target, calling alert while Page domain is engaged will stall the page execution. Execution can be resumed via calling Page.handleJavaScriptDialog.
    */
    private Boolean hasBrowserHandler;

    /**
    * Default dialog prompt.
    */
    private String defaultPrompt;

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setMessage (String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setType (jpuppeteer.cdp.client.constant.page.DialogType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.page.DialogType getType() {
        return this.type;
    }

    public void setHasBrowserHandler (Boolean hasBrowserHandler) {
        this.hasBrowserHandler = hasBrowserHandler;
    }

    public Boolean getHasBrowserHandler() {
        return this.hasBrowserHandler;
    }

    public void setDefaultPrompt (String defaultPrompt) {
        this.defaultPrompt = defaultPrompt;
    }

    public String getDefaultPrompt() {
        return this.defaultPrompt;
    }

    public JavascriptDialogOpeningEvent(String url, String message, jpuppeteer.cdp.client.constant.page.DialogType type, Boolean hasBrowserHandler, String defaultPrompt) {
        this.url = url;
        this.message = message;
        this.type = type;
        this.hasBrowserHandler = hasBrowserHandler;
        this.defaultPrompt = defaultPrompt;
    }

    public JavascriptDialogOpeningEvent(String url, String message, jpuppeteer.cdp.client.constant.page.DialogType type, Boolean hasBrowserHandler) {
        this.url = url;
        this.message = message;
        this.type = type;
        this.hasBrowserHandler = hasBrowserHandler;
        this.defaultPrompt = null;
    }

    public JavascriptDialogOpeningEvent() {
    }

}