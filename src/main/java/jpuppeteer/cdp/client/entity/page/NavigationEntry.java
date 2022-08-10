package jpuppeteer.cdp.client.entity.page;

/**
* Navigation history entry.
*/
public class NavigationEntry {

    /**
    * Unique id of the navigation history entry.
    */
    private Integer id;

    /**
    * URL of the navigation history entry.
    */
    private String url;

    /**
    * URL that the user typed in the url bar.
    */
    private String userTypedURL;

    /**
    * Title of the navigation history entry.
    */
    private String title;

    /**
    * Transition type.
    */
    private jpuppeteer.cdp.client.constant.page.TransitionType transitionType;

    public void setId (Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUserTypedURL (String userTypedURL) {
        this.userTypedURL = userTypedURL;
    }

    public String getUserTypedURL() {
        return this.userTypedURL;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTransitionType (jpuppeteer.cdp.client.constant.page.TransitionType transitionType) {
        this.transitionType = transitionType;
    }

    public jpuppeteer.cdp.client.constant.page.TransitionType getTransitionType() {
        return this.transitionType;
    }

    public NavigationEntry(Integer id, String url, String userTypedURL, String title, jpuppeteer.cdp.client.constant.page.TransitionType transitionType) {
        this.id = id;
        this.url = url;
        this.userTypedURL = userTypedURL;
        this.title = title;
        this.transitionType = transitionType;
    }

    public NavigationEntry() {
    }

}