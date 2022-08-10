package jpuppeteer.cdp.client.entity.page;

/**
* Layout viewport position and dimensions.
*/
public class LayoutViewport {

    /**
    * Horizontal offset relative to the document (CSS pixels).
    */
    private Integer pageX;

    /**
    * Vertical offset relative to the document (CSS pixels).
    */
    private Integer pageY;

    /**
    * Width (CSS pixels), excludes scrollbar if present.
    */
    private Integer clientWidth;

    /**
    * Height (CSS pixels), excludes scrollbar if present.
    */
    private Integer clientHeight;

    public void setPageX (Integer pageX) {
        this.pageX = pageX;
    }

    public Integer getPageX() {
        return this.pageX;
    }

    public void setPageY (Integer pageY) {
        this.pageY = pageY;
    }

    public Integer getPageY() {
        return this.pageY;
    }

    public void setClientWidth (Integer clientWidth) {
        this.clientWidth = clientWidth;
    }

    public Integer getClientWidth() {
        return this.clientWidth;
    }

    public void setClientHeight (Integer clientHeight) {
        this.clientHeight = clientHeight;
    }

    public Integer getClientHeight() {
        return this.clientHeight;
    }

    public LayoutViewport(Integer pageX, Integer pageY, Integer clientWidth, Integer clientHeight) {
        this.pageX = pageX;
        this.pageY = pageY;
        this.clientWidth = clientWidth;
        this.clientHeight = clientHeight;
    }

    public LayoutViewport() {
    }

}