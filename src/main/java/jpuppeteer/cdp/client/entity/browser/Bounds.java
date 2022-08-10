package jpuppeteer.cdp.client.entity.browser;

/**
* Browser window bounds information
*/
public class Bounds {

    /**
    * The offset from the left edge of the screen to the window in pixels.
    */
    private Integer left;

    /**
    * The offset from the top edge of the screen to the window in pixels.
    */
    private Integer top;

    /**
    * The window width in pixels.
    */
    private Integer width;

    /**
    * The window height in pixels.
    */
    private Integer height;

    /**
    * The window state. Default to normal.
    */
    private jpuppeteer.cdp.client.constant.browser.WindowState windowState;

    public void setLeft (Integer left) {
        this.left = left;
    }

    public Integer getLeft() {
        return this.left;
    }

    public void setTop (Integer top) {
        this.top = top;
    }

    public Integer getTop() {
        return this.top;
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

    public void setWindowState (jpuppeteer.cdp.client.constant.browser.WindowState windowState) {
        this.windowState = windowState;
    }

    public jpuppeteer.cdp.client.constant.browser.WindowState getWindowState() {
        return this.windowState;
    }

    public Bounds(Integer left, Integer top, Integer width, Integer height, jpuppeteer.cdp.client.constant.browser.WindowState windowState) {
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