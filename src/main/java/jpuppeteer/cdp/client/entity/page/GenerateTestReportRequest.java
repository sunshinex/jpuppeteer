package jpuppeteer.cdp.client.entity.page;

/**
*/
public class GenerateTestReportRequest {

    /**
    * Message to be displayed in the report.
    */
    public final String message;

    /**
    * Specifies the endpoint group to deliver the report to.
    */
    public final String group;

    public GenerateTestReportRequest(String message, String group) {
        this.message = message;
        this.group = group;
    }

    public GenerateTestReportRequest(String message) {
        this.message = message;
        this.group = null;
    }

}