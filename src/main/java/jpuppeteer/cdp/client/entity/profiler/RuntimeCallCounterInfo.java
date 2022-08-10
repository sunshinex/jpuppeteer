package jpuppeteer.cdp.client.entity.profiler;

/**
* Runtime call counter information.
*/
public class RuntimeCallCounterInfo {

    /**
    * Counter name.
    */
    private String name;

    /**
    * Counter value.
    */
    private java.math.BigDecimal value;

    /**
    * Counter time in seconds.
    */
    private java.math.BigDecimal time;

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

    public void setTime (java.math.BigDecimal time) {
        this.time = time;
    }

    public java.math.BigDecimal getTime() {
        return this.time;
    }

    public RuntimeCallCounterInfo(String name, java.math.BigDecimal value, java.math.BigDecimal time) {
        this.name = name;
        this.value = value;
        this.time = time;
    }

    public RuntimeCallCounterInfo() {
    }

}