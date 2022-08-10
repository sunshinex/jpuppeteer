package jpuppeteer.cdp.client.entity.target;

/**
*/
public class CreateTargetRequest {

    /**
    * The initial URL the page will be navigated to. An empty string indicates about:blank.
    */
    private String url;

    /**
    * Frame width in DIP (headless chrome only).
    */
    private Integer width;

    /**
    * Frame height in DIP (headless chrome only).
    */
    private Integer height;

    /**
    * The browser context to create the page in.
    */
    private String browserContextId;

    /**
    * Whether BeginFrames for this target will be controlled via DevTools (headless chrome only, not supported on MacOS yet, false by default).
    */
    private Boolean enableBeginFrameControl;

    /**
    * Whether to create a new Window or Tab (chrome-only, false by default).
    */
    private Boolean newWindow;

    /**
    * Whether to create the target in background or foreground (chrome-only, false by default).
    */
    private Boolean background;

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setWidth (Integer width) {
        this.width = width;
    }

    public Integer getWidth() {
        return this.width;
    }

    public void setHeight (Integer height) {
        this.height = height;
    }

    public Integer getHeight() {
        return this.height;
    }

    public void setBrowserContextId (String browserContextId) {
        this.browserContextId = browserContextId;
    }

    public String getBrowserContextId() {
        return this.browserContextId;
    }

    public void setEnableBeginFrameControl (Boolean enableBeginFrameControl) {
        this.enableBeginFrameControl = enableBeginFrameControl;
    }

    public Boolean getEnableBeginFrameControl() {
        return this.enableBeginFrameControl;
    }

    public void setNewWindow (Boolean newWindow) {
        this.newWindow = newWindow;
    }

    public Boolean getNewWindow() {
        return this.newWindow;
    }

    public void setBackground (Boolean background) {
        this.background = background;
    }

    public Boolean getBackground() {
        return this.background;
    }

    public CreateTargetRequest(String url, Integer width, Integer height, String browserContextId, Boolean enableBeginFrameControl, Boolean newWindow, Boolean background) {
        this.url = url;
        this.width = width;
        this.height = height;
        this.browserContextId = browserContextId;
        this.enableBeginFrameControl = enableBeginFrameControl;
        this.newWindow = newWindow;
        this.background = background;
    }

    public CreateTargetRequest(String url) {
        this.url = url;
        this.width = null;
        this.height = null;
        this.browserContextId = null;
        this.enableBeginFrameControl = null;
        this.newWindow = null;
        this.background = null;
    }

    public CreateTargetRequest() {
    }

}