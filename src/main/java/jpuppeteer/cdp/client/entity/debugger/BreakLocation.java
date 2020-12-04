package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class BreakLocation {

    /**
    * Script identifier as reported in the `Debugger.scriptParsed`.
    */
    public final String scriptId;

    /**
    * Line number in the script (0-based).
    */
    public final Integer lineNumber;

    /**
    * Column number in the script (0-based).
    */
    public final Integer columnNumber;

    /**
    */
    public final String type;

    public BreakLocation(String scriptId, Integer lineNumber, Integer columnNumber, String type) {
        this.scriptId = scriptId;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
        this.type = type;
    }

    public BreakLocation(String scriptId, Integer lineNumber) {
        this.scriptId = scriptId;
        this.lineNumber = lineNumber;
        this.columnNumber = null;
        this.type = null;
    }

}