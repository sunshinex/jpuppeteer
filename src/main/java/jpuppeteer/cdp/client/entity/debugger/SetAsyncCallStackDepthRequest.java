package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetAsyncCallStackDepthRequest {

    /**
    * Maximum depth of async call stacks. Setting to `0` will effectively disable collecting async call stacks (default).
    */
    public final Integer maxDepth;

    public SetAsyncCallStackDepthRequest(Integer maxDepth) {
        this.maxDepth = maxDepth;
    }

}