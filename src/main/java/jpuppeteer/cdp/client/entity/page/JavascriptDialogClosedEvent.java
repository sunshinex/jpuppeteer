package jpuppeteer.cdp.client.entity.page;

/**
* Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) has been closed.
*/
public class JavascriptDialogClosedEvent {

    /**
    * Whether dialog was confirmed.
    */
    public final Boolean result;

    /**
    * User input in case of prompt.
    */
    public final String userInput;

    public JavascriptDialogClosedEvent(Boolean result, String userInput) {
        this.result = result;
        this.userInput = userInput;
    }

}