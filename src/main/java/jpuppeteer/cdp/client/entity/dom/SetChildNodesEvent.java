package jpuppeteer.cdp.client.entity.dom;

/**
* Fired when backend wants to provide client with the missing DOM structure. This happens upon most of the calls requesting node ids.
*/
public class SetChildNodesEvent {

    /**
    * Parent node id to populate with children.
    */
    private Integer parentId;

    /**
    * Child nodes array.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.dom.Node> nodes;

    public void setParentId (Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public void setNodes (java.util.List<jpuppeteer.cdp.client.entity.dom.Node> nodes) {
        this.nodes = nodes;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.dom.Node> getNodes() {
        return this.nodes;
    }

    public SetChildNodesEvent(Integer parentId, java.util.List<jpuppeteer.cdp.client.entity.dom.Node> nodes) {
        this.parentId = parentId;
        this.nodes = nodes;
    }

    public SetChildNodesEvent() {
    }

}