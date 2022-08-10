package jpuppeteer.cdp.client.entity.runtime;

/**
* Issued when console API was called.
*/
public class ConsoleAPICalledEvent {

    /**
    * Type of the call.
    */
    private jpuppeteer.cdp.client.constant.runtime.ConsoleAPICalledEventType type;

    /**
    * Call arguments.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.runtime.RemoteObject> args;

    /**
    * Identifier of the context where the call was made.
    */
    private Integer executionContextId;

    /**
    * Call timestamp.
    */
    private java.math.BigDecimal timestamp;

    /**
    * Stack trace captured when the call was made. The async stack chain is automatically reported for the following call types: `assert`, `error`, `trace`, `warning`. For other types the async call chain can be retrieved using `Debugger.getStackTrace` and `stackTrace.parentId` field.
    */
    private jpuppeteer.cdp.client.entity.runtime.StackTrace stackTrace;

    /**
    * Console context descriptor for calls on non-default console context (not console.*): 'anonymous#unique-logger-id' for call on unnamed context, 'name#unique-logger-id' for call on named context.
    */
    private String context;

    public void setType (jpuppeteer.cdp.client.constant.runtime.ConsoleAPICalledEventType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.runtime.ConsoleAPICalledEventType getType() {
        return this.type;
    }

    public void setArgs (java.util.List<jpuppeteer.cdp.client.entity.runtime.RemoteObject> args) {
        this.args = args;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.runtime.RemoteObject> getArgs() {
        return this.args;
    }

    public void setExecutionContextId (Integer executionContextId) {
        this.executionContextId = executionContextId;
    }

    public Integer getExecutionContextId() {
        return this.executionContextId;
    }

    public void setTimestamp (java.math.BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public java.math.BigDecimal getTimestamp() {
        return this.timestamp;
    }

    public void setStackTrace (jpuppeteer.cdp.client.entity.runtime.StackTrace stackTrace) {
        this.stackTrace = stackTrace;
    }

    public jpuppeteer.cdp.client.entity.runtime.StackTrace getStackTrace() {
        return this.stackTrace;
    }

    public void setContext (String context) {
        this.context = context;
    }

    public String getContext() {
        return this.context;
    }

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

    public ConsoleAPICalledEvent() {
    }

}