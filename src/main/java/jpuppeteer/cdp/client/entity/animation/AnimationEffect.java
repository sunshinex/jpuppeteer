package jpuppeteer.cdp.client.entity.animation;

/**
* AnimationEffect instance
* experimental
*/
public class AnimationEffect {

    /**
    * `AnimationEffect`'s delay.
    */
    public final java.math.BigDecimal delay;

    /**
    * `AnimationEffect`'s end delay.
    */
    public final java.math.BigDecimal endDelay;

    /**
    * `AnimationEffect`'s iteration start.
    */
    public final java.math.BigDecimal iterationStart;

    /**
    * `AnimationEffect`'s iterations.
    */
    public final java.math.BigDecimal iterations;

    /**
    * `AnimationEffect`'s iteration duration.
    */
    public final java.math.BigDecimal duration;

    /**
    * `AnimationEffect`'s playback direction.
    */
    public final String direction;

    /**
    * `AnimationEffect`'s fill mode.
    */
    public final String fill;

    /**
    * `AnimationEffect`'s target node.
    */
    public final Integer backendNodeId;

    /**
    * `AnimationEffect`'s keyframes.
    */
    public final KeyframesRule keyframesRule;

    /**
    * `AnimationEffect`'s timing function.
    */
    public final String easing;

    public AnimationEffect(java.math.BigDecimal delay, java.math.BigDecimal endDelay, java.math.BigDecimal iterationStart, java.math.BigDecimal iterations, java.math.BigDecimal duration, String direction, String fill, Integer backendNodeId, KeyframesRule keyframesRule, String easing) {
        this.delay = delay;
        this.endDelay = endDelay;
        this.iterationStart = iterationStart;
        this.iterations = iterations;
        this.duration = duration;
        this.direction = direction;
        this.fill = fill;
        this.backendNodeId = backendNodeId;
        this.keyframesRule = keyframesRule;
        this.easing = easing;
    }

    public AnimationEffect(java.math.BigDecimal delay, java.math.BigDecimal endDelay, java.math.BigDecimal iterationStart, java.math.BigDecimal iterations, java.math.BigDecimal duration, String direction, String fill, String easing) {
        this.delay = delay;
        this.endDelay = endDelay;
        this.iterationStart = iterationStart;
        this.iterations = iterations;
        this.duration = duration;
        this.direction = direction;
        this.fill = fill;
        this.backendNodeId = null;
        this.keyframesRule = null;
        this.easing = easing;
    }

}