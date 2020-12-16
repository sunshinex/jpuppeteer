package jpuppeteer.cdp.client.entity.serviceworker;

/**
* experimental
*/
public class WorkerErrorReportedEvent {

    /**
    */
    public final ServiceWorkerErrorMessage errorMessage;

    public WorkerErrorReportedEvent(ServiceWorkerErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

}