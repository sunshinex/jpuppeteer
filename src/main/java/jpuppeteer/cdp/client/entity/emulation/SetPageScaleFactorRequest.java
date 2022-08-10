package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetPageScaleFactorRequest {

    /**
    * Page scale factor.
    */
    private java.math.BigDecimal pageScaleFactor;

    public void setPageScaleFactor (java.math.BigDecimal pageScaleFactor) {
        this.pageScaleFactor = pageScaleFactor;
    }

    public java.math.BigDecimal getPageScaleFactor() {
        return this.pageScaleFactor;
    }

    public SetPageScaleFactorRequest(java.math.BigDecimal pageScaleFactor) {
        this.pageScaleFactor = pageScaleFactor;
    }

    public SetPageScaleFactorRequest() {
    }

}