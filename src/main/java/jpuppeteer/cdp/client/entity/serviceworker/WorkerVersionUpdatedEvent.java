package jpuppeteer.cdp.client.entity.serviceworker;

/**
* experimental
*/
public class WorkerVersionUpdatedEvent {

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.entity.serviceworker.ServiceWorkerVersion> versions;

    public void setVersions (java.util.List<jpuppeteer.cdp.client.entity.serviceworker.ServiceWorkerVersion> versions) {
        this.versions = versions;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.serviceworker.ServiceWorkerVersion> getVersions() {
        return this.versions;
    }

    public WorkerVersionUpdatedEvent(java.util.List<jpuppeteer.cdp.client.entity.serviceworker.ServiceWorkerVersion> versions) {
        this.versions = versions;
    }

    public WorkerVersionUpdatedEvent() {
    }

}