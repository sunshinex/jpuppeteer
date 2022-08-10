package jpuppeteer.cdp.client.entity.animation;

/**
* experimental
*/
public class SetPausedRequest {

    /**
    * Animations to set the pause state of.
    */
    private java.util.List<String> animations;

    /**
    * Paused state to set to.
    */
    private Boolean paused;

    public void setAnimations (java.util.List<String> animations) {
        this.animations = animations;
    }

    public java.util.List<String> getAnimations() {
        return this.animations;
    }

    public void setPaused (Boolean paused) {
        this.paused = paused;
    }

    public Boolean getPaused() {
        return this.paused;
    }

    public SetPausedRequest(java.util.List<String> animations, Boolean paused) {
        this.animations = animations;
        this.paused = paused;
    }

    public SetPausedRequest() {
    }

}