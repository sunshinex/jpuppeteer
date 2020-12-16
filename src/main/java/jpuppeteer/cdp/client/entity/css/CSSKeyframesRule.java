package jpuppeteer.cdp.client.entity.css;

/**
* CSS keyframes rule representation.
* experimental
*/
public class CSSKeyframesRule {

    /**
    * Animation name.
    */
    public final Value animationName;

    /**
    * List of keyframes.
    */
    public final java.util.List<CSSKeyframeRule> keyframes;

    public CSSKeyframesRule(Value animationName, java.util.List<CSSKeyframeRule> keyframes) {
        this.animationName = animationName;
        this.keyframes = keyframes;
    }

}