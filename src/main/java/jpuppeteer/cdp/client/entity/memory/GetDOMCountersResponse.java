package jpuppeteer.cdp.client.entity.memory;

/**
* experimental
*/
public class GetDOMCountersResponse {

    /**
    */
    private Integer documents;

    /**
    */
    private Integer nodes;

    /**
    */
    private Integer jsEventListeners;

    public void setDocuments (Integer documents) {
        this.documents = documents;
    }

    public Integer getDocuments() {
        return this.documents;
    }

    public void setNodes (Integer nodes) {
        this.nodes = nodes;
    }

    public Integer getNodes() {
        return this.nodes;
    }

    public void setJsEventListeners (Integer jsEventListeners) {
        this.jsEventListeners = jsEventListeners;
    }

    public Integer getJsEventListeners() {
        return this.jsEventListeners;
    }

    public GetDOMCountersResponse(Integer documents, Integer nodes, Integer jsEventListeners) {
        this.documents = documents;
        this.nodes = nodes;
        this.jsEventListeners = jsEventListeners;
    }

    public GetDOMCountersResponse() {
    }

}