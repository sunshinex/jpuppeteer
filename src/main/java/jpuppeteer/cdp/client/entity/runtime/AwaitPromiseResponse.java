package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class AwaitPromiseResponse {

    /**
    * Promise result. Will contain rejected value if promise was rejected.
    */
    public final jpuppeteer.cdp.client.entity.runtime.RemoteObject result;

    /**
    * Exception details if stack strace is available.
    */
    public final jpuppeteer.cdp.client.entity.runtime.ExceptionDetails exceptionDetails;

    public AwaitPromiseResponse(jpuppeteer.cdp.client.entity.runtime.RemoteObject result, jpuppeteer.cdp.client.entity.runtime.ExceptionDetails exceptionDetails) {
        this.result = result;
        this.exceptionDetails = exceptionDetails;
    }

    public AwaitPromiseResponse(jpuppeteer.cdp.client.entity.runtime.RemoteObject result) {
        this.result = result;
        this.exceptionDetails = null;
    }

}