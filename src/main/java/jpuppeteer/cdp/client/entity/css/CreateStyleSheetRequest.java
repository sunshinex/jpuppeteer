package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class CreateStyleSheetRequest {

    /**
    * Identifier of the frame where "via-inspector" stylesheet should be created.
    */
    private String frameId;

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public CreateStyleSheetRequest(String frameId) {
        this.frameId = frameId;
    }

    public CreateStyleSheetRequest() {
    }

}