package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class AwaitPromiseResponse {

    /**
    * Promise result. Will contain rejected value if promise was rejected.
    */
    public final RemoteObject result;

    /**
    * Exception details if stack strace is available.
    */
    public final ExceptionDetails exceptionDetails;

    public AwaitPromiseResponse(RemoteObject result, ExceptionDetails exceptionDetails) {
        this.result = result;
        this.exceptionDetails = exceptionDetails;
    }

    public AwaitPromiseResponse(RemoteObject result) {
        this.result = result;
        this.exceptionDetails = null;
    }

}