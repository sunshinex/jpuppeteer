package jpuppeteer.cdp.client.entity.animation;

/**
* experimental
*/
public class SetTimingRequest {

    /**
    * Animation id.
    */
    private String animationId;

    /**
    * Duration of the animation.
    */
    private java.math.BigDecimal duration;

    /**
    * Delay of the animation.
    */
    private java.math.BigDecimal delay;

    public void setAnimationId (String animationId) {
        this.animationId = animationId;
    }

    public String getAnimationId() {
        return this.animationId;
    }

    public void setDuration (java.math.BigDecimal duration) {
        this.duration = duration;
    }

    public java.math.BigDecimal getDuration() {
        return this.duration;
    }

    public void setDelay (java.math.BigDecimal delay) {
        this.delay = delay;
    }

    public java.math.BigDecimal getDelay() {
        return this.delay;
    }

    public SetTimingRequest(String animationId, java.math.BigDecimal duration, java.math.BigDecimal delay) {
        this.animationId = animationId;
        this.duration = duration;
        this.delay = delay;
    }

    public SetTimingRequest() {
    }

}