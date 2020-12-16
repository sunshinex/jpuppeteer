package jpuppeteer.cdp.client.entity.animation;

/**
* experimental
*/
public class GetPlaybackRateResponse {

    /**
    * Playback rate for animations on page.
    */
    public final java.math.BigDecimal playbackRate;

    public GetPlaybackRateResponse(java.math.BigDecimal playbackRate) {
        this.playbackRate = playbackRate;
    }

}