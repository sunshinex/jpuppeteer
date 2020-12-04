package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class RemoveAttributeRequest {

    /**
    * Id of the element to remove attribute from.
    */
    public final Integer nodeId;

    /**
    * Name of the attribute to remove.
    */
    public final String name;

    public RemoveAttributeRequest(Integer nodeId, String name) {
        this.nodeId = nodeId;
        this.name = name;
    }

}