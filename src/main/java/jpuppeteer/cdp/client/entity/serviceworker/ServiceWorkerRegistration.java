package jpuppeteer.cdp.client.entity.serviceworker;

/**
* ServiceWorker registration.
* experimental
*/
public class ServiceWorkerRegistration {

    /**
    */
    private String registrationId;

    /**
    */
    private String scopeURL;

    /**
    */
    private Boolean isDeleted;

    public void setRegistrationId (String registrationId) {
        this.registrationId = registrationId;
    }

    public String getRegistrationId() {
        return this.registrationId;
    }

    public void setScopeURL (String scopeURL) {
        this.scopeURL = scopeURL;
    }

    public String getScopeURL() {
        return this.scopeURL;
    }

    public void setIsDeleted (Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Boolean getIsDeleted() {
        return this.isDeleted;
    }

    public ServiceWorkerRegistration(String registrationId, String scopeURL, Boolean isDeleted) {
        this.registrationId = registrationId;
        this.scopeURL = scopeURL;
        this.isDeleted = isDeleted;
    }

    public ServiceWorkerRegistration() {
    }

}