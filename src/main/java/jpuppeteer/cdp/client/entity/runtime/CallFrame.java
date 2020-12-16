package jpuppeteer.cdp.client.entity.runtime;

/**
* Stack entry for runtime errors and assertions.
*/
public class CallFrame {

    /**
    * JavaScript function name.
    */
    public final String functionName;

    /**
    * JavaScript script id.
    */
    public final String scriptId;

    /**
    * JavaScript script name or url.
    */
    public final String url;

    /**
    * JavaScript script line number (0-based).
    */
    public final Integer lineNumber;

    /**
    * JavaScript script column number (0-based).
    */
    public final Integer columnNumber;

    public CallFrame(String functionName, String scriptId, String url, Integer lineNumber, Integer columnNumber) {
        this.functionName = functionName;
        this.scriptId = scriptId;
        this.url = url;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

}