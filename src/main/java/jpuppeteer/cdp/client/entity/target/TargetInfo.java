package jpuppeteer.cdp.client.entity.target;

/**
*/
public class TargetInfo {

    /**
    */
    public final String targetId;

    /**
    */
    public final String type;

    /**
    */
    public final String title;

    /**
    */
    public final String url;

    /**
    * Whether the target has an attached client.
    */
    public final Boolean attached;

    /**
    * Opener target Id
    */
    public final String openerId;

    /**
    * Whether the target has access to the originating window.
    */
    public final Boolean canAccessOpener;

    /**
    * Frame id of originating window (is only set if target has an opener).
    */
    public final String openerFrameId;

    /**
    */
    public final String browserContextId;

    public TargetInfo(String targetId, String type, String title, String url, Boolean attached, String openerId, Boolean canAccessOpener, String openerFrameId, String browserContextId) {
        this.targetId = targetId;
        this.type = type;
        this.title = title;
        this.url = url;
        this.attached = attached;
        this.openerId = openerId;
        this.canAccessOpener = canAccessOpener;
        this.openerFrameId = openerFrameId;
        this.browserContextId = browserContextId;
    }

    public TargetInfo(String targetId, String type, String title, String url, Boolean attached, Boolean canAccessOpener) {
        this.targetId = targetId;
        this.type = type;
        this.title = title;
        this.url = url;
        this.attached = attached;
        this.openerId = null;
        this.canAccessOpener = canAccessOpener;
        this.openerFrameId = null;
        this.browserContextId = null;
    }

}