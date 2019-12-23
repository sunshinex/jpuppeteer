package jpuppeteer.cdp.cdp.entity.target;

/**
*/
@lombok.Setter
@lombok.Getter
@lombok.ToString
public class CreateTargetRequest {

    /**
    * The initial URL the page will be navigated to.
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



}