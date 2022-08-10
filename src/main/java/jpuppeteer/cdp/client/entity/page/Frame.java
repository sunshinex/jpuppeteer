package jpuppeteer.cdp.client.entity.page;

/**
* Information about the Frame on the page.
*/
public class Frame {

    /**
    * Frame unique identifier.
    */
    private String id;

    /**
    * Parent frame identifier.
    */
    private String parentId;

    /**
    * Identifier of the loader associated with this frame.
    */
    private String loaderId;

    /**
    * Frame's name as specified in the tag.
    */
    private String name;

    /**
    * Frame document's URL without fragment.
    */
    private String url;

    /**
    * Frame document's URL fragment including the '#'.
    */
    private String urlFragment;

    /**
    * Frame document's registered domain, taking the public suffixes list into account. Extracted from the Frame's url. Example URLs: http://www.google.com/file.html -> "google.com"               http://a.b.co.uk/file.html      -> "b.co.uk"
    */
    private String domainAndRegistry;

    /**
    * Frame document's security origin.
    */
    private String securityOrigin;

    /**
    * Frame document's mimeType as determined by the browser.
    */
    private String mimeType;

    /**
    * If the frame failed to load, this contains the URL that could not be loaded. Note that unlike url above, this URL may contain a fragment.
    */
    private String unreachableUrl;

    /**
    * Indicates whether this frame was tagged as an ad.
    */
    private jpuppeteer.cdp.client.constant.page.AdFrameType adFrameType;

    /**
    * Indicates whether the main document is a secure context and explains why that is the case.
    */
    private jpuppeteer.cdp.client.constant.page.SecureContextType secureContextType;

    /**
    * Indicates whether this is a cross origin isolated context.
    */
    private jpuppeteer.cdp.client.constant.page.CrossOriginIsolatedContextType crossOriginIsolatedContextType;

    /**
    * Indicated which gated APIs / features are available.
    */
    private java.util.List<jpuppeteer.cdp.client.constant.page.GatedAPIFeatures> gatedAPIFeatures;

    /**
    * Frame document's origin trials with at least one token present.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.page.OriginTrial> originTrials;

    public void setId (String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setParentId (String parentId) {
        this.parentId = parentId;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setLoaderId (String loaderId) {
        this.loaderId = loaderId;
    }

    public String getLoaderId() {
        return this.loaderId;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrlFragment (String urlFragment) {
        this.urlFragment = urlFragment;
    }

    public String getUrlFragment() {
        return this.urlFragment;
    }

    public void setDomainAndRegistry (String domainAndRegistry) {
        this.domainAndRegistry = domainAndRegistry;
    }

    public String getDomainAndRegistry() {
        return this.domainAndRegistry;
    }

    public void setSecurityOrigin (String securityOrigin) {
        this.securityOrigin = securityOrigin;
    }

    public String getSecurityOrigin() {
        return this.securityOrigin;
    }

    public void setMimeType (String mimeType) {
        this.mimeType = mimeType;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public void setUnreachableUrl (String unreachableUrl) {
        this.unreachableUrl = unreachableUrl;
    }

    public String getUnreachableUrl() {
        return this.unreachableUrl;
    }

    public void setAdFrameType (jpuppeteer.cdp.client.constant.page.AdFrameType adFrameType) {
        this.adFrameType = adFrameType;
    }

    public jpuppeteer.cdp.client.constant.page.AdFrameType getAdFrameType() {
        return this.adFrameType;
    }

    public void setSecureContextType (jpuppeteer.cdp.client.constant.page.SecureContextType secureContextType) {
        this.secureContextType = secureContextType;
    }

    public jpuppeteer.cdp.client.constant.page.SecureContextType getSecureContextType() {
        return this.secureContextType;
    }

    public void setCrossOriginIsolatedContextType (jpuppeteer.cdp.client.constant.page.CrossOriginIsolatedContextType crossOriginIsolatedContextType) {
        this.crossOriginIsolatedContextType = crossOriginIsolatedContextType;
    }

    public jpuppeteer.cdp.client.constant.page.CrossOriginIsolatedContextType getCrossOriginIsolatedContextType() {
        return this.crossOriginIsolatedContextType;
    }

    public void setGatedAPIFeatures (java.util.List<jpuppeteer.cdp.client.constant.page.GatedAPIFeatures> gatedAPIFeatures) {
        this.gatedAPIFeatures = gatedAPIFeatures;
    }

    public java.util.List<jpuppeteer.cdp.client.constant.page.GatedAPIFeatures> getGatedAPIFeatures() {
        return this.gatedAPIFeatures;
    }

    public void setOriginTrials (java.util.List<jpuppeteer.cdp.client.entity.page.OriginTrial> originTrials) {
        this.originTrials = originTrials;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.page.OriginTrial> getOriginTrials() {
        return this.originTrials;
    }

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

    public Frame() {
    }

}