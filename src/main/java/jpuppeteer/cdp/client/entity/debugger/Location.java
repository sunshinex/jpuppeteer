package jpuppeteer.cdp.client.entity.debugger;

/**
* Location in the source code.
*/
public class Location {

    /**
    * Script identifier as reported in the `Debugger.scriptParsed`.
    */
    private String scriptId;

    /**
    * Line number in the script (0-based).
    */
    private Integer lineNumber;

    /**
    * Column number in the script (0-based).
    */
    private Integer columnNumber;

    public void setScriptId (String scriptId) {
        this.scriptId = scriptId;
    }

    public String getScriptId() {
        return this.scriptId;
    }

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

    public Location() {
    }

}