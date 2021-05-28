package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class AwaitPromiseRequest {

    /**
    * Identifier of the promise.
    */
    public final String promiseObjectId;

    /**
    * Whether the result is expected to be a JSON object that should be sent by value.
    */
    public final Boolean returnByValue;

    /**
    * Whether preview should be generated for the result.
    */
    public final Boolean generatePreview;

    public AwaitPromiseRequest(String promiseObjectId, Boolean returnByValue, Boolean generatePreview) {
        this.promiseObjectId = promiseObjectId;
        this.returnByValue = returnByValue;
        this.generatePreview = generatePreview;
    }

    public AwaitPromiseRequest(String promiseObjectId) {
        this.promiseObjectId = promiseObjectId;
        this.returnByValue = null;
        this.generatePreview = null;
    }

}