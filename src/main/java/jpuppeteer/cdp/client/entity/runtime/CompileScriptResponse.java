package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class CompileScriptResponse {

    /**
    * Id of the script.
    */
    private String scriptId;

    /**
    * Exception details.
    */
    private jpuppeteer.cdp.client.entity.runtime.ExceptionDetails exceptionDetails;

    public void setScriptId (String scriptId) {
        this.scriptId = scriptId;
    }

    public String getScriptId() {
        return this.scriptId;
    }

    public void setExceptionDetails (jpuppeteer.cdp.client.entity.runtime.ExceptionDetails exceptionDetails) {
        this.exceptionDetails = exceptionDetails;
    }

    public jpuppeteer.cdp.client.entity.runtime.ExceptionDetails getExceptionDetails() {
        return this.exceptionDetails;
    }

    public CompileScriptResponse(String scriptId, jpuppeteer.cdp.client.entity.runtime.ExceptionDetails exceptionDetails) {
        this.scriptId = scriptId;
        this.exceptionDetails = exceptionDetails;
    }

    public CompileScriptResponse() {
        this.scriptId = null;
        this.exceptionDetails = null;
    }

}