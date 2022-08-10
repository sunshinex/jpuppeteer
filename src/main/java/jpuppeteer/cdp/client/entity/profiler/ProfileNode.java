package jpuppeteer.cdp.client.entity.profiler;

/**
* Profile node. Holds callsite information, execution statistics and child nodes.
*/
public class ProfileNode {

    /**
    * Unique id of the node.
    */
    private Integer id;

    /**
    * Function location.
    */
    private jpuppeteer.cdp.client.entity.runtime.CallFrame callFrame;

    /**
    * Number of samples where this node was on top of the call stack.
    */
    private Integer hitCount;

    /**
    * Child node ids.
    */
    private java.util.List<Integer> children;

    /**
    * The reason of being not optimized. The function may be deoptimized or marked as don't optimize.
    */
    private String deoptReason;

    /**
    * An array of source position ticks.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.profiler.PositionTickInfo> positionTicks;

    public void setId (Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setCallFrame (jpuppeteer.cdp.client.entity.runtime.CallFrame callFrame) {
        this.callFrame = callFrame;
    }

    public jpuppeteer.cdp.client.entity.runtime.CallFrame getCallFrame() {
        return this.callFrame;
    }

    public void setHitCount (Integer hitCount) {
        this.hitCount = hitCount;
    }

    public Integer getHitCount() {
        return this.hitCount;
    }

    public void setChildren (java.util.List<Integer> children) {
        this.children = children;
    }

    public java.util.List<Integer> getChildren() {
        return this.children;
    }

    public void setDeoptReason (String deoptReason) {
        this.deoptReason = deoptReason;
    }

    public String getDeoptReason() {
        return this.deoptReason;
    }

    public void setPositionTicks (java.util.List<jpuppeteer.cdp.client.entity.profiler.PositionTickInfo> positionTicks) {
        this.positionTicks = positionTicks;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.profiler.PositionTickInfo> getPositionTicks() {
        return this.positionTicks;
    }

    public ProfileNode(Integer id, jpuppeteer.cdp.client.entity.runtime.CallFrame callFrame, Integer hitCount, java.util.List<Integer> children, String deoptReason, java.util.List<jpuppeteer.cdp.client.entity.profiler.PositionTickInfo> positionTicks) {
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

    public ProfileNode() {
    }

}