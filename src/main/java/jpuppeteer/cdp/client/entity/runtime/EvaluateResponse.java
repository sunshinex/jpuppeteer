package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class EvaluateResponse {

    /**
    * Evaluation result.
    */
    public final RemoteObject result;

    /**
    * Exception details.
    */
    public final ExceptionDetails exceptionDetails;

    public EvaluateResponse(RemoteObject result, ExceptionDetails exceptionDetails) {
        this.result = result;
        this.exceptionDetails = exceptionDetails;
    }

    public EvaluateResponse(RemoteObject result) {
        this.result = result;
        this.exceptionDetails = null;
    }

}