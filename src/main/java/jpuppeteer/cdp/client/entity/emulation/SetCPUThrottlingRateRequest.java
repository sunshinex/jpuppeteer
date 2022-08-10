package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetCPUThrottlingRateRequest {

    /**
    * Throttling rate as a slowdown factor (1 is no throttle, 2 is 2x slowdown, etc).
    */
    private java.math.BigDecimal rate;

    public void setRate (java.math.BigDecimal rate) {
        this.rate = rate;
    }

    public java.math.BigDecimal getRate() {
        return this.rate;
    }

    public SetCPUThrottlingRateRequest(java.math.BigDecimal rate) {
        this.rate = rate;
    }

    public SetCPUThrottlingRateRequest() {
    }

}