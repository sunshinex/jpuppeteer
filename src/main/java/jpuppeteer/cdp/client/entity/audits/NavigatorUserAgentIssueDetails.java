package jpuppeteer.cdp.client.entity.audits;

/**
* experimental
*/
public class NavigatorUserAgentIssueDetails {

    /**
    */
    public final String url;

    /**
    */
    public final jpuppeteer.cdp.client.entity.audits.SourceCodeLocation location;

    public NavigatorUserAgentIssueDetails(String url, jpuppeteer.cdp.client.entity.audits.SourceCodeLocation location) {
        this.url = url;
        this.location = location;
    }

    public NavigatorUserAgentIssueDetails(String url) {
        this.url = url;
        this.location = null;
    }

}