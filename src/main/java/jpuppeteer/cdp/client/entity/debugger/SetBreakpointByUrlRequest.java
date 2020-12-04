package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetBreakpointByUrlRequest {

    /**
    * Line number to set breakpoint at.
    */
    public final Integer lineNumber;

    /**
    * URL of the resources to set breakpoint on.
    */
    public final String url;

    /**
    * Regex pattern for the URLs of the resources to set breakpoints on. Either `url` or `urlRegex` must be specified.
    */
    public final String urlRegex;

    /**
    * Script hash of the resources to set breakpoint on.
    */
    public final String scriptHash;

    /**
    * Offset in the line to set breakpoint at.
    */
    public final Integer columnNumber;

    /**
    * Expression to use as a breakpoint condition. When specified, debugger will only stop on the breakpoint if this expression evaluates to true.
    */
    public final String condition;

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

}