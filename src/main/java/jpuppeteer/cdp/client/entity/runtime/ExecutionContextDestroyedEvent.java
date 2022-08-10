package jpuppeteer.cdp.client.entity.runtime;

/**
* Issued when execution context is destroyed.
*/
public class ExecutionContextDestroyedEvent {

    /**
    * Id of the destroyed context
    */
    private Integer executionContextId;

    public void setExecutionContextId (Integer executionContextId) {
        this.executionContextId = executionContextId;
    }

    public Integer getExecutionContextId() {
        return this.executionContextId;
    }

    public ExecutionContextDestroyedEvent(Integer executionContextId) {
        this.executionContextId = executionContextId;
    }

    public ExecutionContextDestroyedEvent() {
    }

}