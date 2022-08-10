package jpuppeteer.cdp.client.entity.audits;

/**
* experimental
*/
public class CheckContrastRequest {

    /**
    * Whether to report WCAG AAA level issues. Default is false.
    */
    private Boolean reportAAA;

    public void setReportAAA (Boolean reportAAA) {
        this.reportAAA = reportAAA;
    }

    public Boolean getReportAAA() {
        return this.reportAAA;
    }

    public CheckContrastRequest(Boolean reportAAA) {
        this.reportAAA = reportAAA;
    }

    public CheckContrastRequest() {
        this.reportAAA = null;
    }

}