package jpuppeteer.cdp.client.entity.profiler;

/**
* Profile.
*/
public class Profile {

    /**
    * The list of profile nodes. First item is the root node.
    */
    public final java.util.List<ProfileNode> nodes;

    /**
    * Profiling start timestamp in microseconds.
    */
    public final java.math.BigDecimal startTime;

    /**
    * Profiling end timestamp in microseconds.
    */
    public final java.math.BigDecimal endTime;

    /**
    * Ids of samples top nodes.
    */
    public final java.util.List<Integer> samples;

    /**
    * Time intervals between adjacent samples in microseconds. The first delta is relative to the profile startTime.
    */
    public final java.util.List<Integer> timeDeltas;

    public Profile(java.util.List<ProfileNode> nodes, java.math.BigDecimal startTime, java.math.BigDecimal endTime, java.util.List<Integer> samples, java.util.List<Integer> timeDeltas) {
        this.nodes = nodes;
        this.startTime = startTime;
        this.endTime = endTime;
        this.samples = samples;
        this.timeDeltas = timeDeltas;
    }

    public Profile(java.util.List<ProfileNode> nodes, java.math.BigDecimal startTime, java.math.BigDecimal endTime) {
        this.nodes = nodes;
        this.startTime = startTime;
        this.endTime = endTime;
        this.samples = null;
        this.timeDeltas = null;
    }

}