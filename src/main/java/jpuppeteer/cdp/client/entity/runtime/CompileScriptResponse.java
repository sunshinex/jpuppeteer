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
    public final jpuppeteer.cdp.client.entity.runtime.ExceptionDetails exceptionDetails;

    public CompileScriptResponse(String scriptId, jpuppeteer.cdp.client.entity.runtime.ExceptionDetails exceptionDetails) {
        this.scriptId = scriptId;
        this.exceptionDetails = exceptionDetails;
    }

    public CompileScriptResponse() {
        this.scriptId = null;
        this.exceptionDetails = null;
    }

}