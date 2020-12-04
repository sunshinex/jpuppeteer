package jpuppeteer.cdp.client.entity.debugger;

/**
* Location in the source code.
*/
public class ScriptPosition {

    /**
    */
    public final Integer lineNumber;

    /**
    */
    public final Integer columnNumber;

    public ScriptPosition(Integer lineNumber, Integer columnNumber) {
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

}