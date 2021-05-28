package jpuppeteer.cdp.client.entity.network;

/**
*/
public class CrossOriginEmbedderPolicyStatus {

    /**
    */
    public final jpuppeteer.cdp.client.constant.network.CrossOriginEmbedderPolicyValue value;

    /**
    */
    public final jpuppeteer.cdp.client.constant.network.CrossOriginEmbedderPolicyValue reportOnlyValue;

    /**
    */
    public final String reportingEndpoint;

    /**
    */
    public final String reportOnlyReportingEndpoint;

    public CrossOriginEmbedderPolicyStatus(jpuppeteer.cdp.client.constant.network.CrossOriginEmbedderPolicyValue value, jpuppeteer.cdp.client.constant.network.CrossOriginEmbedderPolicyValue reportOnlyValue, String reportingEndpoint, String reportOnlyReportingEndpoint) {
        this.value = value;
        this.reportOnlyValue = reportOnlyValue;
        this.reportingEndpoint = reportingEndpoint;
        this.reportOnlyReportingEndpoint = reportOnlyReportingEndpoint;
    }

    public CrossOriginEmbedderPolicyStatus(jpuppeteer.cdp.client.constant.network.CrossOriginEmbedderPolicyValue value, jpuppeteer.cdp.client.constant.network.CrossOriginEmbedderPolicyValue reportOnlyValue) {
        this.value = value;
        this.reportOnlyValue = reportOnlyValue;
        this.reportingEndpoint = null;
        this.reportOnlyReportingEndpoint = null;
    }

}