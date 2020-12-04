package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class SetInspectedNodeRequest {

    /**
    * DOM node id to be accessible by means of $x command line API.
    */
    public final Integer nodeId;

    public SetInspectedNodeRequest(Integer nodeId) {
        this.nodeId = nodeId;
    }

}