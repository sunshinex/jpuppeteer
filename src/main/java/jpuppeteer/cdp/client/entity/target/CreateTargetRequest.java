package jpuppeteer.cdp.client.entity.target;

/**
*/
public class CreateTargetRequest {

    /**
    * The initial URL the page will be navigated to.
    */
    public final String url;

    /**
    * Frame width in DIP (headless chrome only).
    */
    public final Integer width;

    /**
    * Frame height in DIP (headless chrome only).
    */
    public final Integer height;

    /**
    * The browser context to create the page in.
    */
    public final String browserContextId;

    /**
    * Whether BeginFrames for this target will be controlled via DevTools (headless chrome only, not supported on MacOS yet, false by default).
    */
    public final Boolean enableBeginFrameControl;

    /**
    * Whether to create a new Window or Tab (chrome-only, false by default).
    */
    public final Boolean newWindow;

    /**
    * Whether to create the target in background or foreground (chrome-only, false by default).
    */
    public final Boolean background;

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

}