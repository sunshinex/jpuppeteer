package jpuppeteer.cdp.client.entity.animation;

/**
* Keyframes Rule
* experimental
*/
public class KeyframesRule {

    /**
    * CSS keyframed animation's name.
    */
    private String name;

    /**
    * List of animation keyframes.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.animation.KeyframeStyle> keyframes;

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setKeyframes (java.util.List<jpuppeteer.cdp.client.entity.animation.KeyframeStyle> keyframes) {
        this.keyframes = keyframes;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.animation.KeyframeStyle> getKeyframes() {
        return this.keyframes;
    }

    public KeyframesRule(String name, java.util.List<jpuppeteer.cdp.client.entity.animation.KeyframeStyle> keyframes) {
        this.name = name;
        this.keyframes = keyframes;
    }

    public KeyframesRule(java.util.List<jpuppeteer.cdp.client.entity.animation.KeyframeStyle> keyframes) {
        this.name = null;
        this.keyframes = keyframes;
    }

    public KeyframesRule() {
    }

}