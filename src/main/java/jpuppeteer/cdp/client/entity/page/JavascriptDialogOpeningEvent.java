package jpuppeteer.cdp.client.entity.page;

/**
* Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) is about to open.
*/
public class JavascriptDialogOpeningEvent {

    /**
    * Frame url.
    */
    public final String url;

    /**
    * Message that will be displayed by the dialog.
    */
    public final String message;

    /**
    * Dialog type.
    */
    public final jpuppeteer.cdp.client.constant.page.DialogType type;

    /**
    * True iff browser is capable showing or acting on the given dialog. When browser has no dialog handler for given target, calling alert while Page domain is engaged will stall the page execution. Execution can be resumed via calling Page.handleJavaScriptDialog.
    */
    public final Boolean hasBrowserHandler;

    /**
    * Default dialog prompt.
    */
    public final String defaultPrompt;

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

}