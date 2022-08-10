package jpuppeteer.cdp.client.entity.memory;

/**
* Heap profile sample.
* experimental
*/
public class SamplingProfileNode {

    /**
    * Size of the sampled allocation.
    */
    private java.math.BigDecimal size;

    /**
    * Total bytes attributed to this sample.
    */
    private java.math.BigDecimal total;

    /**
    * Execution stack at the point of allocation.
    */
    private java.util.List<String> stack;

    public void setSize (java.math.BigDecimal size) {
        this.size = size;
    }

    public java.math.BigDecimal getSize() {
        return this.size;
    }

    public void setTotal (java.math.BigDecimal total) {
        this.total = total;
    }

    public java.math.BigDecimal getTotal() {
        return this.total;
    }

    public void setStack (java.util.List<String> stack) {
        this.stack = stack;
    }

    public java.util.List<String> getStack() {
        return this.stack;
    }

    public SamplingProfileNode(java.math.BigDecimal size, java.math.BigDecimal total, java.util.List<String> stack) {
        this.size = size;
        this.total = total;
        this.stack = stack;
    }

    public SamplingProfileNode() {
    }

}