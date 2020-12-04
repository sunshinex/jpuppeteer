package jpuppeteer.cdp.client.entity.serviceworker;

/**
* experimental
*/
public class WorkerRegistrationUpdatedEvent {

    /**
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.serviceworker.ServiceWorkerRegistration> registrations;

    public WorkerRegistrationUpdatedEvent(java.util.List<jpuppeteer.cdp.client.entity.serviceworker.ServiceWorkerRegistration> registrations) {
        this.registrations = registrations;
    }

}