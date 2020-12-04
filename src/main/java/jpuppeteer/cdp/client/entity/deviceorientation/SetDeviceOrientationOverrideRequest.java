package jpuppeteer.cdp.client.entity.deviceorientation;

/**
* experimental
*/
public class SetDeviceOrientationOverrideRequest {

    /**
    * Mock alpha
    */
    public final java.math.BigDecimal alpha;

    /**
    * Mock beta
    */
    public final java.math.BigDecimal beta;

    /**
    * Mock gamma
    */
    public final java.math.BigDecimal gamma;

    public SetDeviceOrientationOverrideRequest(java.math.BigDecimal alpha, java.math.BigDecimal beta, java.math.BigDecimal gamma) {
        this.alpha = alpha;
        this.beta = beta;
        this.gamma = gamma;
    }

}