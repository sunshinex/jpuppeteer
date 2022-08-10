package jpuppeteer.cdp.client.entity.page;

/**
*/
public class NavigateResponse {

    /**
    * Frame id that has navigated (or failed to navigate)
    */
    private String frameId;

    /**
    * Loader identifier.
    */
    private String loaderId;

    /**
    * User friendly error message, present if and only if navigation has failed.
    */
    private String errorText;

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public void setLoaderId (String loaderId) {
        this.loaderId = loaderId;
    }

    public String getLoaderId() {
        return this.loaderId;
    }

    public void setErrorText (String errorText) {
        this.errorText = errorText;
    }

    public String getErrorText() {
        return this.errorText;
    }

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

    public NavigateResponse() {
    }

}