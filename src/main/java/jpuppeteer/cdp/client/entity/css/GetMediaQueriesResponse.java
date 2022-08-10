package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class GetMediaQueriesResponse {

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.entity.css.CSSMedia> medias;

    public void setMedias (java.util.List<jpuppeteer.cdp.client.entity.css.CSSMedia> medias) {
        this.medias = medias;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.css.CSSMedia> getMedias() {
        return this.medias;
    }

    public GetMediaQueriesResponse(java.util.List<jpuppeteer.cdp.client.entity.css.CSSMedia> medias) {
        this.medias = medias;
    }

    public GetMediaQueriesResponse() {
    }

}