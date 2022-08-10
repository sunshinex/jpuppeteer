package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* experimental
*/
public class GetObjectByHeapObjectIdResponse {

    /**
    * Evaluation result.
    */
    private jpuppeteer.cdp.client.entity.runtime.RemoteObject result;

    public void setResult (jpuppeteer.cdp.client.entity.runtime.RemoteObject result) {
        this.result = result;
    }

    public jpuppeteer.cdp.client.entity.runtime.RemoteObject getResult() {
        return this.result;
    }

    public GetObjectByHeapObjectIdResponse(jpuppeteer.cdp.client.entity.runtime.RemoteObject result) {
        this.result = result;
    }

    public GetObjectByHeapObjectIdResponse() {
    }

}