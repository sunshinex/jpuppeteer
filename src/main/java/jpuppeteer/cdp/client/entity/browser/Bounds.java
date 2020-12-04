package jpuppeteer.cdp.client.entity.browser;

/**
* Browser window bounds information
*/
public class Bounds {

    /**
    * The offset from the left edge of the screen to the window in pixels.
    */
    public final Integer left;

    /**
    * The offset from the top edge of the screen to the window in pixels.
    */
    public final Integer top;

    /**
    * The window width in pixels.
    */
    public final Integer width;

    /**
    * The window height in pixels.
    */
    public final Integer height;

    /**
    * The window state. Default to normal.
    */
    public final String windowState;

    public Bounds(Integer left, Integer top, Integer width, Integer height, String windowState) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
        this.windowState = windowState;
    }

    public Bounds() {
        this.left = null;
        this.top = null;
        this.width = null;
        this.height = null;
        this.windowState = null;
    }

}