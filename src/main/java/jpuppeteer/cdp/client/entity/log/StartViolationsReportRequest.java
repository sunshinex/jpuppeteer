package jpuppeteer.cdp.client.entity.log;

/**
*/
public class StartViolationsReportRequest {

    /**
    * Configuration for violations.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.log.ViolationSetting> config;

    public StartViolationsReportRequest(java.util.List<jpuppeteer.cdp.client.entity.log.ViolationSetting> config) {
        this.config = config;
    }

}