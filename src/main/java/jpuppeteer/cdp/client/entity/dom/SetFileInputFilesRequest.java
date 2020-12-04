package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class SetFileInputFilesRequest {

    /**
    * Array of file paths to set.
    */
    public final java.util.List<String> files;

    /**
    * Identifier of the node.
    */
    public final Integer nodeId;

    /**
    * Identifier of the backend node.
    */
    public final Integer backendNodeId;

    /**
    * JavaScript object id of the node wrapper.
    */
    public final String objectId;

    public SetFileInputFilesRequest(java.util.List<String> files, Integer nodeId, Integer backendNodeId, String objectId) {
        this.files = files;
        this.nodeId = nodeId;
        this.backendNodeId = backendNodeId;
        this.objectId = objectId;
    }

    public SetFileInputFilesRequest(java.util.List<String> files) {
        this.files = files;
        this.nodeId = null;
        this.backendNodeId = null;
        this.objectId = null;
    }

}