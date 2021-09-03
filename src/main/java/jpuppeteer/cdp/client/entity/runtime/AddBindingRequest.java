package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class AddBindingRequest {

    /**
    */
    public final String name;

    /**
    * If specified, the binding would only be exposed to the specified execution context. If omitted and `executionContextName` is not set, the binding is exposed to all execution contexts of the target. This parameter is mutually exclusive with `executionContextName`.
    */
    public final Integer executionContextId;

    /**
    * If specified, the binding is exposed to the executionContext with matching name, even for contexts created after the binding is added. See also `ExecutionContext.name` and `worldName` parameter to `Page.addScriptToEvaluateOnNewDocument`. This parameter is mutually exclusive with `executionContextId`.
    */
    public final String executionContextName;

    public AddBindingRequest(String name, Integer executionContextId, String executionContextName) {
        this.name = name;
        this.executionContextId = executionContextId;
        this.executionContextName = executionContextName;
    }

    public AddBindingRequest(String name) {
        this.name = name;
        this.executionContextId = null;
        this.executionContextName = null;
    }

}