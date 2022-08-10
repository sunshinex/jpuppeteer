package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* Sampling Heap Profile node. Holds callsite information, allocation statistics and child nodes.
* experimental
*/
public class SamplingHeapProfileNode {

    /**
    * Function location.
    */
    private jpuppeteer.cdp.client.entity.runtime.CallFrame callFrame;

    /**
    * Allocations size in bytes for the node excluding children.
    */
    private java.math.BigDecimal selfSize;

    /**
    * Node id. Ids are unique across all profiles collected between startSampling and stopSampling.
    */
    private Integer id;

    /**
    * Child nodes.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.heapprofiler.SamplingHeapProfileNode> children;

    public void setCallFrame (jpuppeteer.cdp.client.entity.runtime.CallFrame callFrame) {
        this.callFrame = callFrame;
    }

    public jpuppeteer.cdp.client.entity.runtime.CallFrame getCallFrame() {
        return this.callFrame;
    }

    public void setSelfSize (java.math.BigDecimal selfSize) {
        this.selfSize = selfSize;
    }

    public java.math.BigDecimal getSelfSize() {
        return this.selfSize;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setChildren (java.util.List<jpuppeteer.cdp.client.entity.heapprofiler.SamplingHeapProfileNode> children) {
        this.children = children;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.heapprofiler.SamplingHeapProfileNode> getChildren() {
        return this.children;
    }

    public SamplingHeapProfileNode(jpuppeteer.cdp.client.entity.runtime.CallFrame callFrame, java.math.BigDecimal selfSize, Integer id, java.util.List<jpuppeteer.cdp.client.entity.heapprofiler.SamplingHeapProfileNode> children) {
        this.callFrame = callFrame;
        this.selfSize = selfSize;
        this.id = id;
        this.children = children;
    }

    public SamplingHeapProfileNode() {
    }

}