package jpuppeteer.cdp.client.entity.log;

/**
* Violation configuration setting.
*/
public class ViolationSetting {

    /**
    * Violation type.
    */
    public final String name;

    /**
    * Time threshold to trigger upon.
    */
    public final java.math.BigDecimal threshold;

    public ViolationSetting(String name, java.math.BigDecimal threshold) {
        this.name = name;
        this.threshold = threshold;
    }

}