package jpuppeteer.cdp.client.entity.network;

/**
*/
public class GetRequestPostDataResponse {

    /**
    * Request body string, omitting files from multipart requests
    */
    public final String postData;

    public GetRequestPostDataResponse(String postData) {
        this.postData = postData;
    }

}