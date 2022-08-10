package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class SetFileInputFilesRequest {

    /**
    * Array of file paths to set.
    */
    private java.util.List<String> files;

    /**
    * Identifier of the node.
    */
    private Integer nodeId;

    /**
    * Identifier of the backend node.
    */
    private Integer backendNodeId;

    /**
    * JavaScript object id of the node wrapper.
    */
    private String objectId;

    public void setFiles (java.util.List<String> files) {
        this.files = files;
    }

    public java.util.List<String> getFiles() {
        return this.files;
    }

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public void setBackendNodeId (Integer backendNodeId) {
        this.backendNodeId = backendNodeId;
    }

    public Integer getBackendNodeId() {
        return this.backendNodeId;
    }

    public void setObjectId (String objectId) {
        this.objectId = objectId;
    }

    public String getObjectId() {
        return this.objectId;
    }

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

    public SetFileInputFilesRequest() {
    }

}