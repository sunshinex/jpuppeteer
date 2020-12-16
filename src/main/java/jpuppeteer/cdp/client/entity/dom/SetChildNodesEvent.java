package jpuppeteer.cdp.client.entity.dom;

/**
* Fired when backend wants to provide client with the missing DOM structure. This happens upon most of the calls requesting node ids.
*/
public class SetChildNodesEvent {

    /**
    * Parent node id to populate with children.
    */
    public final Integer parentId;

    /**
    * Child nodes array.
    */
    public final java.util.List<Node> nodes;

    public SetChildNodesEvent(Integer parentId, java.util.List<Node> nodes) {
        this.parentId = parentId;
        this.nodes = nodes;
    }

}