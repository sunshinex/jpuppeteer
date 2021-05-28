package jpuppeteer.cdp.client.entity.page;

/**
*/
public class NavigateResponse {

    /**
    * Frame id that has navigated (or failed to navigate)
    */
    public final String frameId;

    /**
    * Loader identifier.
    */
    public final String loaderId;

    /**
    * User friendly error message, present if and only if navigation has failed.
    */
    public final String errorText;

    public NavigateResponse(String frameId, String loaderId, String errorText) {
        this.frameId = frameId;
        this.loaderId = loaderId;
        this.errorText = errorText;
    }

    public NavigateResponse(String frameId) {
        this.frameId = frameId;
        this.loaderId = null;
        this.errorText = null;
    }

}