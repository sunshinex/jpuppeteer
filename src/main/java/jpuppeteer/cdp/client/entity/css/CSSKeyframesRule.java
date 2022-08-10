package jpuppeteer.cdp.client.entity.css;

/**
* CSS keyframes rule representation.
* experimental
*/
public class CSSKeyframesRule {

    /**
    * Animation name.
    */
    private jpuppeteer.cdp.client.entity.css.Value animationName;

    /**
    * List of keyframes.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.css.CSSKeyframeRule> keyframes;

    public void setAnimationName (jpuppeteer.cdp.client.entity.css.Value animationName) {
        this.animationName = animationName;
    }

    public jpuppeteer.cdp.client.entity.css.Value getAnimationName() {
        return this.animationName;
    }

    public void setKeyframes (java.util.List<jpuppeteer.cdp.client.entity.css.CSSKeyframeRule> keyframes) {
        this.keyframes = keyframes;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.css.CSSKeyframeRule> getKeyframes() {
        return this.keyframes;
    }

    public CSSKeyframesRule(jpuppeteer.cdp.client.entity.css.Value animationName, java.util.List<jpuppeteer.cdp.client.entity.css.CSSKeyframeRule> keyframes) {
        this.animationName = animationName;
        this.keyframes = keyframes;
    }

    public CSSKeyframesRule() {
    }

}