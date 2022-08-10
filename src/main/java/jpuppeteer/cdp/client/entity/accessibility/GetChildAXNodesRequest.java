package jpuppeteer.cdp.client.entity.accessibility;

/**
* experimental
*/
public class GetChildAXNodesRequest {

    /**
    */
    private String id;

    public void setId (String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public GetChildAXNodesRequest(String id) {
        this.id = id;
    }

    public GetChildAXNodesRequest() {
    }

}