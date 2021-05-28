package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class CreateStyleSheetRequest {

    /**
    * Identifier of the frame where "via-inspector" stylesheet should be created.
    */
    public final String frameId;

    public CreateStyleSheetRequest(String frameId) {
        this.frameId = frameId;
    }

}