package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class RunScriptResponse {

    /**
    * Run result.
    */
    public final jpuppeteer.cdp.client.entity.runtime.RemoteObject result;

    /**
    * Exception details.
    */
    public final jpuppeteer.cdp.client.entity.runtime.ExceptionDetails exceptionDetails;

    public RunScriptResponse(jpuppeteer.cdp.client.entity.runtime.RemoteObject result, jpuppeteer.cdp.client.entity.runtime.ExceptionDetails exceptionDetails) {
        this.result = result;
        this.exceptionDetails = exceptionDetails;
    }

    public RunScriptResponse(jpuppeteer.cdp.client.entity.runtime.RemoteObject result) {
        this.result = result;
        this.exceptionDetails = null;
    }

}