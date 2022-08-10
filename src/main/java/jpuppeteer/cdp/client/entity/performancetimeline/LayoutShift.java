package jpuppeteer.cdp.client.entity.performancetimeline;

/**
* See https://wicg.github.io/layout-instability/#sec-layout-shift and layout_shift.idl
* experimental
*/
public class LayoutShift {

    /**
    * Score increment produced by this event.
    */
    private java.math.BigDecimal value;

    /**
    */
    private Boolean hadRecentInput;

    /**
    */
    private java.math.BigDecimal lastInputTime;

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.entity.performancetimeline.LayoutShiftAttribution> sources;

    public void setValue (java.math.BigDecimal value) {
        this.value = value;
    }

    public java.math.BigDecimal getValue() {
        return this.value;
    }

    public void setHadRecentInput (Boolean hadRecentInput) {
        this.hadRecentInput = hadRecentInput;
    }

    public Boolean getHadRecentInput() {
        return this.hadRecentInput;
    }

    public void setLastInputTime (java.math.BigDecimal lastInputTime) {
        this.lastInputTime = lastInputTime;
    }

    public java.math.BigDecimal getLastInputTime() {
        return this.lastInputTime;
    }

    public void setSources (java.util.List<jpuppeteer.cdp.client.entity.performancetimeline.LayoutShiftAttribution> sources) {
        this.sources = sources;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.performancetimeline.LayoutShiftAttribution> getSources() {
        return this.sources;
    }

    public LayoutShift(java.math.BigDecimal value, Boolean hadRecentInput, java.math.BigDecimal lastInputTime, java.util.List<jpuppeteer.cdp.client.entity.performancetimeline.LayoutShiftAttribution> sources) {
        this.value = value;
        this.hadRecentInput = hadRecentInput;
        this.lastInputTime = lastInputTime;
        this.sources = sources;
    }

    public LayoutShift() {
    }

}