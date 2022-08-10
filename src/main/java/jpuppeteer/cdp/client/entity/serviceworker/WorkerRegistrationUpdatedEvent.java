package jpuppeteer.cdp.client.entity.serviceworker;

/**
* experimental
*/
public class WorkerRegistrationUpdatedEvent {

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.entity.serviceworker.ServiceWorkerRegistration> registrations;

    public void setRegistrations (java.util.List<jpuppeteer.cdp.client.entity.serviceworker.ServiceWorkerRegistration> registrations) {
        this.registrations = registrations;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.serviceworker.ServiceWorkerRegistration> getRegistrations() {
        return this.registrations;
    }

    public WorkerRegistrationUpdatedEvent(java.util.List<jpuppeteer.cdp.client.entity.serviceworker.ServiceWorkerRegistration> registrations) {
        this.registrations = registrations;
    }

    public WorkerRegistrationUpdatedEvent() {
    }

}