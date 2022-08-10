package jpuppeteer.cdp.client.entity.serviceworker;

/**
* experimental
*/
public class InspectWorkerRequest {

    /**
    */
    private String versionId;

    public void setVersionId (String versionId) {
        this.versionId = versionId;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public InspectWorkerRequest(String versionId) {
        this.versionId = versionId;
    }

    public InspectWorkerRequest() {
    }

}