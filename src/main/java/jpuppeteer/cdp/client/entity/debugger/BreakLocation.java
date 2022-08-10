package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class BreakLocation {

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

    /**
    */
    private jpuppeteer.cdp.client.constant.debugger.BreakLocationType type;

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

    public void setType (jpuppeteer.cdp.client.constant.debugger.BreakLocationType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.debugger.BreakLocationType getType() {
        return this.type;
    }

    public BreakLocation(String scriptId, Integer lineNumber, Integer columnNumber, jpuppeteer.cdp.client.constant.debugger.BreakLocationType type) {
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

    public BreakLocation() {
    }

}