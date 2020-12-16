package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* A single sample from a sampling profile.
* experimental
*/
public class SamplingHeapProfileSample {

    /**
    * Allocation size in bytes attributed to the sample.
    */
    public final java.math.BigDecimal size;

    /**
    * Id of the corresponding profile tree node.
    */
    public final Integer nodeId;

    /**
    * Time-ordered sample ordinal number. It is unique across all profiles retrieved between startSampling and stopSampling.
    */
    public final java.math.BigDecimal ordinal;

    public SamplingHeapProfileSample(java.math.BigDecimal size, Integer nodeId, java.math.BigDecimal ordinal) {
        this.size = size;
        this.nodeId = nodeId;
        this.ordinal = ordinal;
    }

}