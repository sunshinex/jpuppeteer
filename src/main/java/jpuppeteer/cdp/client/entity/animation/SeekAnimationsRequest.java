package jpuppeteer.cdp.client.entity.animation;

/**
* experimental
*/
public class SeekAnimationsRequest {

    /**
    * List of animation ids to seek.
    */
    private java.util.List<String> animations;

    /**
    * Set the current time of each animation.
    */
    private java.math.BigDecimal currentTime;

    public void setAnimations (java.util.List<String> animations) {
        this.animations = animations;
    }

    public java.util.List<String> getAnimations() {
        return this.animations;
    }

    public void setCurrentTime (java.math.BigDecimal currentTime) {
        this.currentTime = currentTime;
    }

    public java.math.BigDecimal getCurrentTime() {
        return this.currentTime;
    }

    public SeekAnimationsRequest(java.util.List<String> animations, java.math.BigDecimal currentTime) {
        this.animations = animations;
        this.currentTime = currentTime;
    }

    public SeekAnimationsRequest() {
    }

}