package jpuppeteer.cdp.client.entity.page;

/**
* Fired when a new window is going to be opened, via window.open(), link click, form submission, etc.
*/
public class WindowOpenEvent {

    /**
    * The URL for the new window.
    */
    public final String url;

    /**
    * Window name.
    */
    public final String windowName;

    /**
    * An array of enabled window features.
    */
    public final java.util.List<String> windowFeatures;

    /**
    * Whether or not it was triggered by user gesture.
    */
    public final Boolean userGesture;

    public WindowOpenEvent(String url, String windowName, java.util.List<String> windowFeatures, Boolean userGesture) {
        this.url = url;
        this.windowName = windowName;
        this.windowFeatures = windowFeatures;
        this.userGesture = userGesture;
    }

}