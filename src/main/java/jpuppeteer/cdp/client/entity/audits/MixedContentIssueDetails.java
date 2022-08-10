package jpuppeteer.cdp.client.entity.audits;

/**
* experimental
*/
public class MixedContentIssueDetails {

    /**
    * The type of resource causing the mixed content issue (css, js, iframe, form,...). Marked as optional because it is mapped to from blink::mojom::RequestContextType, which will be replaced by network::mojom::RequestDestination
    */
    private jpuppeteer.cdp.client.constant.audits.MixedContentResourceType resourceType;

    /**
    * The way the mixed content issue is being resolved.
    */
    private jpuppeteer.cdp.client.constant.audits.MixedContentResolutionStatus resolutionStatus;

    /**
    * The unsafe http url causing the mixed content issue.
    */
    private String insecureURL;

    /**
    * The url responsible for the call to an unsafe url.
    */
    private String mainResourceURL;

    /**
    * The mixed content request. Does not always exist (e.g. for unsafe form submission urls).
    */
    private jpuppeteer.cdp.client.entity.audits.AffectedRequest request;

    /**
    * Optional because not every mixed content issue is necessarily linked to a frame.
    */
    private jpuppeteer.cdp.client.entity.audits.AffectedFrame frame;

    public void setResourceType (jpuppeteer.cdp.client.constant.audits.MixedContentResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public jpuppeteer.cdp.client.constant.audits.MixedContentResourceType getResourceType() {
        return this.resourceType;
    }

    public void setResolutionStatus (jpuppeteer.cdp.client.constant.audits.MixedContentResolutionStatus resolutionStatus) {
        this.resolutionStatus = resolutionStatus;
    }

    public jpuppeteer.cdp.client.constant.audits.MixedContentResolutionStatus getResolutionStatus() {
        return this.resolutionStatus;
    }

    public void setInsecureURL (String insecureURL) {
        this.insecureURL = insecureURL;
    }

    public String getInsecureURL() {
        return this.insecureURL;
    }

    public void setMainResourceURL (String mainResourceURL) {
        this.mainResourceURL = mainResourceURL;
    }

    public String getMainResourceURL() {
        return this.mainResourceURL;
    }

    public void setRequest (jpuppeteer.cdp.client.entity.audits.AffectedRequest request) {
        this.request = request;
    }

    public jpuppeteer.cdp.client.entity.audits.AffectedRequest getRequest() {
        return this.request;
    }

    public void setFrame (jpuppeteer.cdp.client.entity.audits.AffectedFrame frame) {
        this.frame = frame;
    }

    public jpuppeteer.cdp.client.entity.audits.AffectedFrame getFrame() {
        return this.frame;
    }

    public MixedContentIssueDetails(jpuppeteer.cdp.client.constant.audits.MixedContentResourceType resourceType, jpuppeteer.cdp.client.constant.audits.MixedContentResolutionStatus resolutionStatus, String insecureURL, String mainResourceURL, jpuppeteer.cdp.client.entity.audits.AffectedRequest request, jpuppeteer.cdp.client.entity.audits.AffectedFrame frame) {
        this.resourceType = resourceType;
        this.resolutionStatus = resolutionStatus;
        this.insecureURL = insecureURL;
        this.mainResourceURL = mainResourceURL;
        this.request = request;
        this.frame = frame;
    }

    public MixedContentIssueDetails(jpuppeteer.cdp.client.constant.audits.MixedContentResolutionStatus resolutionStatus, String insecureURL, String mainResourceURL) {
        this.resourceType = null;
        this.resolutionStatus = resolutionStatus;
        this.insecureURL = insecureURL;
        this.mainResourceURL = mainResourceURL;
        this.request = null;
        this.frame = null;
    }

    public MixedContentIssueDetails() {
    }

}