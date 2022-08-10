package jpuppeteer.cdp.client.entity.runtime;

/**
* Issued when new execution context is created.
*/
public class ExecutionContextCreatedEvent {

    /**
    * A newly created execution context.
    */
    private jpuppeteer.cdp.client.entity.runtime.ExecutionContextDescription context;

    public void setContext (jpuppeteer.cdp.client.entity.runtime.ExecutionContextDescription context) {
        this.context = context;
    }

    public jpuppeteer.cdp.client.entity.runtime.ExecutionContextDescription getContext() {
        return this.context;
    }

    public ExecutionContextCreatedEvent(jpuppeteer.cdp.client.entity.runtime.ExecutionContextDescription context) {
        this.context = context;
    }

    public ExecutionContextCreatedEvent() {
    }

}