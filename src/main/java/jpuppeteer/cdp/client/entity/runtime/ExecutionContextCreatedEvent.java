package jpuppeteer.cdp.client.entity.runtime;

/**
* Issued when new execution context is created.
*/
public class ExecutionContextCreatedEvent {

    /**
    * A newly created execution context.
    */
    public final ExecutionContextDescription context;

    public ExecutionContextCreatedEvent(ExecutionContextDescription context) {
        this.context = context;
    }

}