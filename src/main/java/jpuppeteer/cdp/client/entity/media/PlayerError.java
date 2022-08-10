package jpuppeteer.cdp.client.entity.media;

/**
* Corresponds to kMediaError
* experimental
*/
public class PlayerError {

    /**
    */
    private jpuppeteer.cdp.client.constant.media.PlayerErrorType type;

    /**
    * When this switches to using media::Status instead of PipelineStatus we can remove "errorCode" and replace it with the fields from a Status instance. This also seems like a duplicate of the error level enum - there is a todo bug to have that level removed and use this instead. (crbug.com/1068454)
    */
    private String errorCode;

    public void setType (jpuppeteer.cdp.client.constant.media.PlayerErrorType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.media.PlayerErrorType getType() {
        return this.type;
    }

    public void setErrorCode (String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public PlayerError(jpuppeteer.cdp.client.constant.media.PlayerErrorType type, String errorCode) {
        this.type = type;
        this.errorCode = errorCode;
    }

    public PlayerError() {
    }

}