package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetVirtualTimePolicyResponse {

    /**
    * Absolute timestamp at which virtual time was first enabled (up time in milliseconds).
    */
    private java.math.BigDecimal virtualTimeTicksBase;

    public void setVirtualTimeTicksBase (java.math.BigDecimal virtualTimeTicksBase) {
        this.virtualTimeTicksBase = virtualTimeTicksBase;
    }

    public java.math.BigDecimal getVirtualTimeTicksBase() {
        return this.virtualTimeTicksBase;
    }

    public SetVirtualTimePolicyResponse(java.math.BigDecimal virtualTimeTicksBase) {
        this.virtualTimeTicksBase = virtualTimeTicksBase;
    }

    public SetVirtualTimePolicyResponse() {
    }

}