package jpuppeteer.cdp.client.entity.page;

/**
* Information about the Frame on the page.
*/
public class Frame {

    /**
    * Frame unique identifier.
    */
    public final String id;

    /**
    * Parent frame identifier.
    */
    public final String parentId;

    /**
    * Identifier of the loader associated with this frame.
    */
    public final String loaderId;

    /**
    * Frame's name as specified in the tag.
    */
    public final String name;

    /**
    * Frame document's URL without fragment.
    */
    public final String url;

    /**
    * Frame document's URL fragment including the '#'.
    */
    public final String urlFragment;

    /**
    * Frame document's security origin.
    */
    public final String securityOrigin;

    /**
    * Frame document's mimeType as determined by the browser.
    */
    public final String mimeType;

    /**
    * If the frame failed to load, this contains the URL that could not be loaded. Note that unlike url above, this URL may contain a fragment.
    */
    public final String unreachableUrl;

    public Frame(String id, String parentId, String loaderId, String name, String url, String urlFragment, String securityOrigin, String mimeType, String unreachableUrl) {
        this.id = id;
        this.parentId = parentId;
        this.loaderId = loaderId;
        this.name = name;
        this.url = url;
        this.urlFragment = urlFragment;
        this.securityOrigin = securityOrigin;
        this.mimeType = mimeType;
        this.unreachableUrl = unreachableUrl;
    }

    public Frame(String id, String loaderId, String url, String securityOrigin, String mimeType) {
        this.id = id;
        this.parentId = null;
        this.loaderId = loaderId;
        this.name = null;
        this.url = url;
        this.urlFragment = null;
        this.securityOrigin = securityOrigin;
        this.mimeType = mimeType;
        this.unreachableUrl = null;
    }

}