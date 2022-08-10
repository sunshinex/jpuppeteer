package jpuppeteer.cdp.client.entity.target;

/**
*/
public class TargetInfo {

    /**
    */
    private String targetId;

    /**
    */
    private String type;

    /**
    */
    private String title;

    /**
    */
    private String url;

    /**
    * Whether the target has an attached client.
    */
    private Boolean attached;

    /**
    * Opener target Id
    */
    private String openerId;

    /**
    * Whether the target has access to the originating window.
    */
    private Boolean canAccessOpener;

    /**
    * Frame id of originating window (is only set if target has an opener).
    */
    private String openerFrameId;

    /**
    */
    private String browserContextId;

    public void setTargetId (String targetId) {
        this.targetId = targetId;
    }

    public String getTargetId() {
        return this.targetId;
    }

    public void setType (String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setAttached (Boolean attached) {
        this.attached = attached;
    }

    public Boolean getAttached() {
        return this.attached;
    }

    public void setOpenerId (String openerId) {
        this.openerId = openerId;
    }

    public String getOpenerId() {
        return this.openerId;
    }

    public void setCanAccessOpener (Boolean canAccessOpener) {
        this.canAccessOpener = canAccessOpener;
    }

    public Boolean getCanAccessOpener() {
        return this.canAccessOpener;
    }

    public void setOpenerFrameId (String openerFrameId) {
        this.openerFrameId = openerFrameId;
    }

    public String getOpenerFrameId() {
        return this.openerFrameId;
    }

    public void setBrowserContextId (String browserContextId) {
        this.browserContextId = browserContextId;
    }

    public String getBrowserContextId() {
        return this.browserContextId;
    }

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

    public TargetInfo() {
    }

}