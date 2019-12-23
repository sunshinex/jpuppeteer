package jpuppeteer.cdp.cdp.domain;

/**
* experimental
*/
public class Animation {

    private jpuppeteer.cdp.CDPSession session;

    public Animation(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Disables animation domain notifications.
    * experimental
    */
    public void disable(int timeout) throws Exception {
        session.send("Animation.disable", null, timeout);
    }


    /**
    * Enables animation domain notifications.
    * experimental
    */
    public void enable(int timeout) throws Exception {
        session.send("Animation.enable", null, timeout);
    }


    /**
    * Returns the current time of the an animation.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.animation.GetCurrentTimeResponse getCurrentTime(jpuppeteer.cdp.cdp.entity.animation.GetCurrentTimeRequest request, int timeout) throws Exception {
        return session.send("Animation.getCurrentTime", request, jpuppeteer.cdp.cdp.entity.animation.GetCurrentTimeResponse.class, timeout);
    }


    /**
    * Gets the playback rate of the document timeline.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.animation.GetPlaybackRateResponse getPlaybackRate(int timeout) throws Exception {
        return session.send("Animation.getPlaybackRate", null, jpuppeteer.cdp.cdp.entity.animation.GetPlaybackRateResponse.class, timeout);
    }


    /**
    * Releases a set of animations to no longer be manipulated.
    * experimental
    */
    public void releaseAnimations(jpuppeteer.cdp.cdp.entity.animation.ReleaseAnimationsRequest request, int timeout) throws Exception {
        session.send("Animation.releaseAnimations", request, timeout);
    }


    /**
    * Gets the remote object of the Animation.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.animation.ResolveAnimationResponse resolveAnimation(jpuppeteer.cdp.cdp.entity.animation.ResolveAnimationRequest request, int timeout) throws Exception {
        return session.send("Animation.resolveAnimation", request, jpuppeteer.cdp.cdp.entity.animation.ResolveAnimationResponse.class, timeout);
    }


    /**
    * Seek a set of animations to a particular time within each animation.
    * experimental
    */
    public void seekAnimations(jpuppeteer.cdp.cdp.entity.animation.SeekAnimationsRequest request, int timeout) throws Exception {
        session.send("Animation.seekAnimations", request, timeout);
    }


    /**
    * Sets the paused state of a set of animations.
    * experimental
    */
    public void setPaused(jpuppeteer.cdp.cdp.entity.animation.SetPausedRequest request, int timeout) throws Exception {
        session.send("Animation.setPaused", request, timeout);
    }


    /**
    * Sets the playback rate of the document timeline.
    * experimental
    */
    public void setPlaybackRate(jpuppeteer.cdp.cdp.entity.animation.SetPlaybackRateRequest request, int timeout) throws Exception {
        session.send("Animation.setPlaybackRate", request, timeout);
    }


    /**
    * Sets the timing of an animation node.
    * experimental
    */
    public void setTiming(jpuppeteer.cdp.cdp.entity.animation.SetTimingRequest request, int timeout) throws Exception {
        session.send("Animation.setTiming", request, timeout);
    }

}