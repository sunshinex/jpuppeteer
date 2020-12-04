package jpuppeteer.cdp.client.entity.debugger;

/**
* Search match for resource.
*/
public class SearchMatch {

    /**
    * Line number in resource content.
    */
    public final java.math.BigDecimal lineNumber;

    /**
    * Line with match content.
    */
    public final String lineContent;

    public SearchMatch(java.math.BigDecimal lineNumber, String lineContent) {
        this.lineNumber = lineNumber;
        this.lineContent = lineContent;
    }

}