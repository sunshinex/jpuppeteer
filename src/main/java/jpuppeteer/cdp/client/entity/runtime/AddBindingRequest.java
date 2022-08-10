package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class AddBindingRequest {

    /**
    */
    private String name;

    /**
    * If specified, the binding would only be exposed to the specified execution context. If omitted and `executionContextName` is not set, the binding is exposed to all execution contexts of the target. This parameter is mutually exclusive with `executionContextName`.
    */
    private Integer executionContextId;

    /**
    * If specified, the binding is exposed to the executionContext with matching name, even for contexts created after the binding is added. See also `ExecutionContext.name` and `worldName` parameter to `Page.addScriptToEvaluateOnNewDocument`. This parameter is mutually exclusive with `executionContextId`.
    */
    private String executionContextName;

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setExecutionContextId (Integer executionContextId) {
        this.executionContextId = executionContextId;
    }

    public Integer getExecutionContextId() {
        return this.executionContextId;
    }

    public void setExecutionContextName (String executionContextName) {
        this.executionContextName = executionContextName;
    }

    public String getExecutionContextName() {
        return this.executionContextName;
    }

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

    public AddBindingRequest() {
    }

}