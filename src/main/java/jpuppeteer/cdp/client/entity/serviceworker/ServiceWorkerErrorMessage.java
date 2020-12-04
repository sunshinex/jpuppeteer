package jpuppeteer.cdp.client.entity.serviceworker;

/**
* ServiceWorker error message.
* experimental
*/
public class ServiceWorkerErrorMessage {

    /**
    */
    public final String errorMessage;

    /**
    */
    public final String registrationId;

    /**
    */
    public final String versionId;

    /**
    */
    public final String sourceURL;

    /**
    */
    public final Integer lineNumber;

    /**
    */
    public final Integer columnNumber;

    public ServiceWorkerErrorMessage(String errorMessage, String registrationId, String versionId, String sourceURL, Integer lineNumber, Integer columnNumber) {
        this.errorMessage = errorMessage;
        this.registrationId = registrationId;
        this.versionId = versionId;
        this.sourceURL = sourceURL;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

}