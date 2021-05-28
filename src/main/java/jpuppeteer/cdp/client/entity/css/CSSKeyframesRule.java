package jpuppeteer.cdp.client.entity.css;

/**
* CSS keyframes rule representation.
* experimental
*/
public class CSSKeyframesRule {

    /**
    * Animation name.
    */
    public final jpuppeteer.cdp.client.entity.css.Value animationName;

    /**
    * List of keyframes.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.css.CSSKeyframeRule> keyframes;

    public CSSKeyframesRule(jpuppeteer.cdp.client.entity.css.Value animationName, java.util.List<jpuppeteer.cdp.client.entity.css.CSSKeyframeRule> keyframes) {
        this.animationName = animationName;
        this.keyframes = keyframes;
    }

}