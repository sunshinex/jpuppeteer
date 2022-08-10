package jpuppeteer.cdp.client.entity.cast;

/**
* experimental
*/
public class EnableRequest {

    /**
    */
    private String presentationUrl;

    public void setPresentationUrl (String presentationUrl) {
        this.presentationUrl = presentationUrl;
    }

    public String getPresentationUrl() {
        return this.presentationUrl;
    }

    public EnableRequest(String presentationUrl) {
        this.presentationUrl = presentationUrl;
    }

    public EnableRequest() {
        this.presentationUrl = null;
    }

}