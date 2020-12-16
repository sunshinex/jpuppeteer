package jpuppeteer.cdp.client.entity.profiler;

/**
* Profile node. Holds callsite information, execution statistics and child nodes.
*/
public class ProfileNode {

    /**
    * Unique id of the node.
    */
    public final Integer id;

    /**
    * Function location.
    */
    public final jpuppeteer.cdp.client.entity.runtime.CallFrame callFrame;

    /**
    * Number of samples where this node was on top of the call stack.
    */
    public final Integer hitCount;

    /**
    * Child node ids.
    */
    public final java.util.List<Integer> children;

    /**
    * The reason of being not optimized. The function may be deoptimized or marked as don't optimize.
    */
    public final String deoptReason;

    /**
    * An array of source position ticks.
    */
    public final java.util.List<PositionTickInfo> positionTicks;

    public ProfileNode(Integer id, jpuppeteer.cdp.client.entity.runtime.CallFrame callFrame, Integer hitCount, java.util.List<Integer> children, String deoptReason, java.util.List<PositionTickInfo> positionTicks) {
        this.id = id;
        this.callFrame = callFrame;
        this.hitCount = hitCount;
        this.children = children;
        this.deoptReason = deoptReason;
        this.positionTicks = positionTicks;
    }

    public ProfileNode(Integer id, jpuppeteer.cdp.client.entity.runtime.CallFrame callFrame) {
        this.id = id;
        this.callFrame = callFrame;
        this.hitCount = null;
        this.children = null;
        this.deoptReason = null;
        this.positionTicks = null;
    }

}