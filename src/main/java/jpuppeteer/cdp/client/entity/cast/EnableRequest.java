package jpuppeteer.cdp.client.entity.cast;

/**
* experimental
*/
public class EnableRequest {

    /**
    */
    public final String presentationUrl;

    public EnableRequest(String presentationUrl) {
        this.presentationUrl = presentationUrl;
    }

    public EnableRequest() {
        this.presentationUrl = null;
    }

}