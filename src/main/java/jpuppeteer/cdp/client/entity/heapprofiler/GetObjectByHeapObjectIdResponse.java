package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* experimental
*/
public class GetObjectByHeapObjectIdResponse {

    /**
    * Evaluation result.
    */
    public final jpuppeteer.cdp.client.entity.runtime.RemoteObject result;

    public GetObjectByHeapObjectIdResponse(jpuppeteer.cdp.client.entity.runtime.RemoteObject result) {
        this.result = result;
    }

}