package jpuppeteer.cdp.client.entity.animation;

/**
* experimental
*/
public class SetPlaybackRateRequest {

    /**
    * Playback rate for animations on page
    */
    private java.math.BigDecimal playbackRate;

    public void setPlaybackRate (java.math.BigDecimal playbackRate) {
        this.playbackRate = playbackRate;
    }

    public java.math.BigDecimal getPlaybackRate() {
        return this.playbackRate;
    }

    public SetPlaybackRateRequest(java.math.BigDecimal playbackRate) {
        this.playbackRate = playbackRate;
    }

    public SetPlaybackRateRequest() {
    }

}