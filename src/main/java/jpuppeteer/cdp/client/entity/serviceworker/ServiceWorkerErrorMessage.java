package jpuppeteer.cdp.client.entity.serviceworker;

/**
* ServiceWorker error message.
* experimental
*/
public class ServiceWorkerErrorMessage {

    /**
    */
    private String errorMessage;

    /**
    */
    private String registrationId;

    /**
    */
    private String versionId;

    /**
    */
    private String sourceURL;

    /**
    */
    private Integer lineNumber;

    /**
    */
    private Integer columnNumber;

    public void setErrorMessage (String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setRegistrationId (String registrationId) {
        this.registrationId = registrationId;
    }

    public String getRegistrationId() {
        return this.registrationId;
    }

    public void setVersionId (String versionId) {
        this.versionId = versionId;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public void setSourceURL (String sourceURL) {
        this.sourceURL = sourceURL;
    }

    public String getSourceURL() {
        return this.sourceURL;
    }

    public void setLineNumber (Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Integer getLineNumber() {
        return this.lineNumber;
    }

    public void setColumnNumber (Integer columnNumber) {
        this.columnNumber = columnNumber;
    }

    public Integer getColumnNumber() {
        return this.columnNumber;
    }

    public ServiceWorkerErrorMessage(String errorMessage, String registrationId, String versionId, String sourceURL, Integer lineNumber, Integer columnNumber) {
        this.errorMessage = errorMessage;
        this.registrationId = registrationId;
        this.versionId = versionId;
        this.sourceURL = sourceURL;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

    public ServiceWorkerErrorMessage() {
    }

}