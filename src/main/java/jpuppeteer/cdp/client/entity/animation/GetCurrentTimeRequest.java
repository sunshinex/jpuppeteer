package jpuppeteer.cdp.client.entity.animation;

/**
* experimental
*/
public class GetCurrentTimeRequest {

    /**
    * Id of animation.
    */
    private String id;

    public void setId (String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public GetCurrentTimeRequest(String id) {
        this.id = id;
    }

    public GetCurrentTimeRequest() {
    }

}