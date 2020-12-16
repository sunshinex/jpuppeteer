package jpuppeteer.cdp.client.entity.animation;

/**
* Keyframes Rule
* experimental
*/
public class KeyframesRule {

    /**
    * CSS keyframed animation's name.
    */
    public final String name;

    /**
    * List of animation keyframes.
    */
    public final java.util.List<KeyframeStyle> keyframes;

    public KeyframesRule(String name, java.util.List<KeyframeStyle> keyframes) {
        this.name = name;
        this.keyframes = keyframes;
    }

    public KeyframesRule(java.util.List<KeyframeStyle> keyframes) {
        this.name = null;
        this.keyframes = keyframes;
    }

}