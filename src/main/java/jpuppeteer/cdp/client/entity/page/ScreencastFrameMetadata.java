package jpuppeteer.cdp.client.entity.page;

/**
* Screencast frame metadata.
*/
public class ScreencastFrameMetadata {

    /**
    * Top offset in DIP.
    */
    public final java.math.BigDecimal offsetTop;

    /**
    * Page scale factor.
    */
    public final java.math.BigDecimal pageScaleFactor;

    /**
    * Device screen width in DIP.
    */
    public final java.math.BigDecimal deviceWidth;

    /**
    * Device screen height in DIP.
    */
    public final java.math.BigDecimal deviceHeight;

    /**
    * Position of horizontal scroll in CSS pixels.
    */
    public final java.math.BigDecimal scrollOffsetX;

    /**
    * Position of vertical scroll in CSS pixels.
    */
    public final java.math.BigDecimal scrollOffsetY;

    /**
    * Frame swap timestamp.
    */
    public final java.math.BigDecimal timestamp;

    public ScreencastFrameMetadata(java.math.BigDecimal offsetTop, java.math.BigDecimal pageScaleFactor, java.math.BigDecimal deviceWidth, java.math.BigDecimal deviceHeight, java.math.BigDecimal scrollOffsetX, java.math.BigDecimal scrollOffsetY, java.math.BigDecimal timestamp) {
        this.offsetTop = offsetTop;
        this.pageScaleFactor = pageScaleFactor;
        this.deviceWidth = deviceWidth;
        this.deviceHeight = deviceHeight;
        this.scrollOffsetX = scrollOffsetX;
        this.scrollOffsetY = scrollOffsetY;
        this.timestamp = timestamp;
    }

    public ScreencastFrameMetadata(java.math.BigDecimal offsetTop, java.math.BigDecimal pageScaleFactor, java.math.BigDecimal deviceWidth, java.math.BigDecimal deviceHeight, java.math.BigDecimal scrollOffsetX, java.math.BigDecimal scrollOffsetY) {
        this.offsetTop = offsetTop;
        this.pageScaleFactor = pageScaleFactor;
        this.deviceWidth = deviceWidth;
        this.deviceHeight = deviceHeight;
        this.scrollOffsetX = scrollOffsetX;
        this.scrollOffsetY = scrollOffsetY;
        this.timestamp = null;
    }

}