package jpuppeteer.cdp.client.entity.log;

/**
* Log entry.
*/
public class LogEntry {

    /**
    * Log entry source.
    */
    private jpuppeteer.cdp.client.constant.log.LogEntrySource source;

    /**
    * Log entry severity.
    */
    private jpuppeteer.cdp.client.constant.log.LogEntryLevel level;

    /**
    * Logged text.
    */
    private String text;

    /**
    * Timestamp when this entry was added.
    */
    private java.math.BigDecimal timestamp;

    /**
    * URL of the resource if known.
    */
    private String url;

    /**
    * Line number in the resource.
    */
    private Integer lineNumber;

    /**
    * JavaScript stack trace.
    */
    private jpuppeteer.cdp.client.entity.runtime.StackTrace stackTrace;

    /**
    * Identifier of the network request associated with this entry.
    */
    private String networkRequestId;

    /**
    * Identifier of the worker associated with this entry.
    */
    private String workerId;

    /**
    * Call arguments.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.runtime.RemoteObject> args;

    public void setSource (jpuppeteer.cdp.client.constant.log.LogEntrySource source) {
        this.source = source;
    }

    public jpuppeteer.cdp.client.constant.log.LogEntrySource getSource() {
        return this.source;
    }

    public void setLevel (jpuppeteer.cdp.client.constant.log.LogEntryLevel level) {
        this.level = level;
    }

    public jpuppeteer.cdp.client.constant.log.LogEntryLevel getLevel() {
        return this.level;
    }

    public void setText (String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setTimestamp (java.math.BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public java.math.BigDecimal getTimestamp() {
        return this.timestamp;
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

    public void setStackTrace (jpuppeteer.cdp.client.entity.runtime.StackTrace stackTrace) {
        this.stackTrace = stackTrace;
    }

    public jpuppeteer.cdp.client.entity.runtime.StackTrace getStackTrace() {
        return this.stackTrace;
    }

    public void setNetworkRequestId (String networkRequestId) {
        this.networkRequestId = networkRequestId;
    }

    public String getNetworkRequestId() {
        return this.networkRequestId;
    }

    public void setWorkerId (String workerId) {
        this.workerId = workerId;
    }

    public String getWorkerId() {
        return this.workerId;
    }

    public void setArgs (java.util.List<jpuppeteer.cdp.client.entity.runtime.RemoteObject> args) {
        this.args = args;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.runtime.RemoteObject> getArgs() {
        return this.args;
    }

    public LogEntry(jpuppeteer.cdp.client.constant.log.LogEntrySource source, jpuppeteer.cdp.client.constant.log.LogEntryLevel level, String text, java.math.BigDecimal timestamp, String url, Integer lineNumber, jpuppeteer.cdp.client.entity.runtime.StackTrace stackTrace, String networkRequestId, String workerId, java.util.List<jpuppeteer.cdp.client.entity.runtime.RemoteObject> args) {
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

    public LogEntry(jpuppeteer.cdp.client.constant.log.LogEntrySource source, jpuppeteer.cdp.client.constant.log.LogEntryLevel level, String text, java.math.BigDecimal timestamp) {
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

    public LogEntry() {
    }

}