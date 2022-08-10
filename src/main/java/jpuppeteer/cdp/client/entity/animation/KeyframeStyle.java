package jpuppeteer.cdp.client.entity.animation;

/**
* Keyframe Style
* experimental
*/
public class KeyframeStyle {

    /**
    * Keyframe's time offset.
    */
    private String offset;

    /**
    * `AnimationEffect`'s timing function.
    */
    private String easing;

    public void setOffset (String offset) {
        this.offset = offset;
    }

    public String getOffset() {
        return this.offset;
    }

    public void setEasing (String easing) {
        this.easing = easing;
    }

    public String getEasing() {
        return this.easing;
    }

    public KeyframeStyle(String offset, String easing) {
        this.offset = offset;
        this.easing = easing;
    }

    public KeyframeStyle() {
    }

}