package jpuppeteer.cdp.client.entity.audits;

/**
* Details for a issue arising from an SAB being instantiated in, or transferred to a context that is not cross-origin isolated.
* experimental
*/
public class SharedArrayBufferIssueDetails {

    /**
    */
    public final jpuppeteer.cdp.client.entity.audits.SourceCodeLocation sourceCodeLocation;

    /**
    */
    public final Boolean isWarning;

    /**
    */
    public final jpuppeteer.cdp.client.constant.audits.SharedArrayBufferIssueType type;

    public SharedArrayBufferIssueDetails(jpuppeteer.cdp.client.entity.audits.SourceCodeLocation sourceCodeLocation, Boolean isWarning, jpuppeteer.cdp.client.constant.audits.SharedArrayBufferIssueType type) {
        this.sourceCodeLocation = sourceCodeLocation;
        this.isWarning = isWarning;
        this.type = type;
    }

}