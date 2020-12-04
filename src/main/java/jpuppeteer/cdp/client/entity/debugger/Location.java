package jpuppeteer.cdp.client.entity.debugger;

/**
* Location in the source code.
*/
public class Location {

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

    public Location(String scriptId, Integer lineNumber, Integer columnNumber) {
        this.scriptId = scriptId;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

    public Location(String scriptId, Integer lineNumber) {
        this.scriptId = scriptId;
        this.lineNumber = lineNumber;
        this.columnNumber = null;
    }

}