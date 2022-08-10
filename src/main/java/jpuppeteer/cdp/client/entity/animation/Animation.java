package jpuppeteer.cdp.client.entity.animation;

/**
* Animation instance.
* experimental
*/
public class Animation {

    /**
    * `Animation`'s id.
    */
    private String id;

    /**
    * `Animation`'s name.
    */
    private String name;

    /**
    * `Animation`'s internal paused state.
    */
    private Boolean pausedState;

    /**
    * `Animation`'s play state.
    */
    private String playState;

    /**
    * `Animation`'s playback rate.
    */
    private java.math.BigDecimal playbackRate;

    /**
    * `Animation`'s start time.
    */
    private java.math.BigDecimal startTime;

    /**
    * `Animation`'s current time.
    */
    private java.math.BigDecimal currentTime;

    /**
    * Animation type of `Animation`.
    */
    private jpuppeteer.cdp.client.constant.animation.AnimationType type;

    /**
    * `Animation`'s source animation node.
    */
    private jpuppeteer.cdp.client.entity.animation.AnimationEffect source;

    /**
    * A unique ID for `Animation` representing the sources that triggered this CSS animation/transition.
    */
    private String cssId;

    public void setId (String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPausedState (Boolean pausedState) {
        this.pausedState = pausedState;
    }

    public Boolean getPausedState() {
        return this.pausedState;
    }

    public void setPlayState (String playState) {
        this.playState = playState;
    }

    public String getPlayState() {
        return this.playState;
    }

    public void setPlaybackRate (java.math.BigDecimal playbackRate) {
        this.playbackRate = playbackRate;
    }

    public java.math.BigDecimal getPlaybackRate() {
        return this.playbackRate;
    }

    public void setStartTime (java.math.BigDecimal startTime) {
        this.startTime = startTime;
    }

    public java.math.BigDecimal getStartTime() {
        return this.startTime;
    }

    public void setCurrentTime (java.math.BigDecimal currentTime) {
        this.currentTime = currentTime;
    }

    public java.math.BigDecimal getCurrentTime() {
        return this.currentTime;
    }

    public void setType (jpuppeteer.cdp.client.constant.animation.AnimationType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.animation.AnimationType getType() {
        return this.type;
    }

    public void setSource (jpuppeteer.cdp.client.entity.animation.AnimationEffect source) {
        this.source = source;
    }

    public jpuppeteer.cdp.client.entity.animation.AnimationEffect getSource() {
        return this.source;
    }

    public void setCssId (String cssId) {
        this.cssId = cssId;
    }

    public String getCssId() {
        return this.cssId;
    }

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

    public Animation() {
    }

}