package jpuppeteer.cdp.client.entity.profiler;

/**
* Profile.
*/
public class Profile {

    /**
    * The list of profile nodes. First item is the root node.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.profiler.ProfileNode> nodes;

    /**
    * Profiling start timestamp in microseconds.
    */
    private java.math.BigDecimal startTime;

    /**
    * Profiling end timestamp in microseconds.
    */
    private java.math.BigDecimal endTime;

    /**
    * Ids of samples top nodes.
    */
    private java.util.List<Integer> samples;

    /**
    * Time intervals between adjacent samples in microseconds. The first delta is relative to the profile startTime.
    */
    private java.util.List<Integer> timeDeltas;

    public void setNodes (java.util.List<jpuppeteer.cdp.client.entity.profiler.ProfileNode> nodes) {
        this.nodes = nodes;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.profiler.ProfileNode> getNodes() {
        return this.nodes;
    }

    public void setStartTime (java.math.BigDecimal startTime) {
        this.startTime = startTime;
    }

    public java.math.BigDecimal getStartTime() {
        return this.startTime;
    }

    public void setEndTime (java.math.BigDecimal endTime) {
        this.endTime = endTime;
    }

    public java.math.BigDecimal getEndTime() {
        return this.endTime;
    }

    public void setSamples (java.util.List<Integer> samples) {
        this.samples = samples;
    }

    public java.util.List<Integer> getSamples() {
        return this.samples;
    }

    public void setTimeDeltas (java.util.List<Integer> timeDeltas) {
        this.timeDeltas = timeDeltas;
    }

    public java.util.List<Integer> getTimeDeltas() {
        return this.timeDeltas;
    }

    public Profile(java.util.List<jpuppeteer.cdp.client.entity.profiler.ProfileNode> nodes, java.math.BigDecimal startTime, java.math.BigDecimal endTime, java.util.List<Integer> samples, java.util.List<Integer> timeDeltas) {
        this.nodes = nodes;
        this.startTime = startTime;
        this.endTime = endTime;
        this.samples = samples;
        this.timeDeltas = timeDeltas;
    }

    public Profile(java.util.List<jpuppeteer.cdp.client.entity.profiler.ProfileNode> nodes, java.math.BigDecimal startTime, java.math.BigDecimal endTime) {
        this.nodes = nodes;
        this.startTime = startTime;
        this.endTime = endTime;
        this.samples = null;
        this.timeDeltas = null;
    }

    public Profile() {
    }

}