package jpuppeteer.cdp.client.entity.media;

/**
* Have one type per entry in MediaLogRecord::Type Corresponds to kMessage
* experimental
*/
public class PlayerMessage {

    /**
    * Keep in sync with MediaLogMessageLevel We are currently keeping the message level 'error' separate from the PlayerError type because right now they represent different things, this one being a DVLOG(ERROR) style log message that gets printed based on what log level is selected in the UI, and the other is a representation of a media::PipelineStatus object. Soon however we're going to be moving away from using PipelineStatus for errors and introducing a new error type which should hopefully let us integrate the error log level into the PlayerError type.
    */
    private jpuppeteer.cdp.client.constant.media.PlayerMessageLevel level;

    /**
    */
    private String message;

    public void setLevel (jpuppeteer.cdp.client.constant.media.PlayerMessageLevel level) {
        this.level = level;
    }

    public jpuppeteer.cdp.client.constant.media.PlayerMessageLevel getLevel() {
        return this.level;
    }

    public void setMessage (String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public PlayerMessage(jpuppeteer.cdp.client.constant.media.PlayerMessageLevel level, String message) {
        this.level = level;
        this.message = message;
    }

    public PlayerMessage() {
    }

}