package jpuppeteer.cdp.client.entity.audits;

/**
* experimental
*/
public class CheckContrastRequest {

    /**
    * Whether to report WCAG AAA level issues. Default is false.
    */
    public final Boolean reportAAA;

    public CheckContrastRequest(Boolean reportAAA) {
        this.reportAAA = reportAAA;
    }

    public CheckContrastRequest() {
        this.reportAAA = null;
    }

}