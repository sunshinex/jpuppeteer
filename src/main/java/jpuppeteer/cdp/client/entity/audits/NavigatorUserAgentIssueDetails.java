package jpuppeteer.cdp.client.entity.audits;

/**
* experimental
*/
public class NavigatorUserAgentIssueDetails {

    /**
    */
    private String url;

    /**
    */
    private jpuppeteer.cdp.client.entity.audits.SourceCodeLocation location;

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setLocation (jpuppeteer.cdp.client.entity.audits.SourceCodeLocation location) {
        this.location = location;
    }

    public jpuppeteer.cdp.client.entity.audits.SourceCodeLocation getLocation() {
        return this.location;
    }

    public NavigatorUserAgentIssueDetails(String url, jpuppeteer.cdp.client.entity.audits.SourceCodeLocation location) {
        this.url = url;
        this.location = location;
    }

    public NavigatorUserAgentIssueDetails(String url) {
        this.url = url;
        this.location = null;
    }

    public NavigatorUserAgentIssueDetails() {
    }

}