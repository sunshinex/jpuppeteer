package jpuppeteer.cdp.client.entity.audits;

/**
* Details for a CORS related issue, e.g. a warning or error related to CORS RFC1918 enforcement.
* experimental
*/
public class CorsIssueDetails {

    /**
    */
    public final jpuppeteer.cdp.client.entity.network.CorsErrorStatus corsErrorStatus;

    /**
    */
    public final Boolean isWarning;

    /**
    */
    public final jpuppeteer.cdp.client.entity.audits.AffectedRequest request;

    /**
    */
    public final jpuppeteer.cdp.client.entity.audits.SourceCodeLocation location;

    /**
    */
    public final String initiatorOrigin;

    /**
    */
    public final jpuppeteer.cdp.client.constant.network.IPAddressSpace resourceIPAddressSpace;

    /**
    */
    public final jpuppeteer.cdp.client.entity.network.ClientSecurityState clientSecurityState;

    public CorsIssueDetails(jpuppeteer.cdp.client.entity.network.CorsErrorStatus corsErrorStatus, Boolean isWarning, jpuppeteer.cdp.client.entity.audits.AffectedRequest request, jpuppeteer.cdp.client.entity.audits.SourceCodeLocation location, String initiatorOrigin, jpuppeteer.cdp.client.constant.network.IPAddressSpace resourceIPAddressSpace, jpuppeteer.cdp.client.entity.network.ClientSecurityState clientSecurityState) {
        this.corsErrorStatus = corsErrorStatus;
        this.isWarning = isWarning;
        this.request = request;
        this.location = location;
        this.initiatorOrigin = initiatorOrigin;
        this.resourceIPAddressSpace = resourceIPAddressSpace;
        this.clientSecurityState = clientSecurityState;
    }

    public CorsIssueDetails(jpuppeteer.cdp.client.entity.network.CorsErrorStatus corsErrorStatus, Boolean isWarning, jpuppeteer.cdp.client.entity.audits.AffectedRequest request) {
        this.corsErrorStatus = corsErrorStatus;
        this.isWarning = isWarning;
        this.request = request;
        this.location = null;
        this.initiatorOrigin = null;
        this.resourceIPAddressSpace = null;
        this.clientSecurityState = null;
    }

}