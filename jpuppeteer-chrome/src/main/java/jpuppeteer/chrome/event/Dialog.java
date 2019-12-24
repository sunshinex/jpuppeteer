package jpuppeteer.chrome.event;

import jpuppeteer.cdp.cdp.domain.Page;
import jpuppeteer.cdp.cdp.entity.page.HandleJavaScriptDialogRequest;

import static jpuppeteer.chrome.ChromeBrowser.DEFAULT_TIMEOUT;

public class Dialog {

    private final Page page;

    private final String type;

    private final String message;

    private final String defaultValue;

    public Dialog(Page page, String type, String message, String defaultValue) {
        this.page = page;
        this.type = type;
        this.message = message;
        this.defaultValue = defaultValue;
    }

    public String type() {
        return type;
    }

    public String message() {
        return message;
    }

    public String defaultValue() {
        return defaultValue;
    }

    private void handle(boolean accept, String value) throws Exception {
        HandleJavaScriptDialogRequest request = new HandleJavaScriptDialogRequest();
        request.setAccept(accept);
        request.setPromptText(value);
        page.handleJavaScriptDialog(request, DEFAULT_TIMEOUT);
    }

    public void accept(String value) throws Exception {
        handle(true, value);
    }

    public void accept() throws Exception {
        handle(true, null);
    }

    public void cancel() throws Exception {
        handle(false, null);
    }
}
