package jpuppeteer.cdp.client.entity.animation;

/**
* AnimationEffect instance
* experimental
*/
public class AnimationEffect {

    /**
    * `AnimationEffect`'s delay.
    */
    private java.math.BigDecimal delay;

    /**
    * `AnimationEffect`'s end delay.
    */
    private java.math.BigDecimal endDelay;

    /**
    * `AnimationEffect`'s iteration start.
    */
    private java.math.BigDecimal iterationStart;

    /**
    * `AnimationEffect`'s iterations.
    */
    private java.math.BigDecimal iterations;

    /**
    * `AnimationEffect`'s iteration duration.
    */
    private java.math.BigDecimal duration;

    /**
    * `AnimationEffect`'s playback direction.
    */
    private String direction;

    /**
    * `AnimationEffect`'s fill mode.
    */
    private String fill;

    /**
    * `AnimationEffect`'s target node.
    */
    private Integer backendNodeId;

    /**
    * `AnimationEffect`'s keyframes.
    */
    private jpuppeteer.cdp.client.entity.animation.KeyframesRule keyframesRule;

    /**
    * `AnimationEffect`'s timing function.
    */
    private String easing;

    public void setDelay (java.math.BigDecimal delay) {
        this.delay = delay;
    }

    public java.math.BigDecimal getDelay() {
        return this.delay;
    }

    public void setEndDelay (java.math.BigDecimal endDelay) {
        this.endDelay = endDelay;
    }

    public java.math.BigDecimal getEndDelay() {
        return this.endDelay;
    }

    public void setIterationStart (java.math.BigDecimal iterationStart) {
        this.iterationStart = iterationStart;
    }

    public java.math.BigDecimal getIterationStart() {
        return this.iterationStart;
    }

    public void setIterations (java.math.BigDecimal iterations) {
        this.iterations = iterations;
    }

    public java.math.BigDecimal getIterations() {
        return this.iterations;
    }

    public void setDuration (java.math.BigDecimal duration) {
        this.duration = duration;
    }

    public java.math.BigDecimal getDuration() {
        return this.duration;
    }

    public void setDirection (String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return this.direction;
    }

    public void setFill (String fill) {
        this.fill = fill;
    }

    public String getFill() {
        return this.fill;
    }

    public void setBackendNodeId (Integer backendNodeId) {
        this.backendNodeId = backendNodeId;
    }

    public Integer getBackendNodeId() {
        return this.backendNodeId;
    }

    public void setKeyframesRule (jpuppeteer.cdp.client.entity.animation.KeyframesRule keyframesRule) {
        this.keyframesRule = keyframesRule;
    }

    public jpuppeteer.cdp.client.entity.animation.KeyframesRule getKeyframesRule() {
        return this.keyframesRule;
    }

    public void setEasing (String easing) {
        this.easing = easing;
    }

    public String getEasing() {
        return this.easing;
    }

    public AnimationEffect(java.math.BigDecimal delay, java.math.BigDecimal endDelay, java.math.BigDecimal iterationStart, java.math.BigDecimal iterations, java.math.BigDecimal duration, String direction, String fill, Integer backendNodeId, jpuppeteer.cdp.client.entity.animation.KeyframesRule keyframesRule, String easing) {
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

    public AnimationEffect() {
    }

}