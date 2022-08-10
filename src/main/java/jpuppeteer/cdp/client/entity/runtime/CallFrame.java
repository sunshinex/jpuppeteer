package jpuppeteer.cdp.client.entity.runtime;

/**
* Stack entry for runtime errors and assertions.
*/
public class CallFrame {

    /**
    * JavaScript function name.
    */
    private String functionName;

    /**
    * JavaScript script id.
    */
    private String scriptId;

    /**
    * JavaScript script name or url.
    */
    private String url;

    /**
    * JavaScript script line number (0-based).
    */
    private Integer lineNumber;

    /**
    * JavaScript script column number (0-based).
    */
    private Integer columnNumber;

    public void setFunctionName (String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionName() {
        return this.functionName;
    }

    public void setScriptId (String scriptId) {
        this.scriptId = scriptId;
    }

    public String getScriptId() {
        return this.scriptId;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
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

    public CallFrame(String functionName, String scriptId, String url, Integer lineNumber, Integer columnNumber) {
        this.functionName = functionName;
        this.scriptId = scriptId;
        this.url = url;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

    public CallFrame() {
    }

}