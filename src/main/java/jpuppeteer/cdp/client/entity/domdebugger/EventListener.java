package jpuppeteer.cdp.client.entity.domdebugger;

/**
* Object event listener.
*/
public class EventListener {

    /**
    * `EventListener`'s type.
    */
    private String type;

    /**
    * `EventListener`'s useCapture.
    */
    private Boolean useCapture;

    /**
    * `EventListener`'s passive flag.
    */
    private Boolean passive;

    /**
    * `EventListener`'s once flag.
    */
    private Boolean once;

    /**
    * Script id of the handler code.
    */
    private String scriptId;

    /**
    * Line number in the script (0-based).
    */
    private Integer lineNumber;

    /**
    * Column number in the script (0-based).
    */
    private Integer columnNumber;

    /**
    * Event handler function value.
    */
    private jpuppeteer.cdp.client.entity.runtime.RemoteObject handler;

    /**
    * Event original handler function value.
    */
    private jpuppeteer.cdp.client.entity.runtime.RemoteObject originalHandler;

    /**
    * Node the listener is added to (if any).
    */
    private Integer backendNodeId;

    public void setType (String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setUseCapture (Boolean useCapture) {
        this.useCapture = useCapture;
    }

    public Boolean getUseCapture() {
        return this.useCapture;
    }

    public void setPassive (Boolean passive) {
        this.passive = passive;
    }

    public Boolean getPassive() {
        return this.passive;
    }

    public void setOnce (Boolean once) {
        this.once = once;
    }

    public Boolean getOnce() {
        return this.once;
    }

    public void setScriptId (String scriptId) {
        this.scriptId = scriptId;
    }

    public String getScriptId() {
        return this.scriptId;
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

    public void setHandler (jpuppeteer.cdp.client.entity.runtime.RemoteObject handler) {
        this.handler = handler;
    }

    public jpuppeteer.cdp.client.entity.runtime.RemoteObject getHandler() {
        return this.handler;
    }

    public void setOriginalHandler (jpuppeteer.cdp.client.entity.runtime.RemoteObject originalHandler) {
        this.originalHandler = originalHandler;
    }

    public jpuppeteer.cdp.client.entity.runtime.RemoteObject getOriginalHandler() {
        return this.originalHandler;
    }

    public void setBackendNodeId (Integer backendNodeId) {
        this.backendNodeId = backendNodeId;
    }

    public Integer getBackendNodeId() {
        return this.backendNodeId;
    }

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

    public EventListener() {
    }

}