package jpuppeteer.cdp.client.entity.animation;

/**
* experimental
*/
public class SetTimingRequest {

    /**
    * Animation id.
    */
    public final String animationId;

    /**
    * Duration of the animation.
    */
    public final java.math.BigDecimal duration;

    /**
    * Delay of the animation.
    */
    public final java.math.BigDecimal delay;

    public SetTimingRequest(String animationId, java.math.BigDecimal duration, java.math.BigDecimal delay) {
        this.animationId = animationId;
        this.duration = duration;
        this.delay = delay;
    }

}