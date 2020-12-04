package jpuppeteer.cdp.client.entity.memory;

/**
* Heap profile sample.
* experimental
*/
public class SamplingProfileNode {

    /**
    * Size of the sampled allocation.
    */
    public final java.math.BigDecimal size;

    /**
    * Total bytes attributed to this sample.
    */
    public final java.math.BigDecimal total;

    /**
    * Execution stack at the point of allocation.
    */
    public final java.util.List<String> stack;

    public SamplingProfileNode(java.math.BigDecimal size, java.math.BigDecimal total, java.util.List<String> stack) {
        this.size = size;
        this.total = total;
        this.stack = stack;
    }

}