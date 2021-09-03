package jpuppeteer.cdp.client.entity.serviceworker;

/**
* experimental
*/
public class WorkerErrorReportedEvent {

    /**
    */
    public final jpuppeteer.cdp.client.entity.serviceworker.ServiceWorkerErrorMessage errorMessage;

    public WorkerErrorReportedEvent(jpuppeteer.cdp.client.entity.serviceworker.ServiceWorkerErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

}