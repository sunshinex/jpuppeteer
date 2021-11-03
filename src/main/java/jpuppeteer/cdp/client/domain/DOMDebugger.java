package jpuppeteer.cdp.client.domain;

/**
*/
public class DOMDebugger {

    private jpuppeteer.cdp.CDPConnection connection;

    public DOMDebugger(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Returns event listeners of the given object.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.domdebugger.GetEventListenersResponse> getEventListeners(jpuppeteer.cdp.client.entity.domdebugger.GetEventListenersRequest request) {
        return connection.send("DOMDebugger.getEventListeners", request, jpuppeteer.cdp.client.entity.domdebugger.GetEventListenersResponse.class);
    }


    /**
    * Removes DOM breakpoint that was set using `setDOMBreakpoint`.
    */
    public io.netty.util.concurrent.Future removeDOMBreakpoint(jpuppeteer.cdp.client.entity.domdebugger.RemoveDOMBreakpointRequest request) {
        return connection.send("DOMDebugger.removeDOMBreakpoint", request);
    }


    /**
    * Removes breakpoint on particular DOM event.
    */
    public io.netty.util.concurrent.Future removeEventListenerBreakpoint(jpuppeteer.cdp.client.entity.domdebugger.RemoveEventListenerBreakpointRequest request) {
        return connection.send("DOMDebugger.removeEventListenerBreakpoint", request);
    }


    /**
    * Removes breakpoint on particular native event.
    * experimental
    */
    public io.netty.util.concurrent.Future removeInstrumentationBreakpoint(jpuppeteer.cdp.client.entity.domdebugger.RemoveInstrumentationBreakpointRequest request) {
        return connection.send("DOMDebugger.removeInstrumentationBreakpoint", request);
    }


    /**
    * Removes breakpoint from XMLHttpRequest.
    */
    public io.netty.util.concurrent.Future removeXHRBreakpoint(jpuppeteer.cdp.client.entity.domdebugger.RemoveXHRBreakpointRequest request) {
        return connection.send("DOMDebugger.removeXHRBreakpoint", request);
    }


    /**
    * Sets breakpoint on particular CSP violations.
    * experimental
    */
    public io.netty.util.concurrent.Future setBreakOnCSPViolation(jpuppeteer.cdp.client.entity.domdebugger.SetBreakOnCSPViolationRequest request) {
        return connection.send("DOMDebugger.setBreakOnCSPViolation", request);
    }


    /**
    * Sets breakpoint on particular operation with DOM.
    */
    public io.netty.util.concurrent.Future setDOMBreakpoint(jpuppeteer.cdp.client.entity.domdebugger.SetDOMBreakpointRequest request) {
        return connection.send("DOMDebugger.setDOMBreakpoint", request);
    }


    /**
    * Sets breakpoint on particular DOM event.
    */
    public io.netty.util.concurrent.Future setEventListenerBreakpoint(jpuppeteer.cdp.client.entity.domdebugger.SetEventListenerBreakpointRequest request) {
        return connection.send("DOMDebugger.setEventListenerBreakpoint", request);
    }


    /**
    * Sets breakpoint on particular native event.
    * experimental
    */
    public io.netty.util.concurrent.Future setInstrumentationBreakpoint(jpuppeteer.cdp.client.entity.domdebugger.SetInstrumentationBreakpointRequest request) {
        return connection.send("DOMDebugger.setInstrumentationBreakpoint", request);
    }


    /**
    * Sets breakpoint on XMLHttpRequest.
    */
    public io.netty.util.concurrent.Future setXHRBreakpoint(jpuppeteer.cdp.client.entity.domdebugger.SetXHRBreakpointRequest request) {
        return connection.send("DOMDebugger.setXHRBreakpoint", request);
    }

}