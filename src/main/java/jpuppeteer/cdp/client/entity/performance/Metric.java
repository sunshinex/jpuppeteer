package jpuppeteer.cdp.client.entity.performance;

/**
* Run-time execution metric.
*/
public class Metric {

    /**
    * Metric name.
    */
    public final String name;

    /**
    * Metric value.
    */
    public final java.math.BigDecimal value;

    public Metric(String name, java.math.BigDecimal value) {
        this.name = name;
        this.value = value;
    }

}