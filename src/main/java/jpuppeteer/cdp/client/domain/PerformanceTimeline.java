package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class PerformanceTimeline {

    private jpuppeteer.cdp.CDPSession session;

    public PerformanceTimeline(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Previously buffered events would be reported before method returns. See also: timelineEventAdded
    */
    public io.netty.util.concurrent.Future enable(jpuppeteer.cdp.client.entity.performancetimeline.EnableRequest request) {
        return session.send("PerformanceTimeline.enable", request);
    }

}