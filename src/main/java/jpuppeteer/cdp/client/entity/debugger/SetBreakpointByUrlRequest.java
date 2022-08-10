package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetBreakpointByUrlRequest {

    /**
    * Line number to set breakpoint at.
    */
    private Integer lineNumber;

    /**
    * URL of the resources to set breakpoint on.
    */
    private String url;

    /**
    * Regex pattern for the URLs of the resources to set breakpoints on. Either `url` or `urlRegex` must be specified.
    */
    private String urlRegex;

    /**
    * Script hash of the resources to set breakpoint on.
    */
    private String scriptHash;

    /**
    * Offset in the line to set breakpoint at.
    */
    private Integer columnNumber;

    /**
    * Expression to use as a breakpoint condition. When specified, debugger will only stop on the breakpoint if this expression evaluates to true.
    */
    private String condition;

    public void setLineNumber (Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Integer getLineNumber() {
        return this.lineNumber;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrlRegex (String urlRegex) {
        this.urlRegex = urlRegex;
    }

    public String getUrlRegex() {
        return this.urlRegex;
    }

    public void setScriptHash (String scriptHash) {
        this.scriptHash = scriptHash;
    }

    public String getScriptHash() {
        return this.scriptHash;
    }

    public void setColumnNumber (Integer columnNumber) {
        this.columnNumber = columnNumber;
    }

    public Integer getColumnNumber() {
        return this.columnNumber;
    }

    public void setCondition (String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return this.condition;
    }

    public SetBreakpointByUrlRequest(Integer lineNumber, String url, String urlRegex, String scriptHash, Integer columnNumber, String condition) {
        this.lineNumber = lineNumber;
        this.url = url;
        this.urlRegex = urlRegex;
        this.scriptHash = scriptHash;
        this.columnNumber = columnNumber;
        this.condition = condition;
    }

    public SetBreakpointByUrlRequest(Integer lineNumber) {
        this.lineNumber = lineNumber;
        this.url = null;
        this.urlRegex = null;
        this.scriptHash = null;
        this.columnNumber = null;
        this.condition = null;
    }

    public SetBreakpointByUrlRequest() {
    }

}