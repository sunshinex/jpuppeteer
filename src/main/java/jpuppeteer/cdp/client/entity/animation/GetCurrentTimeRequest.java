package jpuppeteer.cdp.client.entity.animation;

/**
* experimental
*/
public class GetCurrentTimeRequest {

    /**
    * Id of animation.
    */
    public final String id;

    public GetCurrentTimeRequest(String id) {
        this.id = id;
    }

}