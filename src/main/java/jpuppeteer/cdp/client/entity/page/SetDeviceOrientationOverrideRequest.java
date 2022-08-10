package jpuppeteer.cdp.client.entity.page;

/**
*/
public class SetDeviceOrientationOverrideRequest {

    /**
    * Mock alpha
    */
    private java.math.BigDecimal alpha;

    /**
    * Mock beta
    */
    private java.math.BigDecimal beta;

    /**
    * Mock gamma
    */
    private java.math.BigDecimal gamma;

    public void setAlpha (java.math.BigDecimal alpha) {
        this.alpha = alpha;
    }

    public java.math.BigDecimal getAlpha() {
        return this.alpha;
    }

    public void setBeta (java.math.BigDecimal beta) {
        this.beta = beta;
    }

    public java.math.BigDecimal getBeta() {
        return this.beta;
    }

    public void setGamma (java.math.BigDecimal gamma) {
        this.gamma = gamma;
    }

    public java.math.BigDecimal getGamma() {
        return this.gamma;
    }

    public SetDeviceOrientationOverrideRequest(java.math.BigDecimal alpha, java.math.BigDecimal beta, java.math.BigDecimal gamma) {
        this.alpha = alpha;
        this.beta = beta;
        this.gamma = gamma;
    }

    public SetDeviceOrientationOverrideRequest() {
    }

}