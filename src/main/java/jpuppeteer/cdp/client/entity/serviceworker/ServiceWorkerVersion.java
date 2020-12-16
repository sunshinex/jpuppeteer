package jpuppeteer.cdp.client.entity.serviceworker;

/**
* ServiceWorker version.
* experimental
*/
public class ServiceWorkerVersion {

    /**
    */
    public final String versionId;

    /**
    */
    public final String registrationId;

    /**
    */
    public final String scriptURL;

    /**
    */
    public final jpuppeteer.cdp.client.constant.serviceworker.ServiceWorkerVersionRunningStatus runningStatus;

    /**
    */
    public final jpuppeteer.cdp.client.constant.serviceworker.ServiceWorkerVersionStatus status;

    /**
    * The Last-Modified header value of the main script.
    */
    public final java.math.BigDecimal scriptLastModified;

    /**
    * The time at which the response headers of the main script were received from the server. For cached script it is the last time the cache entry was validated.
    */
    public final java.math.BigDecimal scriptResponseTime;

    /**
    */
    public final java.util.List<String> controlledClients;

    /**
    */
    public final String targetId;

    public ServiceWorkerVersion(String versionId, String registrationId, String scriptURL, jpuppeteer.cdp.client.constant.serviceworker.ServiceWorkerVersionRunningStatus runningStatus, jpuppeteer.cdp.client.constant.serviceworker.ServiceWorkerVersionStatus status, java.math.BigDecimal scriptLastModified, java.math.BigDecimal scriptResponseTime, java.util.List<String> controlledClients, String targetId) {
        this.versionId = versionId;
        this.registrationId = registrationId;
        this.scriptURL = scriptURL;
        this.runningStatus = runningStatus;
        this.status = status;
        this.scriptLastModified = scriptLastModified;
        this.scriptResponseTime = scriptResponseTime;
        this.controlledClients = controlledClients;
        this.targetId = targetId;
    }

    public ServiceWorkerVersion(String versionId, String registrationId, String scriptURL, jpuppeteer.cdp.client.constant.serviceworker.ServiceWorkerVersionRunningStatus runningStatus, jpuppeteer.cdp.client.constant.serviceworker.ServiceWorkerVersionStatus status) {
        this.versionId = versionId;
        this.registrationId = registrationId;
        this.scriptURL = scriptURL;
        this.runningStatus = runningStatus;
        this.status = status;
        this.scriptLastModified = null;
        this.scriptResponseTime = null;
        this.controlledClients = null;
        this.targetId = null;
    }

}