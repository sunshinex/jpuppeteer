package jpuppeteer.cdp.client.entity.animation;

/**
* experimental
*/
public class ReleaseAnimationsRequest {

    /**
    * List of animation ids to seek.
    */
    public final java.util.List<String> animations;

    public ReleaseAnimationsRequest(java.util.List<String> animations) {
        this.animations = animations;
    }

}