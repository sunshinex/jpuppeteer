package jpuppeteer.cdp.client.entity.serviceworker;

/**
* experimental
*/
public class StopWorkerRequest {

    /**
    */
    private String versionId;

    public void setVersionId (String versionId) {
        this.versionId = versionId;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public StopWorkerRequest(String versionId) {
        this.versionId = versionId;
    }

    public StopWorkerRequest() {
    }

}