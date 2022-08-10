package jpuppeteer.cdp.client.entity.debugger;

/**
* Location in the source code.
*/
public class ScriptPosition {

    /**
    */
    private Integer lineNumber;

    /**
    */
    private Integer columnNumber;

    public void setLineNumber (Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Integer getLineNumber() {
        return this.lineNumber;
    }

    public void setColumnNumber (Integer columnNumber) {
        this.columnNumber = columnNumber;
    }

    public Integer getColumnNumber() {
        return this.columnNumber;
    }

    public ScriptPosition(Integer lineNumber, Integer columnNumber) {
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

    public ScriptPosition() {
    }

}