package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class GetIsolateIdResponse {

    /**
    * The isolate id.
    */
    private String id;

    public void setId (String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public GetIsolateIdResponse(String id) {
        this.id = id;
    }

    public GetIsolateIdResponse() {
    }

}