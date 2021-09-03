package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* Sampling Heap Profile node. Holds callsite information, allocation statistics and child nodes.
* experimental
*/
public class SamplingHeapProfileNode {

    /**
    * Function location.
    */
    public final jpuppeteer.cdp.client.entity.runtime.CallFrame callFrame;

    /**
    * Allocations size in bytes for the node excluding children.
    */
    public final java.math.BigDecimal selfSize;

    /**
    * Node id. Ids are unique across all profiles collected between startSampling and stopSampling.
    */
    public final Integer id;

    /**
    * Child nodes.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.heapprofiler.SamplingHeapProfileNode> children;

    public SamplingHeapProfileNode(jpuppeteer.cdp.client.entity.runtime.CallFrame callFrame, java.math.BigDecimal selfSize, Integer id, java.util.List<jpuppeteer.cdp.client.entity.heapprofiler.SamplingHeapProfileNode> children) {
        this.callFrame = callFrame;
        this.selfSize = selfSize;
        this.id = id;
        this.children = children;
    }

}