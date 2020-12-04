package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class AddBindingRequest {

    /**
    */
    public final String name;

    /**
    */
    public final Integer executionContextId;

    public AddBindingRequest(String name, Integer executionContextId) {
        this.name = name;
        this.executionContextId = executionContextId;
    }

    public AddBindingRequest(String name) {
        this.name = name;
        this.executionContextId = null;
    }

}