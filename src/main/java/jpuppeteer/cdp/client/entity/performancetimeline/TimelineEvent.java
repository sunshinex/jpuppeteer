package jpuppeteer.cdp.client.entity.performancetimeline;

/**
* experimental
*/
public class TimelineEvent {

    /**
    * Identifies the frame that this event is related to. Empty for non-frame targets.
    */
    private String frameId;

    /**
    * The event type, as specified in https://w3c.github.io/performance-timeline/#dom-performanceentry-entrytype This determines which of the optional "details" fiedls is present.
    */
    private String type;

    /**
    * Name may be empty depending on the type.
    */
    private String name;

    /**
    * Time in seconds since Epoch, monotonically increasing within document lifetime.
    */
    private java.math.BigDecimal time;

    /**
    * Event duration, if applicable.
    */
    private java.math.BigDecimal duration;

    /**
    */
    private jpuppeteer.cdp.client.entity.performancetimeline.LargestContentfulPaint lcpDetails;

    /**
    */
    private jpuppeteer.cdp.client.entity.performancetimeline.LayoutShift layoutShiftDetails;

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public void setType (String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setTime (java.math.BigDecimal time) {
        this.time = time;
    }

    public java.math.BigDecimal getTime() {
        return this.time;
    }

    public void setDuration (java.math.BigDecimal duration) {
        this.duration = duration;
    }

    public java.math.BigDecimal getDuration() {
        return this.duration;
    }

    public void setLcpDetails (jpuppeteer.cdp.client.entity.performancetimeline.LargestContentfulPaint lcpDetails) {
        this.lcpDetails = lcpDetails;
    }

    public jpuppeteer.cdp.client.entity.performancetimeline.LargestContentfulPaint getLcpDetails() {
        return this.lcpDetails;
    }

    public void setLayoutShiftDetails (jpuppeteer.cdp.client.entity.performancetimeline.LayoutShift layoutShiftDetails) {
        this.layoutShiftDetails = layoutShiftDetails;
    }

    public jpuppeteer.cdp.client.entity.performancetimeline.LayoutShift getLayoutShiftDetails() {
        return this.layoutShiftDetails;
    }

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

    public TimelineEvent() {
    }

}