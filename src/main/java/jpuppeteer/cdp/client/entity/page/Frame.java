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
    * Frame document's registered domain, taking the public suffixes list into account. Extracted from the Frame's url. Example URLs: http://www.google.com/file.html -> "google.com"               http://a.b.co.uk/file.html      -> "b.co.uk"
    */
    public final String domainAndRegistry;

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

    /**
    * Indicates whether this frame was tagged as an ad.
    */
    public final jpuppeteer.cdp.client.constant.page.AdFrameType adFrameType;

    /**
    * Indicates whether the main document is a secure context and explains why that is the case.
    */
    public final jpuppeteer.cdp.client.constant.page.SecureContextType secureContextType;

    /**
    * Indicates whether this is a cross origin isolated context.
    */
    public final jpuppeteer.cdp.client.constant.page.CrossOriginIsolatedContextType crossOriginIsolatedContextType;

    /**
    * Indicated which gated APIs / features are available.
    */
    public final java.util.List<jpuppeteer.cdp.client.constant.page.GatedAPIFeatures> gatedAPIFeatures;

    /**
    * Frame document's origin trials with at least one token present.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.page.OriginTrial> originTrials;

    public Frame(String id, String parentId, String loaderId, String name, String url, String urlFragment, String domainAndRegistry, String securityOrigin, String mimeType, String unreachableUrl, jpuppeteer.cdp.client.constant.page.AdFrameType adFrameType, jpuppeteer.cdp.client.constant.page.SecureContextType secureContextType, jpuppeteer.cdp.client.constant.page.CrossOriginIsolatedContextType crossOriginIsolatedContextType, java.util.List<jpuppeteer.cdp.client.constant.page.GatedAPIFeatures> gatedAPIFeatures, java.util.List<jpuppeteer.cdp.client.entity.page.OriginTrial> originTrials) {
        this.id = id;
        this.parentId = parentId;
        this.loaderId = loaderId;
        this.name = name;
        this.url = url;
        this.urlFragment = urlFragment;
        this.domainAndRegistry = domainAndRegistry;
        this.securityOrigin = securityOrigin;
        this.mimeType = mimeType;
        this.unreachableUrl = unreachableUrl;
        this.adFrameType = adFrameType;
        this.secureContextType = secureContextType;
        this.crossOriginIsolatedContextType = crossOriginIsolatedContextType;
        this.gatedAPIFeatures = gatedAPIFeatures;
        this.originTrials = originTrials;
    }

    public Frame(String id, String loaderId, String url, String domainAndRegistry, String securityOrigin, String mimeType, jpuppeteer.cdp.client.constant.page.SecureContextType secureContextType, jpuppeteer.cdp.client.constant.page.CrossOriginIsolatedContextType crossOriginIsolatedContextType, java.util.List<jpuppeteer.cdp.client.constant.page.GatedAPIFeatures> gatedAPIFeatures) {
        this.id = id;
        this.parentId = null;
        this.loaderId = loaderId;
        this.name = null;
        this.url = url;
        this.urlFragment = null;
        this.domainAndRegistry = domainAndRegistry;
        this.securityOrigin = securityOrigin;
        this.mimeType = mimeType;
        this.unreachableUrl = null;
        this.adFrameType = null;
        this.secureContextType = secureContextType;
        this.crossOriginIsolatedContextType = crossOriginIsolatedContextType;
        this.gatedAPIFeatures = gatedAPIFeatures;
        this.originTrials = null;
    }

}