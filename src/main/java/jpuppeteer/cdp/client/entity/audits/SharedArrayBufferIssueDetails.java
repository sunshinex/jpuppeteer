package jpuppeteer.cdp.client.entity.audits;

/**
* Details for a issue arising from an SAB being instantiated in, or transferred to a context that is not cross-origin isolated.
* experimental
*/
public class SharedArrayBufferIssueDetails {

    /**
    */
    private jpuppeteer.cdp.client.entity.audits.SourceCodeLocation sourceCodeLocation;

    /**
    */
    private Boolean isWarning;

    /**
    */
    private jpuppeteer.cdp.client.constant.audits.SharedArrayBufferIssueType type;

    public void setSourceCodeLocation (jpuppeteer.cdp.client.entity.audits.SourceCodeLocation sourceCodeLocation) {
        this.sourceCodeLocation = sourceCodeLocation;
    }

    public jpuppeteer.cdp.client.entity.audits.SourceCodeLocation getSourceCodeLocation() {
        return this.sourceCodeLocation;
    }

    public void setIsWarning (Boolean isWarning) {
        this.isWarning = isWarning;
    }

    public Boolean getIsWarning() {
        return this.isWarning;
    }

    public void setType (jpuppeteer.cdp.client.constant.audits.SharedArrayBufferIssueType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.audits.SharedArrayBufferIssueType getType() {
        return this.type;
    }

    public SharedArrayBufferIssueDetails(jpuppeteer.cdp.client.entity.audits.SourceCodeLocation sourceCodeLocation, Boolean isWarning, jpuppeteer.cdp.client.constant.audits.SharedArrayBufferIssueType type) {
        this.sourceCodeLocation = sourceCodeLocation;
        this.isWarning = isWarning;
        this.type = type;
    }

    public SharedArrayBufferIssueDetails() {
    }

}