package jpuppeteer.cdp.client.entity.audits;

/**
* Details for a CORS related issue, e.g. a warning or error related to CORS RFC1918 enforcement.
* experimental
*/
public class CorsIssueDetails {

    /**
    */
    private jpuppeteer.cdp.client.entity.network.CorsErrorStatus corsErrorStatus;

    /**
    */
    private Boolean isWarning;

    /**
    */
    private jpuppeteer.cdp.client.entity.audits.AffectedRequest request;

    /**
    */
    private jpuppeteer.cdp.client.entity.audits.SourceCodeLocation location;

    /**
    */
    private String initiatorOrigin;

    /**
    */
    private jpuppeteer.cdp.client.constant.network.IPAddressSpace resourceIPAddressSpace;

    /**
    */
    private jpuppeteer.cdp.client.entity.network.ClientSecurityState clientSecurityState;

    public void setCorsErrorStatus (jpuppeteer.cdp.client.entity.network.CorsErrorStatus corsErrorStatus) {
        this.corsErrorStatus = corsErrorStatus;
    }

    public jpuppeteer.cdp.client.entity.network.CorsErrorStatus getCorsErrorStatus() {
        return this.corsErrorStatus;
    }

    public void setIsWarning (Boolean isWarning) {
        this.isWarning = isWarning;
    }

    public Boolean getIsWarning() {
        return this.isWarning;
    }

    public void setRequest (jpuppeteer.cdp.client.entity.audits.AffectedRequest request) {
        this.request = request;
    }

    public jpuppeteer.cdp.client.entity.audits.AffectedRequest getRequest() {
        return this.request;
    }

    public void setLocation (jpuppeteer.cdp.client.entity.audits.SourceCodeLocation location) {
        this.location = location;
    }

    public jpuppeteer.cdp.client.entity.audits.SourceCodeLocation getLocation() {
        return this.location;
    }

    public void setInitiatorOrigin (String initiatorOrigin) {
        this.initiatorOrigin = initiatorOrigin;
    }

    public String getInitiatorOrigin() {
        return this.initiatorOrigin;
    }

    public void setResourceIPAddressSpace (jpuppeteer.cdp.client.constant.network.IPAddressSpace resourceIPAddressSpace) {
        this.resourceIPAddressSpace = resourceIPAddressSpace;
    }

    public jpuppeteer.cdp.client.constant.network.IPAddressSpace getResourceIPAddressSpace() {
        return this.resourceIPAddressSpace;
    }

    public void setClientSecurityState (jpuppeteer.cdp.client.entity.network.ClientSecurityState clientSecurityState) {
        this.clientSecurityState = clientSecurityState;
    }

    public jpuppeteer.cdp.client.entity.network.ClientSecurityState getClientSecurityState() {
        return this.clientSecurityState;
    }

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

    public CorsIssueDetails() {
    }

}