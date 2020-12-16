package jpuppeteer.cdp.client.entity.serviceworker;

/**
* ServiceWorker registration.
* experimental
*/
public class ServiceWorkerRegistration {

    /**
    */
    public final String registrationId;

    /**
    */
    public final String scopeURL;

    /**
    */
    public final Boolean isDeleted;

    public ServiceWorkerRegistration(String registrationId, String scopeURL, Boolean isDeleted) {
        this.registrationId = registrationId;
        this.scopeURL = scopeURL;
        this.isDeleted = isDeleted;
    }

}