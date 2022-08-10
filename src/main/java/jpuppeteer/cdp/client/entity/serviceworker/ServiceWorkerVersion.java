package jpuppeteer.cdp.client.entity.serviceworker;

/**
* ServiceWorker version.
* experimental
*/
public class ServiceWorkerVersion {

    /**
    */
    private String versionId;

    /**
    */
    private String registrationId;

    /**
    */
    private String scriptURL;

    /**
    */
    private jpuppeteer.cdp.client.constant.serviceworker.ServiceWorkerVersionRunningStatus runningStatus;

    /**
    */
    private jpuppeteer.cdp.client.constant.serviceworker.ServiceWorkerVersionStatus status;

    /**
    * The Last-Modified header value of the main script.
    */
    private java.math.BigDecimal scriptLastModified;

    /**
    * The time at which the response headers of the main script were received from the server. For cached script it is the last time the cache entry was validated.
    */
    private java.math.BigDecimal scriptResponseTime;

    /**
    */
    private java.util.List<String> controlledClients;

    /**
    */
    private String targetId;

    public void setVersionId (String versionId) {
        this.versionId = versionId;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public void setRegistrationId (String registrationId) {
        this.registrationId = registrationId;
    }

    public String getRegistrationId() {
        return this.registrationId;
    }

    public void setScriptURL (String scriptURL) {
        this.scriptURL = scriptURL;
    }

    public String getScriptURL() {
        return this.scriptURL;
    }

    public void setRunningStatus (jpuppeteer.cdp.client.constant.serviceworker.ServiceWorkerVersionRunningStatus runningStatus) {
        this.runningStatus = runningStatus;
    }

    public jpuppeteer.cdp.client.constant.serviceworker.ServiceWorkerVersionRunningStatus getRunningStatus() {
        return this.runningStatus;
    }

    public void setStatus (jpuppeteer.cdp.client.constant.serviceworker.ServiceWorkerVersionStatus status) {
        this.status = status;
    }

    public jpuppeteer.cdp.client.constant.serviceworker.ServiceWorkerVersionStatus getStatus() {
        return this.status;
    }

    public void setScriptLastModified (java.math.BigDecimal scriptLastModified) {
        this.scriptLastModified = scriptLastModified;
    }

    public java.math.BigDecimal getScriptLastModified() {
        return this.scriptLastModified;
    }

    public void setScriptResponseTime (java.math.BigDecimal scriptResponseTime) {
        this.scriptResponseTime = scriptResponseTime;
    }

    public java.math.BigDecimal getScriptResponseTime() {
        return this.scriptResponseTime;
    }

    public void setControlledClients (java.util.List<String> controlledClients) {
        this.controlledClients = controlledClients;
    }

    public java.util.List<String> getControlledClients() {
        return this.controlledClients;
    }

    public void setTargetId (String targetId) {
        this.targetId = targetId;
    }

    public String getTargetId() {
        return this.targetId;
    }

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

    public ServiceWorkerVersion() {
    }

}