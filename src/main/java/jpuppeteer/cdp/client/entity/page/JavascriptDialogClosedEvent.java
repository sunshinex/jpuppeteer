package jpuppeteer.cdp.client.entity.page;

/**
* Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) has been closed.
*/
public class JavascriptDialogClosedEvent {

    /**
    * Whether dialog was confirmed.
    */
    private Boolean result;

    /**
    * User input in case of prompt.
    */
    private String userInput;

    public void setResult (Boolean result) {
        this.result = result;
    }

    public Boolean getResult() {
        return this.result;
    }

    public void setUserInput (String userInput) {
        this.userInput = userInput;
    }

    public String getUserInput() {
        return this.userInput;
    }

    public JavascriptDialogClosedEvent(Boolean result, String userInput) {
        this.result = result;
        this.userInput = userInput;
    }

    public JavascriptDialogClosedEvent() {
    }

}