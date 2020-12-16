package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class CallFunctionOnResponse {

    /**
    * Call result.
    */
    public final RemoteObject result;

    /**
    * Exception details.
    */
    public final ExceptionDetails exceptionDetails;

    public CallFunctionOnResponse(RemoteObject result, ExceptionDetails exceptionDetails) {
        this.result = result;
        this.exceptionDetails = exceptionDetails;
    }

    public CallFunctionOnResponse(RemoteObject result) {
        this.result = result;
        this.exceptionDetails = null;
    }

}