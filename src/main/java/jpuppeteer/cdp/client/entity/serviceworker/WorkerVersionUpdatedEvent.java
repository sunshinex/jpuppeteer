package jpuppeteer.cdp.client.entity.serviceworker;

/**
* experimental
*/
public class WorkerVersionUpdatedEvent {

    /**
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.serviceworker.ServiceWorkerVersion> versions;

    public WorkerVersionUpdatedEvent(java.util.List<jpuppeteer.cdp.client.entity.serviceworker.ServiceWorkerVersion> versions) {
        this.versions = versions;
    }

}