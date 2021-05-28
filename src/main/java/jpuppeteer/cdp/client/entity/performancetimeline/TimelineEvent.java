package jpuppeteer.cdp.client.entity.performancetimeline;

/**
* experimental
*/
public class TimelineEvent {

    /**
    * Identifies the frame that this event is related to. Empty for non-frame targets.
    */
    public final String frameId;

    /**
    * The event type, as specified in https://w3c.github.io/performance-timeline/#dom-performanceentry-entrytype This determines which of the optional "details" fiedls is present.
    */
    public final String type;

    /**
    * Name may be empty depending on the type.
    */
    public final String name;

    /**
    * Time in seconds since Epoch, monotonically increasing within document lifetime.
    */
    public final java.math.BigDecimal time;

    /**
    * Event duration, if applicable.
    */
    public final java.math.BigDecimal duration;

    /**
    */
    public final jpuppeteer.cdp.client.entity.performancetimeline.LargestContentfulPaint lcpDetails;

    /**
    */
    public final jpuppeteer.cdp.client.entity.performancetimeline.LayoutShift layoutShiftDetails;

    public TimelineEvent(String frameId, String type, String name, java.math.BigDecimal time, java.math.BigDecimal duration, jpuppeteer.cdp.client.entity.performancetimeline.LargestContentfulPaint lcpDetails, jpuppeteer.cdp.client.entity.performancetimeline.LayoutShift layoutShiftDetails) {
        this.frameId = frameId;
        this.type = type;
        this.name = name;
        this.time = time;
        this.duration = duration;
        this.lcpDetails = lcpDetails;
        this.layoutShiftDetails = layoutShiftDetails;
    }

    public TimelineEvent(String frameId, String type, String name, java.math.BigDecimal time) {
        this.frameId = frameId;
        this.type = type;
        this.name = name;
        this.time = time;
        this.duration = null;
        this.lcpDetails = null;
        this.layoutShiftDetails = null;
    }

}