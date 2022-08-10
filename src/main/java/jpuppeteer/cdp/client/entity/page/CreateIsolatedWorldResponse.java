package jpuppeteer.cdp.client.entity.page;

/**
*/
public class CreateIsolatedWorldResponse {

    /**
    * Execution context of the isolated world.
    */
    private Integer executionContextId;

    public void setExecutionContextId (Integer executionContextId) {
        this.executionContextId = executionContextId;
    }

    public Integer getExecutionContextId() {
        return this.executionContextId;
    }

    public CreateIsolatedWorldResponse(Integer executionContextId) {
        this.executionContextId = executionContextId;
    }

    public CreateIsolatedWorldResponse() {
    }

}