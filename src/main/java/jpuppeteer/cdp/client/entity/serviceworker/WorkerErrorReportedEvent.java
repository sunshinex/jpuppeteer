package jpuppeteer.cdp.client.entity.serviceworker;

/**
* experimental
*/
public class WorkerErrorReportedEvent {

    /**
    */
    private jpuppeteer.cdp.client.entity.serviceworker.ServiceWorkerErrorMessage errorMessage;

    public void setErrorMessage (jpuppeteer.cdp.client.entity.serviceworker.ServiceWorkerErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    public jpuppeteer.cdp.client.entity.serviceworker.ServiceWorkerErrorMessage getErrorMessage() {
        return this.errorMessage;
    }

    public WorkerErrorReportedEvent(jpuppeteer.cdp.client.entity.serviceworker.ServiceWorkerErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    public WorkerErrorReportedEvent() {
    }

}