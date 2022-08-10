package jpuppeteer.cdp.client.entity.performance;

/**
* Current values of the metrics.
*/
public class MetricsEvent {

    /**
    * Current values of the metrics.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.performance.Metric> metrics;

    /**
    * Timestamp title.
    */
    private String title;

    public void setMetrics (java.util.List<jpuppeteer.cdp.client.entity.performance.Metric> metrics) {
        this.metrics = metrics;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.performance.Metric> getMetrics() {
        return this.metrics;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public MetricsEvent(java.util.List<jpuppeteer.cdp.client.entity.performance.Metric> metrics, String title) {
        this.metrics = metrics;
        this.title = title;
    }

    public MetricsEvent() {
    }

}