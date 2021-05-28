package jpuppeteer.cdp.client.entity.animation;

/**
* experimental
*/
public class SetPlaybackRateRequest {

    /**
    * Playback rate for animations on page
    */
    public final java.math.BigDecimal playbackRate;

    public SetPlaybackRateRequest(java.math.BigDecimal playbackRate) {
        this.playbackRate = playbackRate;
    }

}