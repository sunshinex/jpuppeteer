package jpuppeteer.cdp.client.entity.network;

/**
*/
public class CrossOriginOpenerPolicyStatus {

    /**
    */
    private jpuppeteer.cdp.client.constant.network.CrossOriginOpenerPolicyValue value;

    /**
    */
    private jpuppeteer.cdp.client.constant.network.CrossOriginOpenerPolicyValue reportOnlyValue;

    /**
    */
    private String reportingEndpoint;

    /**
    */
    private String reportOnlyReportingEndpoint;

    public void setValue (jpuppeteer.cdp.client.constant.network.CrossOriginOpenerPolicyValue value) {
        this.value = value;
    }

    public jpuppeteer.cdp.client.constant.network.CrossOriginOpenerPolicyValue getValue() {
        return this.value;
    }

    public void setReportOnlyValue (jpuppeteer.cdp.client.constant.network.CrossOriginOpenerPolicyValue reportOnlyValue) {
        this.reportOnlyValue = reportOnlyValue;
    }

    public jpuppeteer.cdp.client.constant.network.CrossOriginOpenerPolicyValue getReportOnlyValue() {
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

    public CrossOriginOpenerPolicyStatus(jpuppeteer.cdp.client.constant.network.CrossOriginOpenerPolicyValue value, jpuppeteer.cdp.client.constant.network.CrossOriginOpenerPolicyValue reportOnlyValue, String reportingEndpoint, String reportOnlyReportingEndpoint) {
        this.value = value;
        this.reportOnlyValue = reportOnlyValue;
        this.reportingEndpoint = reportingEndpoint;
        this.reportOnlyReportingEndpoint = reportOnlyReportingEndpoint;
    }

    public CrossOriginOpenerPolicyStatus(jpuppeteer.cdp.client.constant.network.CrossOriginOpenerPolicyValue value, jpuppeteer.cdp.client.constant.network.CrossOriginOpenerPolicyValue reportOnlyValue) {
        this.value = value;
        this.reportOnlyValue = reportOnlyValue;
        this.reportingEndpoint = null;
        this.reportOnlyReportingEndpoint = null;
    }

    public CrossOriginOpenerPolicyStatus() {
    }

}