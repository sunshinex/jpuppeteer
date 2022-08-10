package jpuppeteer.cdp.client.entity.debugger;

/**
* Search match for resource.
*/
public class SearchMatch {

    /**
    * Line number in resource content.
    */
    private java.math.BigDecimal lineNumber;

    /**
    * Line with match content.
    */
    private String lineContent;

    public void setLineNumber (java.math.BigDecimal lineNumber) {
        this.lineNumber = lineNumber;
    }

    public java.math.BigDecimal getLineNumber() {
        return this.lineNumber;
    }

    public void setLineContent (String lineContent) {
        this.lineContent = lineContent;
    }

    public String getLineContent() {
        return this.lineContent;
    }

    public SearchMatch(java.math.BigDecimal lineNumber, String lineContent) {
        this.lineNumber = lineNumber;
        this.lineContent = lineContent;
    }

    public SearchMatch() {
    }

}