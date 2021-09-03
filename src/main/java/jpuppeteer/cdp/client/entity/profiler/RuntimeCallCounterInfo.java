package jpuppeteer.cdp.client.entity.profiler;

/**
* Runtime call counter information.
*/
public class RuntimeCallCounterInfo {

    /**
    * Counter name.
    */
    public final String name;

    /**
    * Counter value.
    */
    public final java.math.BigDecimal value;

    /**
    * Counter time in seconds.
    */
    public final java.math.BigDecimal time;

    public RuntimeCallCounterInfo(String name, java.math.BigDecimal value, java.math.BigDecimal time) {
        this.name = name;
        this.value = value;
        this.time = time;
    }

}