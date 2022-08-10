package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class AwaitPromiseRequest {

    /**
    * Identifier of the promise.
    */
    private String promiseObjectId;

    /**
    * Whether the result is expected to be a JSON object that should be sent by value.
    */
    private Boolean returnByValue;

    /**
    * Whether preview should be generated for the result.
    */
    private Boolean generatePreview;

    public void setPromiseObjectId (String promiseObjectId) {
        this.promiseObjectId = promiseObjectId;
    }

    public String getPromiseObjectId() {
        return this.promiseObjectId;
    }

    public void setReturnByValue (Boolean returnByValue) {
        this.returnByValue = returnByValue;
    }

    public Boolean getReturnByValue() {
        return this.returnByValue;
    }

    public void setGeneratePreview (Boolean generatePreview) {
        this.generatePreview = generatePreview;
    }

    public Boolean getGeneratePreview() {
        return this.generatePreview;
    }

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

    public AwaitPromiseRequest() {
    }

}