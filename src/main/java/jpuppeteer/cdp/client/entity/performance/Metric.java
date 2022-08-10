package jpuppeteer.cdp.client.entity.performance;

/**
* Run-time execution metric.
*/
public class Metric {

    /**
    * Metric name.
    */
    private String name;

    /**
    * Metric value.
    */
    private java.math.BigDecimal value;

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setValue (java.math.BigDecimal value) {
        this.value = value;
    }

    public java.math.BigDecimal getValue() {
        return this.value;
    }

    public Metric(String name, java.math.BigDecimal value) {
        this.name = name;
        this.value = value;
    }

    public Metric() {
    }

}