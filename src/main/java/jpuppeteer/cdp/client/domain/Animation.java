package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class Animation {

    private jpuppeteer.cdp.CDPConnection connection;

    public Animation(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Disables animation domain notifications.
    */
    public io.netty.util.concurrent.Future disable() {
        return connection.send("Animation.disable", null);
    }


    /**
    * Enables animation domain notifications.
    */
    public io.netty.util.concurrent.Future enable() {
        return connection.send("Animation.enable", null);
    }


    /**
    * Returns the current time of the an animation.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.animation.GetCurrentTimeResponse> getCurrentTime(jpuppeteer.cdp.client.entity.animation.GetCurrentTimeRequest request) {
        return connection.send("Animation.getCurrentTime", request, jpuppeteer.cdp.client.entity.animation.GetCurrentTimeResponse.class);
    }


    /**
    * Gets the playback rate of the document timeline.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.animation.GetPlaybackRateResponse> getPlaybackRate() {
        return connection.send("Animation.getPlaybackRate", null, jpuppeteer.cdp.client.entity.animation.GetPlaybackRateResponse.class);
    }


    /**
    * Releases a set of animations to no longer be manipulated.
    */
    public io.netty.util.concurrent.Future releaseAnimations(jpuppeteer.cdp.client.entity.animation.ReleaseAnimationsRequest request) {
        return connection.send("Animation.releaseAnimations", request);
    }


    /**
    * Gets the remote object of the Animation.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.animation.ResolveAnimationResponse> resolveAnimation(jpuppeteer.cdp.client.entity.animation.ResolveAnimationRequest request) {
        return connection.send("Animation.resolveAnimation", request, jpuppeteer.cdp.client.entity.animation.ResolveAnimationResponse.class);
    }


    /**
    * Seek a set of animations to a particular time within each animation.
    */
    public io.netty.util.concurrent.Future seekAnimations(jpuppeteer.cdp.client.entity.animation.SeekAnimationsRequest request) {
        return connection.send("Animation.seekAnimations", request);
    }


    /**
    * Sets the paused state of a set of animations.
    */
    public io.netty.util.concurrent.Future setPaused(jpuppeteer.cdp.client.entity.animation.SetPausedRequest request) {
        return connection.send("Animation.setPaused", request);
    }


    /**
    * Sets the playback rate of the document timeline.
    */
    public io.netty.util.concurrent.Future setPlaybackRate(jpuppeteer.cdp.client.entity.animation.SetPlaybackRateRequest request) {
        return connection.send("Animation.setPlaybackRate", request);
    }


    /**
    * Sets the timing of an animation node.
    */
    public io.netty.util.concurrent.Future setTiming(jpuppeteer.cdp.client.entity.animation.SetTimingRequest request) {
        return connection.send("Animation.setTiming", request);
    }

}