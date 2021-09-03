package jpuppeteer.cdp.client.entity.runtime;

/**
* Issued when console API was called.
*/
public class ConsoleAPICalledEvent {

    /**
    * Type of the call.
    */
    public final jpuppeteer.cdp.client.constant.runtime.ConsoleAPICalledEventType type;

    /**
    * Call arguments.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.runtime.RemoteObject> args;

    /**
    * Identifier of the context where the call was made.
    */
    public final Integer executionContextId;

    /**
    * Call timestamp.
    */
    public final java.math.BigDecimal timestamp;

    /**
    * Stack trace captured when the call was made. The async stack chain is automatically reported for the following call types: `assert`, `error`, `trace`, `warning`. For other types the async call chain can be retrieved using `Debugger.getStackTrace` and `stackTrace.parentId` field.
    */
    public final jpuppeteer.cdp.client.entity.runtime.StackTrace stackTrace;

    /**
    * Console context descriptor for calls on non-default console context (not console.*): 'anonymous#unique-logger-id' for call on unnamed context, 'name#unique-logger-id' for call on named context.
    */
    public final String context;

    public ConsoleAPICalledEvent(jpuppeteer.cdp.client.constant.runtime.ConsoleAPICalledEventType type, java.util.List<jpuppeteer.cdp.client.entity.runtime.RemoteObject> args, Integer executionContextId, java.math.BigDecimal timestamp, jpuppeteer.cdp.client.entity.runtime.StackTrace stackTrace, String context) {
        this.type = type;
        this.args = args;
        this.executionContextId = executionContextId;
        this.timestamp = timestamp;
        this.stackTrace = stackTrace;
        this.context = context;
    }

    public ConsoleAPICalledEvent(jpuppeteer.cdp.client.constant.runtime.ConsoleAPICalledEventType type, java.util.List<jpuppeteer.cdp.client.entity.runtime.RemoteObject> args, Integer executionContextId, java.math.BigDecimal timestamp) {
        this.type = type;
        this.args = args;
        this.executionContextId = executionContextId;
        this.timestamp = timestamp;
        this.stackTrace = null;
        this.context = null;
    }

}