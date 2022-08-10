package jpuppeteer.cdp.client.entity.runtime;

/**
* Detailed information about exception (or error) that was thrown during script compilation or execution.
*/
public class ExceptionDetails {

    /**
    * Exception id.
    */
    private Integer exceptionId;

    /**
    * Exception text, which should be used together with exception object when available.
    */
    private String text;

    /**
    * Line number of the exception location (0-based).
    */
    private Integer lineNumber;

    /**
    * Column number of the exception location (0-based).
    */
    private Integer columnNumber;

    /**
    * Script ID of the exception location.
    */
    private String scriptId;

    /**
    * URL of the exception location, to be used when the script was not reported.
    */
    private String url;

    /**
    * JavaScript stack trace if available.
    */
    private jpuppeteer.cdp.client.entity.runtime.StackTrace stackTrace;

    /**
    * Exception object if available.
    */
    private jpuppeteer.cdp.client.entity.runtime.RemoteObject exception;

    /**
    * Identifier of the context where exception happened.
    */
    private Integer executionContextId;

    public void setExceptionId (Integer exceptionId) {
        this.exceptionId = exceptionId;
    }

    public Integer getExceptionId() {
        return this.exceptionId;
    }

    public void setText (String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
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

    public void setStackTrace (jpuppeteer.cdp.client.entity.runtime.StackTrace stackTrace) {
        this.stackTrace = stackTrace;
    }

    public jpuppeteer.cdp.client.entity.runtime.StackTrace getStackTrace() {
        return this.stackTrace;
    }

    public void setException (jpuppeteer.cdp.client.entity.runtime.RemoteObject exception) {
        this.exception = exception;
    }

    public jpuppeteer.cdp.client.entity.runtime.RemoteObject getException() {
        return this.exception;
    }

    public void setExecutionContextId (Integer executionContextId) {
        this.executionContextId = executionContextId;
    }

    public Integer getExecutionContextId() {
        return this.executionContextId;
    }

    public ExceptionDetails(Integer exceptionId, String text, Integer lineNumber, Integer columnNumber, String scriptId, String url, jpuppeteer.cdp.client.entity.runtime.StackTrace stackTrace, jpuppeteer.cdp.client.entity.runtime.RemoteObject exception, Integer executionContextId) {
        this.exceptionId = exceptionId;
        this.text = text;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
        this.scriptId = scriptId;
        this.url = url;
        this.stackTrace = stackTrace;
        this.exception = exception;
        this.executionContextId = executionContextId;
    }

    public ExceptionDetails(Integer exceptionId, String text, Integer lineNumber, Integer columnNumber) {
        this.exceptionId = exceptionId;
        this.text = text;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
        this.scriptId = null;
        this.url = null;
        this.stackTrace = null;
        this.exception = null;
        this.executionContextId = null;
    }

    public ExceptionDetails() {
    }

}