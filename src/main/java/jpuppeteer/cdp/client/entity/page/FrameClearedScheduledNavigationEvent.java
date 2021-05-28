package jpuppeteer.cdp.client.entity.page;

/**
* Fired when frame no longer has a scheduled navigation.
*/
public class FrameClearedScheduledNavigationEvent {

    /**
    * Id of the frame that has cleared its scheduled navigation.
    */
    public final String frameId;

    public FrameClearedScheduledNavigationEvent(String frameId) {
        this.frameId = frameId;
    }

}