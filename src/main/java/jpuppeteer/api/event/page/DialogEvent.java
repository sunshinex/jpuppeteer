package jpuppeteer.api.event.page;

import jpuppeteer.cdp.client.constant.page.DialogType;
import jpuppeteer.cdp.client.domain.Page;
import jpuppeteer.cdp.client.entity.page.HandleJavaScriptDialogRequest;
import jpuppeteer.util.XFuture;

public class DialogEvent extends PageEvent {

    private final Page page;

    private final String url;

    private final DialogType type;

    private final String message;

    private final String defaultValue;

    private final boolean hasBrowserHandler;

    public DialogEvent(Page page, String url, DialogType type, String message, String defaultValue, boolean hasBrowserHandler) {
        this.page = page;
        this.url = url;
        this.type = type;
        this.message = message;
        this.defaultValue = defaultValue;
        this.hasBrowserHandler = hasBrowserHandler;
    }

    public String url() {
        return url;
    }

    public DialogType type() {
        return type;
    }

    public String message() {
        return message;
    }

    public String defaultValue() {
        return defaultValue;
    }

    public boolean hasBrowserHandler() {
        return hasBrowserHandler;
    }

    private XFuture<?> handle(boolean accept, String value) {
        HandleJavaScriptDialogRequest request = new HandleJavaScriptDialogRequest(accept, value);
        return page.handleJavaScriptDialog(request);
    }

    public XFuture<?> accept(String value) {
        return handle(true, value);
    }

    public XFuture<?> accept() {
        return handle(true, null);
    }

    public XFuture<?> cancel() {
        return handle(false, null);
    }
}
