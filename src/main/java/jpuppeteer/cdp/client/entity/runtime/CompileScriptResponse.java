package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class CompileScriptResponse {

    /**
    * Id of the script.
    */
    public final String scriptId;

    /**
    * Exception details.
    */
    public final ExceptionDetails exceptionDetails;

    public CompileScriptResponse(String scriptId, ExceptionDetails exceptionDetails) {
        this.scriptId = scriptId;
        this.exceptionDetails = exceptionDetails;
    }

    public CompileScriptResponse() {
        this.scriptId = null;
        this.exceptionDetails = null;
    }

}