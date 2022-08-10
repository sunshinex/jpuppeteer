package jpuppeteer.cdp.client.entity.network;

/**
* Information about the request initiator.
*/
public class Initiator {

    /**
    * Type of this initiator.
    */
    private jpuppeteer.cdp.client.constant.network.InitiatorType type;

    /**
    * Initiator JavaScript stack trace, set for Script only.
    */
    private jpuppeteer.cdp.client.entity.runtime.StackTrace stack;

    /**
    * Initiator URL, set for Parser type or for Script type (when script is importing module) or for SignedExchange type.
    */
    private String url;

    /**
    * Initiator line number, set for Parser type or for Script type (when script is importing module) (0-based).
    */
    private java.math.BigDecimal lineNumber;

    /**
    * Initiator column number, set for Parser type or for Script type (when script is importing module) (0-based).
    */
    private java.math.BigDecimal columnNumber;

    /**
    * Set if another request triggered this request (e.g. preflight).
    */
    private String requestId;

    public void setType (jpuppeteer.cdp.client.constant.network.InitiatorType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.network.InitiatorType getType() {
        return this.type;
    }

    public void setStack (jpuppeteer.cdp.client.entity.runtime.StackTrace stack) {
        this.stack = stack;
    }

    public jpuppeteer.cdp.client.entity.runtime.StackTrace getStack() {
        return this.stack;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setLineNumber (java.math.BigDecimal lineNumber) {
        this.lineNumber = lineNumber;
    }

    public java.math.BigDecimal getLineNumber() {
        return this.lineNumber;
    }

    public void setColumnNumber (java.math.BigDecimal columnNumber) {
        this.columnNumber = columnNumber;
    }

    public java.math.BigDecimal getColumnNumber() {
        return this.columnNumber;
    }

    public void setRequestId (String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public Initiator(jpuppeteer.cdp.client.constant.network.InitiatorType type, jpuppeteer.cdp.client.entity.runtime.StackTrace stack, String url, java.math.BigDecimal lineNumber, java.math.BigDecimal columnNumber, String requestId) {
        this.type = type;
        this.stack = stack;
        this.url = url;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
        this.requestId = requestId;
    }

    public Initiator(jpuppeteer.cdp.client.constant.network.InitiatorType type) {
        this.type = type;
        this.stack = null;
        this.url = null;
        this.lineNumber = null;
        this.columnNumber = null;
        this.requestId = null;
    }

    public Initiator() {
    }

}