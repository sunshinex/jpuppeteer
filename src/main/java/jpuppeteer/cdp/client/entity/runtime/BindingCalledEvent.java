package jpuppeteer.cdp.client.entity.runtime;

/**
* Notification is issued every time when binding is called.
*/
public class BindingCalledEvent {

    /**
    */
    public final String name;

    /**
    */
    public final String payload;

    /**
    * Identifier of the context where the call was made.
    */
    public final Integer executionContextId;

    public BindingCalledEvent(String name, String payload, Integer executionContextId) {
        this.name = name;
        this.payload = payload;
        this.executionContextId = executionContextId;
    }

}