package jpuppeteer.cdp.client.entity.audits;

/**
* experimental
*/
public class SourceCodeLocation {

    /**
    */
    public final String scriptId;

    /**
    */
    public final String url;

    /**
    */
    public final Integer lineNumber;

    /**
    */
    public final Integer columnNumber;

    public SourceCodeLocation(String scriptId, String url, Integer lineNumber, Integer columnNumber) {
        this.scriptId = scriptId;
        this.url = url;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

    public SourceCodeLocation(String url, Integer lineNumber, Integer columnNumber) {
        this.scriptId = null;
        this.url = url;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

}