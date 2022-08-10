package jpuppeteer.cdp.client.entity.animation;

/**
* experimental
*/
public class ReleaseAnimationsRequest {

    /**
    * List of animation ids to seek.
    */
    private java.util.List<String> animations;

    public void setAnimations (java.util.List<String> animations) {
        this.animations = animations;
    }

    public java.util.List<String> getAnimations() {
        return this.animations;
    }

    public ReleaseAnimationsRequest(java.util.List<String> animations) {
        this.animations = animations;
    }

    public ReleaseAnimationsRequest() {
    }

}