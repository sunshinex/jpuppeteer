package jpuppeteer.cdp.client.entity.serviceworker;

/**
* experimental
*/
public class WorkerVersionUpdatedEvent {

    /**
    */
    public final java.util.List<ServiceWorkerVersion> versions;

    public WorkerVersionUpdatedEvent(java.util.List<ServiceWorkerVersion> versions) {
        this.versions = versions;
    }

}