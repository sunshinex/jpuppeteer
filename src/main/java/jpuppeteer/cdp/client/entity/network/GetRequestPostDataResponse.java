package jpuppeteer.cdp.client.entity.network;

/**
*/
public class GetRequestPostDataResponse {

    /**
    * Request body string, omitting files from multipart requests
    */
    private String postData;

    public void setPostData (String postData) {
        this.postData = postData;
    }

    public String getPostData() {
        return this.postData;
    }

    public GetRequestPostDataResponse(String postData) {
        this.postData = postData;
    }

    public GetRequestPostDataResponse() {
    }

}