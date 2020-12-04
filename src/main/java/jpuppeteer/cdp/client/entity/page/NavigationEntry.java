package jpuppeteer.cdp.client.entity.page;

/**
* Navigation history entry.
*/
public class NavigationEntry {

    /**
    * Unique id of the navigation history entry.
    */
    public final Integer id;

    /**
    * URL of the navigation history entry.
    */
    public final String url;

    /**
    * URL that the user typed in the url bar.
    */
    public final String userTypedURL;

    /**
    * Title of the navigation history entry.
    */
    public final String title;

    /**
    * Transition type.
    */
    public final String transitionType;

    public NavigationEntry(Integer id, String url, String userTypedURL, String title, String transitionType) {
        this.id = id;
        this.url = url;
        this.userTypedURL = userTypedURL;
        this.title = title;
        this.transitionType = transitionType;
    }

}