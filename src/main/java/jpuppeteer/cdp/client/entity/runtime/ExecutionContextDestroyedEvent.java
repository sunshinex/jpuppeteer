package jpuppeteer.cdp.client.entity.runtime;

/**
* Issued when execution context is destroyed.
*/
public class ExecutionContextDestroyedEvent {

    /**
    * Id of the destroyed context
    */
    public final Integer executionContextId;

    public ExecutionContextDestroyedEvent(Integer executionContextId) {
        this.executionContextId = executionContextId;
    }

}