package jpuppeteer.cdp.client.entity.memory;

/**
* experimental
*/
public class GetDOMCountersResponse {

    /**
    */
    public final Integer documents;

    /**
    */
    public final Integer nodes;

    /**
    */
    public final Integer jsEventListeners;

    public GetDOMCountersResponse(Integer documents, Integer nodes, Integer jsEventListeners) {
        this.documents = documents;
        this.nodes = nodes;
        this.jsEventListeners = jsEventListeners;
    }

}