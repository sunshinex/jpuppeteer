package jpuppeteer.cdp.client.entity.animation;

/**
* Keyframe Style
* experimental
*/
public class KeyframeStyle {

    /**
    * Keyframe's time offset.
    */
    public final String offset;

    /**
    * `AnimationEffect`'s timing function.
    */
    public final String easing;

    public KeyframeStyle(String offset, String easing) {
        this.offset = offset;
        this.easing = easing;
    }

}