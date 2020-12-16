package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class SetNodeNameRequest {

    /**
    * Id of the node to set name for.
    */
    public final Integer nodeId;

    /**
    * New node's name.
    */
    public final String name;

    public SetNodeNameRequest(Integer nodeId, String name) {
        this.nodeId = nodeId;
        this.name = name;
    }

}