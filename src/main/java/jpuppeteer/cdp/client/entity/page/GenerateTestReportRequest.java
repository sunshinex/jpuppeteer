package jpuppeteer.cdp.client.entity.page;

/**
*/
public class GenerateTestReportRequest {

    /**
    * Message to be displayed in the report.
    */
    private String message;

    /**
    * Specifies the endpoint group to deliver the report to.
    */
    private String group;

    public void setMessage (String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setGroup (String group) {
        this.group = group;
    }

    public String getGroup() {
        return this.group;
    }

    public GenerateTestReportRequest(String message, String group) {
        this.message = message;
        this.group = group;
    }

    public GenerateTestReportRequest(String message) {
        this.message = message;
        this.group = null;
    }

    public GenerateTestReportRequest() {
    }

}