package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class CallFunctionOnResponse {

    /**
    * Call result.
    */
    private jpuppeteer.cdp.client.entity.runtime.RemoteObject result;

    /**
    * Exception details.
    */
    private jpuppeteer.cdp.client.entity.runtime.ExceptionDetails exceptionDetails;

    public void setResult (jpuppeteer.cdp.client.entity.runtime.RemoteObject result) {
        this.result = result;
    }

    public jpuppeteer.cdp.client.entity.runtime.RemoteObject getResult() {
        return this.result;
    }

    public void setExceptionDetails (jpuppeteer.cdp.client.entity.runtime.ExceptionDetails exceptionDetails) {
        this.exceptionDetails = exceptionDetails;
    }

    public jpuppeteer.cdp.client.entity.runtime.ExceptionDetails getExceptionDetails() {
        return this.exceptionDetails;
    }

    public CallFunctionOnResponse(jpuppeteer.cdp.client.entity.runtime.RemoteObject result, jpuppeteer.cdp.client.entity.runtime.ExceptionDetails exceptionDetails) {
        this.result = result;
        this.exceptionDetails = exceptionDetails;
    }

    public CallFunctionOnResponse(jpuppeteer.cdp.client.entity.runtime.RemoteObject result) {
        this.result = result;
        this.exceptionDetails = null;
    }

    public CallFunctionOnResponse() {
    }

}