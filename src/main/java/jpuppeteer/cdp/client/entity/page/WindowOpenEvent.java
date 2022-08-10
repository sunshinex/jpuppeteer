package jpuppeteer.cdp.client.entity.page;

/**
* Fired when a new window is going to be opened, via window.open(), link click, form submission, etc.
*/
public class WindowOpenEvent {

    /**
    * The URL for the new window.
    */
    private String url;

    /**
    * Window name.
    */
    private String windowName;

    /**
    * An array of enabled window features.
    */
    private java.util.List<String> windowFeatures;

    /**
    * Whether or not it was triggered by user gesture.
    */
    private Boolean userGesture;

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setWindowName (String windowName) {
        this.windowName = windowName;
    }

    public String getWindowName() {
        return this.windowName;
    }

    public void setWindowFeatures (java.util.List<String> windowFeatures) {
        this.windowFeatures = windowFeatures;
    }

    public java.util.List<String> getWindowFeatures() {
        return this.windowFeatures;
    }

    public void setUserGesture (Boolean userGesture) {
        this.userGesture = userGesture;
    }

    public Boolean getUserGesture() {
        return this.userGesture;
    }

    public WindowOpenEvent(String url, String windowName, java.util.List<String> windowFeatures, Boolean userGesture) {
        this.url = url;
        this.windowName = windowName;
        this.windowFeatures = windowFeatures;
        this.userGesture = userGesture;
    }

    public WindowOpenEvent() {
    }

}