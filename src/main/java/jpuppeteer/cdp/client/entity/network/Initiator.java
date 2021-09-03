package jpuppeteer.cdp.client.entity.network;

/**
* Information about the request initiator.
*/
public class Initiator {

    /**
    * Type of this initiator.
    */
    public final jpuppeteer.cdp.client.constant.network.InitiatorType type;

    /**
    * Initiator JavaScript stack trace, set for Script only.
    */
    public final jpuppeteer.cdp.client.entity.runtime.StackTrace stack;

    /**
    * Initiator URL, set for Parser type or for Script type (when script is importing module) or for SignedExchange type.
    */
    public final String url;

    /**
    * Initiator line number, set for Parser type or for Script type (when script is importing module) (0-based).
    */
    public final java.math.BigDecimal lineNumber;

    /**
    * Initiator column number, set for Parser type or for Script type (when script is importing module) (0-based).
    */
    public final java.math.BigDecimal columnNumber;

    /**
    * Set if another request triggered this request (e.g. preflight).
    */
    public final String requestId;

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

}