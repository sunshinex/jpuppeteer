package jpuppeteer.cdp.client.entity.domdebugger;

/**
* Object event listener.
*/
public class EventListener {

    /**
    * `EventListener`'s type.
    */
    public final String type;

    /**
    * `EventListener`'s useCapture.
    */
    public final Boolean useCapture;

    /**
    * `EventListener`'s passive flag.
    */
    public final Boolean passive;

    /**
    * `EventListener`'s once flag.
    */
    public final Boolean once;

    /**
    * Script id of the handler code.
    */
    public final String scriptId;

    /**
    * Line number in the script (0-based).
    */
    public final Integer lineNumber;

    /**
    * Column number in the script (0-based).
    */
    public final Integer columnNumber;

    /**
    * Event handler function value.
    */
    public final jpuppeteer.cdp.client.entity.runtime.RemoteObject handler;

    /**
    * Event original handler function value.
    */
    public final jpuppeteer.cdp.client.entity.runtime.RemoteObject originalHandler;

    /**
    * Node the listener is added to (if any).
    */
    public final Integer backendNodeId;

    public EventListener(String type, Boolean useCapture, Boolean passive, Boolean once, String scriptId, Integer lineNumber, Integer columnNumber, jpuppeteer.cdp.client.entity.runtime.RemoteObject handler, jpuppeteer.cdp.client.entity.runtime.RemoteObject originalHandler, Integer backendNodeId) {
        this.type = type;
        this.useCapture = useCapture;
        this.passive = passive;
        this.once = once;
        this.scriptId = scriptId;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
        this.handler = handler;
        this.originalHandler = originalHandler;
        this.backendNodeId = backendNodeId;
    }

    public EventListener(String type, Boolean useCapture, Boolean passive, Boolean once, String scriptId, Integer lineNumber, Integer columnNumber) {
        this.type = type;
        this.useCapture = useCapture;
        this.passive = passive;
        this.once = once;
        this.scriptId = scriptId;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
        this.handler = null;
        this.originalHandler = null;
        this.backendNodeId = null;
    }

}