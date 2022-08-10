package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetFileInfoResponse {

    /**
    */
    private String path;

    public void setPath (String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

    public GetFileInfoResponse(String path) {
        this.path = path;
    }

    public GetFileInfoResponse() {
    }

}