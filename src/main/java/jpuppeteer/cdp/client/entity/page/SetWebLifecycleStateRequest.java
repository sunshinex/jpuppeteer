package jpuppeteer.cdp.client.entity.page;

/**
*/
public class SetWebLifecycleStateRequest {

    /**
    * Target lifecycle state
    */
    public final String state;

    public SetWebLifecycleStateRequest(String state) {
        this.state = state;
    }

}