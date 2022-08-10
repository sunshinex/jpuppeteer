package jpuppeteer.cdp.client.entity.page;

/**
*/
public class SetWebLifecycleStateRequest {

    /**
    * Target lifecycle state
    */
    private jpuppeteer.cdp.client.constant.page.SetWebLifecycleStateRequestState state;

    public void setState (jpuppeteer.cdp.client.constant.page.SetWebLifecycleStateRequestState state) {
        this.state = state;
    }

    public jpuppeteer.cdp.client.constant.page.SetWebLifecycleStateRequestState getState() {
        return this.state;
    }

    public SetWebLifecycleStateRequest(jpuppeteer.cdp.client.constant.page.SetWebLifecycleStateRequestState state) {
        this.state = state;
    }

    public SetWebLifecycleStateRequest() {
    }

}