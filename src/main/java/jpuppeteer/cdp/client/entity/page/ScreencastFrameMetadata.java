package jpuppeteer.cdp.client.entity.page;

/**
* Screencast frame metadata.
*/
public class ScreencastFrameMetadata {

    /**
    * Top offset in DIP.
    */
    private java.math.BigDecimal offsetTop;

    /**
    * Page scale factor.
    */
    private java.math.BigDecimal pageScaleFactor;

    /**
    * Device screen width in DIP.
    */
    private java.math.BigDecimal deviceWidth;

    /**
    * Device screen height in DIP.
    */
    private java.math.BigDecimal deviceHeight;

    /**
    * Position of horizontal scroll in CSS pixels.
    */
    private java.math.BigDecimal scrollOffsetX;

    /**
    * Position of vertical scroll in CSS pixels.
    */
    private java.math.BigDecimal scrollOffsetY;

    /**
    * Frame swap timestamp.
    */
    private java.math.BigDecimal timestamp;

    public void setOffsetTop (java.math.BigDecimal offsetTop) {
        this.offsetTop = offsetTop;
    }

    public java.math.BigDecimal getOffsetTop() {
        return this.offsetTop;
    }

    public void setPageScaleFactor (java.math.BigDecimal pageScaleFactor) {
        this.pageScaleFactor = pageScaleFactor;
    }

    public java.math.BigDecimal getPageScaleFactor() {
        return this.pageScaleFactor;
    }

    public void setDeviceWidth (java.math.BigDecimal deviceWidth) {
        this.deviceWidth = deviceWidth;
    }

    public java.math.BigDecimal getDeviceWidth() {
        return this.deviceWidth;
    }

    public void setDeviceHeight (java.math.BigDecimal deviceHeight) {
        this.deviceHeight = deviceHeight;
    }

    public java.math.BigDecimal getDeviceHeight() {
        return this.deviceHeight;
    }

    public void setScrollOffsetX (java.math.BigDecimal scrollOffsetX) {
        this.scrollOffsetX = scrollOffsetX;
    }

    public java.math.BigDecimal getScrollOffsetX() {
        return this.scrollOffsetX;
    }

    public void setScrollOffsetY (java.math.BigDecimal scrollOffsetY) {
        this.scrollOffsetY = scrollOffsetY;
    }

    public java.math.BigDecimal getScrollOffsetY() {
        return this.scrollOffsetY;
    }

    public void setTimestamp (java.math.BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public java.math.BigDecimal getTimestamp() {
        return this.timestamp;
    }

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

    public ScreencastFrameMetadata() {
    }

}