package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class RunScriptResponse {

    /**
    * Run result.
    */
    public final RemoteObject result;

    /**
    * Exception details.
    */
    public final ExceptionDetails exceptionDetails;

    public RunScriptResponse(RemoteObject result, ExceptionDetails exceptionDetails) {
        this.result = result;
        this.exceptionDetails = exceptionDetails;
    }

    public RunScriptResponse(RemoteObject result) {
        this.result = result;
        this.exceptionDetails = null;
    }

}