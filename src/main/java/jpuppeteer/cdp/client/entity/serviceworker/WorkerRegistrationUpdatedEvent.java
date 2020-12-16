package jpuppeteer.cdp.client.entity.serviceworker;

/**
* experimental
*/
public class WorkerRegistrationUpdatedEvent {

    /**
    */
    public final java.util.List<ServiceWorkerRegistration> registrations;

    public WorkerRegistrationUpdatedEvent(java.util.List<ServiceWorkerRegistration> registrations) {
        this.registrations = registrations;
    }

}