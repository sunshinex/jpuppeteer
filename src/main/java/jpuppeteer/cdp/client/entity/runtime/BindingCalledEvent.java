package jpuppeteer.cdp.client.entity.runtime;

/**
* Notification is issued every time when binding is called.
*/
public class BindingCalledEvent {

    /**
    */
    private String name;

    /**
    */
    private String payload;

    /**
    * Identifier of the context where the call was made.
    */
    private Integer executionContextId;

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPayload (String payload) {
        this.payload = payload;
    }

    public String getPayload() {
        return this.payload;
    }

    public void setExecutionContextId (Integer executionContextId) {
        this.executionContextId = executionContextId;
    }

    public Integer getExecutionContextId() {
        return this.executionContextId;
    }

    public BindingCalledEvent(String name, String payload, Integer executionContextId) {
        this.name = name;
        this.payload = payload;
        this.executionContextId = executionContextId;
    }

    public BindingCalledEvent() {
    }

}