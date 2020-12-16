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
    */
    public final String browserContextId;

    public TargetInfo(String targetId, String type, String title, String url, Boolean attached, String openerId, String browserContextId) {
        this.targetId = targetId;
        this.type = type;
        this.title = title;
        this.url = url;
        this.attached = attached;
        this.openerId = openerId;
        this.browserContextId = browserContextId;
    }

    public TargetInfo(String targetId, String type, String title, String url, Boolean attached) {
        this.targetId = targetId;
        this.type = type;
        this.title = title;
        this.url = url;
        this.attached = attached;
        this.openerId = null;
        this.browserContextId = null;
    }

}