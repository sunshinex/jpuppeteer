package jpuppeteer.cdp.client.entity.page;

/**
*/
public class SetWebLifecycleStateRequest {

    /**
    * Target lifecycle state
    */
    public final jpuppeteer.cdp.client.constant.page.SetWebLifecycleStateRequestState state;

    public SetWebLifecycleStateRequest(jpuppeteer.cdp.client.constant.page.SetWebLifecycleStateRequestState state) {
        this.state = state;
    }

}