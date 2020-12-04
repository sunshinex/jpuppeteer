package jpuppeteer.cdp.client.entity.log;

/**
* Log entry.
*/
public class LogEntry {

    /**
    * Log entry source.
    */
    public final String source;

    /**
    * Log entry severity.
    */
    public final String level;

    /**
    * Logged text.
    */
    public final String text;

    /**
    * Timestamp when this entry was added.
    */
    public final java.math.BigDecimal timestamp;

    /**
    * URL of the resource if known.
    */
    public final String url;

    /**
    * Line number in the resource.
    */
    public final Integer lineNumber;

    /**
    * JavaScript stack trace.
    */
    public final jpuppeteer.cdp.client.entity.runtime.StackTrace stackTrace;

    /**
    * Identifier of the network request associated with this entry.
    */
    public final String networkRequestId;

    /**
    * Identifier of the worker associated with this entry.
    */
    public final String workerId;

    /**
    * Call arguments.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.runtime.RemoteObject> args;

    public LogEntry(String source, String level, String text, java.math.BigDecimal timestamp, String url, Integer lineNumber, jpuppeteer.cdp.client.entity.runtime.StackTrace stackTrace, String networkRequestId, String workerId, java.util.List<jpuppeteer.cdp.client.entity.runtime.RemoteObject> args) {
        this.source = source;
        this.level = level;
        this.text = text;
        this.timestamp = timestamp;
        this.url = url;
        this.lineNumber = lineNumber;
        this.stackTrace = stackTrace;
        this.networkRequestId = networkRequestId;
        this.workerId = workerId;
        this.args = args;
    }

    public LogEntry(String source, String level, String text, java.math.BigDecimal timestamp) {
        this.source = source;
        this.level = level;
        this.text = text;
        this.timestamp = timestamp;
        this.url = null;
        this.lineNumber = null;
        this.stackTrace = null;
        this.networkRequestId = null;
        this.workerId = null;
        this.args = null;
    }

}