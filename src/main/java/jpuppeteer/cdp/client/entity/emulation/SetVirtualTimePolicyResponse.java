package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetVirtualTimePolicyResponse {

    /**
    * Absolute timestamp at which virtual time was first enabled (up time in milliseconds).
    */
    public final java.math.BigDecimal virtualTimeTicksBase;

    public SetVirtualTimePolicyResponse(java.math.BigDecimal virtualTimeTicksBase) {
        this.virtualTimeTicksBase = virtualTimeTicksBase;
    }

}