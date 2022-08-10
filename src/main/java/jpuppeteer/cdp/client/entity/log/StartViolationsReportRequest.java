package jpuppeteer.cdp.client.entity.log;

/**
*/
public class StartViolationsReportRequest {

    /**
    * Configuration for violations.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.log.ViolationSetting> config;

    public void setConfig (java.util.List<jpuppeteer.cdp.client.entity.log.ViolationSetting> config) {
        this.config = config;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.log.ViolationSetting> getConfig() {
        return this.config;
    }

    public StartViolationsReportRequest(java.util.List<jpuppeteer.cdp.client.entity.log.ViolationSetting> config) {
        this.config = config;
    }

    public StartViolationsReportRequest() {
    }

}