package jpuppeteer.cdp.client.entity.performancetimeline;

/**
* See https://wicg.github.io/layout-instability/#sec-layout-shift and layout_shift.idl
* experimental
*/
public class LayoutShift {

    /**
    * Score increment produced by this event.
    */
    public final java.math.BigDecimal value;

    /**
    */
    public final Boolean hadRecentInput;

    /**
    */
    public final java.math.BigDecimal lastInputTime;

    /**
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.performancetimeline.LayoutShiftAttribution> sources;

    public LayoutShift(java.math.BigDecimal value, Boolean hadRecentInput, java.math.BigDecimal lastInputTime, java.util.List<jpuppeteer.cdp.client.entity.performancetimeline.LayoutShiftAttribution> sources) {
        this.value = value;
        this.hadRecentInput = hadRecentInput;
        this.lastInputTime = lastInputTime;
        this.sources = sources;
    }

}