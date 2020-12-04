package jpuppeteer.util;

import jpuppeteer.cdp.client.entity.runtime.StackTrace;

public class ExecutionException extends RuntimeException {

    private final StackTrace stackTrace;

    public ExecutionException(String message, StackTrace stackTrace) {
        super(message);
        this.stackTrace = stackTrace;
    }

    public StackTrace stackTrace() {
        return stackTrace;
    }
}
