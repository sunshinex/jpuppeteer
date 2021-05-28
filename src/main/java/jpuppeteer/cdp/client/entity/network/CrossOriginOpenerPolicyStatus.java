package jpuppeteer.cdp.client.entity.network;

/**
*/
public class CrossOriginOpenerPolicyStatus {

    /**
    */
    public final jpuppeteer.cdp.client.constant.network.CrossOriginOpenerPolicyValue value;

    /**
    */
    public final jpuppeteer.cdp.client.constant.network.CrossOriginOpenerPolicyValue reportOnlyValue;

    /**
    */
    public final String reportingEndpoint;

    /**
    */
    public final String reportOnlyReportingEndpoint;

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

}