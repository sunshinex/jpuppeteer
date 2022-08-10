package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* A single sample from a sampling profile.
* experimental
*/
public class SamplingHeapProfileSample {

    /**
    * Allocation size in bytes attributed to the sample.
    */
    private java.math.BigDecimal size;

    /**
    * Id of the corresponding profile tree node.
    */
    private Integer nodeId;

    /**
    * Time-ordered sample ordinal number. It is unique across all profiles retrieved between startSampling and stopSampling.
    */
    private java.math.BigDecimal ordinal;

    public void setSize (java.math.BigDecimal size) {
        this.size = size;
    }

    public java.math.BigDecimal getSize() {
        return this.size;
    }

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public void setOrdinal (java.math.BigDecimal ordinal) {
        this.ordinal = ordinal;
    }

    public java.math.BigDecimal getOrdinal() {
        return this.ordinal;
    }

    public SamplingHeapProfileSample(java.math.BigDecimal size, Integer nodeId, java.math.BigDecimal ordinal) {
        this.size = size;
        this.nodeId = nodeId;
        this.ordinal = ordinal;
    }

    public SamplingHeapProfileSample() {
    }

}