package jpuppeteer.cdp.client.entity.animation;

/**
* Animation instance.
* experimental
*/
public class Animation {

    /**
    * `Animation`'s id.
    */
    public final String id;

    /**
    * `Animation`'s name.
    */
    public final String name;

    /**
    * `Animation`'s internal paused state.
    */
    public final Boolean pausedState;

    /**
    * `Animation`'s play state.
    */
    public final String playState;

    /**
    * `Animation`'s playback rate.
    */
    public final java.math.BigDecimal playbackRate;

    /**
    * `Animation`'s start time.
    */
    public final java.math.BigDecimal startTime;

    /**
    * `Animation`'s current time.
    */
    public final java.math.BigDecimal currentTime;

    /**
    * Animation type of `Animation`.
    */
    public final jpuppeteer.cdp.client.constant.animation.AnimationType type;

    /**
    * `Animation`'s source animation node.
    */
    public final jpuppeteer.cdp.client.entity.animation.AnimationEffect source;

    /**
    * A unique ID for `Animation` representing the sources that triggered this CSS animation/transition.
    */
    public final String cssId;

    public Animation(String id, String name, Boolean pausedState, String playState, java.math.BigDecimal playbackRate, java.math.BigDecimal startTime, java.math.BigDecimal currentTime, jpuppeteer.cdp.client.constant.animation.AnimationType type, jpuppeteer.cdp.client.entity.animation.AnimationEffect source, String cssId) {
        this.id = id;
        this.name = name;
        this.pausedState = pausedState;
        this.playState = playState;
        this.playbackRate = playbackRate;
        this.startTime = startTime;
        this.currentTime = currentTime;
        this.type = type;
        this.source = source;
        this.cssId = cssId;
    }

    public Animation(String id, String name, Boolean pausedState, String playState, java.math.BigDecimal playbackRate, java.math.BigDecimal startTime, java.math.BigDecimal currentTime, jpuppeteer.cdp.client.constant.animation.AnimationType type) {
        this.id = id;
        this.name = name;
        this.pausedState = pausedState;
        this.playState = playState;
        this.playbackRate = playbackRate;
        this.startTime = startTime;
        this.currentTime = currentTime;
        this.type = type;
        this.source = null;
        this.cssId = null;
    }

}