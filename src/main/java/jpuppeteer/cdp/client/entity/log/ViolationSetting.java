package jpuppeteer.cdp.client.entity.log;

/**
* Violation configuration setting.
*/
public class ViolationSetting {

    /**
    * Violation type.
    */
    private jpuppeteer.cdp.client.constant.log.ViolationSettingName name;

    /**
    * Time threshold to trigger upon.
    */
    private java.math.BigDecimal threshold;

    public void setName (jpuppeteer.cdp.client.constant.log.ViolationSettingName name) {
        this.name = name;
    }

    public jpuppeteer.cdp.client.constant.log.ViolationSettingName getName() {
        return this.name;
    }

    public void setThreshold (java.math.BigDecimal threshold) {
        this.threshold = threshold;
    }

    public java.math.BigDecimal getThreshold() {
        return this.threshold;
    }

    public ViolationSetting(jpuppeteer.cdp.client.constant.log.ViolationSettingName name, java.math.BigDecimal threshold) {
        this.name = name;
        this.threshold = threshold;
    }

    public ViolationSetting() {
    }

}