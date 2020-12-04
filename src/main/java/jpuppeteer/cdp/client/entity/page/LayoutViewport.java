package jpuppeteer.cdp.client.entity.page;

/**
* Layout viewport position and dimensions.
*/
public class LayoutViewport {

    /**
    * Horizontal offset relative to the document (CSS pixels).
    */
    public final Integer pageX;

    /**
    * Vertical offset relative to the document (CSS pixels).
    */
    public final Integer pageY;

    /**
    * Width (CSS pixels), excludes scrollbar if present.
    */
    public final Integer clientWidth;

    /**
    * Height (CSS pixels), excludes scrollbar if present.
    */
    public final Integer clientHeight;

    public LayoutViewport(Integer pageX, Integer pageY, Integer clientWidth, Integer clientHeight) {
        this.pageX = pageX;
        this.pageY = pageY;
        this.clientWidth = clientWidth;
        this.clientHeight = clientHeight;
    }

}