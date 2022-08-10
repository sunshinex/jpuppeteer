package jpuppeteer.cdp.client.entity.animation;

/**
* experimental
*/
public class ResolveAnimationRequest {

    /**
    * Animation id.
    */
    private String animationId;

    public void setAnimationId (String animationId) {
        this.animationId = animationId;
    }

    public String getAnimationId() {
        return this.animationId;
    }

    public ResolveAnimationRequest(String animationId) {
        this.animationId = animationId;
    }

    public ResolveAnimationRequest() {
    }

}