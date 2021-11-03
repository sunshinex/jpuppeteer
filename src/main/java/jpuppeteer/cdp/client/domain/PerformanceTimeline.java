package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class PerformanceTimeline {

    private jpuppeteer.cdp.CDPConnection connection;

    public PerformanceTimeline(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Previously buffered events would be reported before method returns. See also: timelineEventAdded
    */
    public io.netty.util.concurrent.Future enable(jpuppeteer.cdp.client.entity.performancetimeline.EnableRequest request) {
        return connection.send("PerformanceTimeline.enable", request);
    }

}