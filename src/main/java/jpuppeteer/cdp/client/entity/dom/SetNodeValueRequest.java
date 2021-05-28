package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class SetNodeValueRequest {

    /**
    * Id of the node to set value for.
    */
    public final Integer nodeId;

    /**
    * New node's value.
    */
    public final String value;

    public SetNodeValueRequest(Integer nodeId, String value) {
        this.nodeId = nodeId;
        this.value = value;
    }

}