package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetCPUThrottlingRateRequest {

    /**
    * Throttling rate as a slowdown factor (1 is no throttle, 2 is 2x slowdown, etc).
    */
    public final java.math.BigDecimal rate;

    public SetCPUThrottlingRateRequest(java.math.BigDecimal rate) {
        this.rate = rate;
    }

}