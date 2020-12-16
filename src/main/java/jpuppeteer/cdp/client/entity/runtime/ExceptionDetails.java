package jpuppeteer.cdp.client.entity.runtime;

/**
* Detailed information about exception (or error) that was thrown during script compilation or execution.
*/
public class ExceptionDetails {

    /**
    * Exception id.
    */
    public final Integer exceptionId;

    /**
    * Exception text, which should be used together with exception object when available.
    */
    public final String text;

    /**
    * Line number of the exception location (0-based).
    */
    public final Integer lineNumber;

    /**
    * Column number of the exception location (0-based).
    */
    public final Integer columnNumber;

    /**
    * Script ID of the exception location.
    */
    public final String scriptId;

    /**
    * URL of the exception location, to be used when the script was not reported.
    */
    public final String url;

    /**
    * JavaScript stack trace if available.
    */
    public final StackTrace stackTrace;

    /**
    * Exception object if available.
    */
    public final RemoteObject exception;

    /**
    * Identifier of the context where exception happened.
    */
    public final Integer executionContextId;

    public ExceptionDetails(Integer exceptionId, String text, Integer lineNumber, Integer columnNumber, String scriptId, String url, StackTrace stackTrace, RemoteObject exception, Integer executionContextId) {
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

}