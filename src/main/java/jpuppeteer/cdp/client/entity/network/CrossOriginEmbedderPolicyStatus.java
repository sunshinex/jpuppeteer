package jpuppeteer.cdp.client.entity.network;

/**
*/
public class CrossOriginEmbedderPolicyStatus {

    /**
    */
    private jpuppeteer.cdp.client.constant.network.CrossOriginEmbedderPolicyValue value;

    /**
    */
    private jpuppeteer.cdp.client.constant.network.CrossOriginEmbedderPolicyValue reportOnlyValue;

    /**
    */
    private String reportingEndpoint;

    /**
    */
    private String reportOnlyReportingEndpoint;

    public void setValue (jpuppeteer.cdp.client.constant.network.CrossOriginEmbedderPolicyValue value) {
        this.value = value;
    }

    public jpuppeteer.cdp.client.constant.network.CrossOriginEmbedderPolicyValue getValue() {
        return this.value;
    }

    public void setReportOnlyValue (jpuppeteer.cdp.client.constant.network.CrossOriginEmbedderPolicyValue reportOnlyValue) {
        this.reportOnlyValue = reportOnlyValue;
    }

    public jpuppeteer.cdp.client.constant.network.CrossOriginEmbedderPolicyValue getReportOnlyValue() {
        return this.reportOnlyValue;
    }

    public void setReportingEndpoint (String reportingEndpoint) {
        this.reportingEndpoint = reportingEndpoint;
    }

    public String getReportingEndpoint() {
        return this.reportingEndpoint;
    }

    public void setReportOnlyReportingEndpoint (String reportOnlyReportingEndpoint) {
        this.reportOnlyReportingEndpoint = reportOnlyReportingEndpoint;
    }

    public String getReportOnlyReportingEndpoint() {
        return this.reportOnlyReportingEndpoint;
    }

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

    public CrossOriginEmbedderPolicyStatus() {
    }

}