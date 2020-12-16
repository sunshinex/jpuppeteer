package jpuppeteer.cdp.client.entity.log;

/**
*/
public class StartViolationsReportRequest {

    /**
    * Configuration for violations.
    */
    public final java.util.List<ViolationSetting> config;

    public StartViolationsReportRequest(java.util.List<ViolationSetting> config) {
        this.config = config;
    }

}