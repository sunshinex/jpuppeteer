package jpuppeteer.api.event.page;

import jpuppeteer.api.event.PageEvent;
import jpuppeteer.cdp.client.entity.runtime.ExceptionDetails;

public class ErrorEvent extends PageEvent {

    private final ExceptionDetails exception;

    public ErrorEvent(ExceptionDetails exception) {
        this.exception = exception;
    }

    public ExceptionDetails exception() {
        return exception;
    }
}
