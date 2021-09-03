package jpuppeteer.cdp.client.entity.runtime;

/**
* Issued when new execution context is created.
*/
public class ExecutionContextCreatedEvent {

    /**
    * A newly created execution context.
    */
    public final jpuppeteer.cdp.client.entity.runtime.ExecutionContextDescription context;

    public ExecutionContextCreatedEvent(jpuppeteer.cdp.client.entity.runtime.ExecutionContextDescription context) {
        this.context = context;
    }

}