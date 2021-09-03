package jpuppeteer.cdp.client.entity.audits;

/**
* experimental
*/
public class MixedContentIssueDetails {

    /**
    * The type of resource causing the mixed content issue (css, js, iframe, form,...). Marked as optional because it is mapped to from blink::mojom::RequestContextType, which will be replaced by network::mojom::RequestDestination
    */
    public final jpuppeteer.cdp.client.constant.audits.MixedContentResourceType resourceType;

    /**
    * The way the mixed content issue is being resolved.
    */
    public final jpuppeteer.cdp.client.constant.audits.MixedContentResolutionStatus resolutionStatus;

    /**
    * The unsafe http url causing the mixed content issue.
    */
    public final String insecureURL;

    /**
    * The url responsible for the call to an unsafe url.
    */
    public final String mainResourceURL;

    /**
    * The mixed content request. Does not always exist (e.g. for unsafe form submission urls).
    */
    public final jpuppeteer.cdp.client.entity.audits.AffectedRequest request;

    /**
    * Optional because not every mixed content issue is necessarily linked to a frame.
    */
    public final jpuppeteer.cdp.client.entity.audits.AffectedFrame frame;

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

}