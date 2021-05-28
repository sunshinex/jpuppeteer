package jpuppeteer.cdp.client.entity.page;

/**
*/
public class CreateIsolatedWorldResponse {

    /**
    * Execution context of the isolated world.
    */
    public final Integer executionContextId;

    public CreateIsolatedWorldResponse(Integer executionContextId) {
        this.executionContextId = executionContextId;
    }

}