package jpuppeteer.cdp.cdp.domain;

/**
*/
public class DOMDebugger {

    private jpuppeteer.cdp.CDPSession session;

    public DOMDebugger(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Returns event listeners of the given object.
    */
    public jpuppeteer.cdp.cdp.entity.domdebugger.GetEventListenersResponse getEventListeners(jpuppeteer.cdp.cdp.entity.domdebugger.GetEventListenersRequest request, int timeout) throws Exception {
        return session.send("DOMDebugger.getEventListeners", request, jpuppeteer.cdp.cdp.entity.domdebugger.GetEventListenersResponse.class, timeout);
    }


    /**
    * Removes DOM breakpoint that was set using `setDOMBreakpoint`.
    */
    public void removeDOMBreakpoint(jpuppeteer.cdp.cdp.entity.domdebugger.RemoveDOMBreakpointRequest request, int timeout) throws Exception {
        session.send("DOMDebugger.removeDOMBreakpoint", request, timeout);
    }


    /**
    * Removes breakpoint on particular DOM event.
    */
    public void removeEventListenerBreakpoint(jpuppeteer.cdp.cdp.entity.domdebugger.RemoveEventListenerBreakpointRequest request, int timeout) throws Exception {
        session.send("DOMDebugger.removeEventListenerBreakpoint", request, timeout);
    }


    /**
    * Removes breakpoint on particular native event.
    */
    public void removeInstrumentationBreakpoint(jpuppeteer.cdp.cdp.entity.domdebugger.RemoveInstrumentationBreakpointRequest request, int timeout) throws Exception {
        session.send("DOMDebugger.removeInstrumentationBreakpoint", request, timeout);
    }


    /**
    * Removes breakpoint from XMLHttpRequest.
    */
    public void removeXHRBreakpoint(jpuppeteer.cdp.cdp.entity.domdebugger.RemoveXHRBreakpointRequest request, int timeout) throws Exception {
        session.send("DOMDebugger.removeXHRBreakpoint", request, timeout);
    }


    /**
    * Sets breakpoint on particular operation with DOM.
    */
    public void setDOMBreakpoint(jpuppeteer.cdp.cdp.entity.domdebugger.SetDOMBreakpointRequest request, int timeout) throws Exception {
        session.send("DOMDebugger.setDOMBreakpoint", request, timeout);
    }


    /**
    * Sets breakpoint on particular DOM event.
    */
    public void setEventListenerBreakpoint(jpuppeteer.cdp.cdp.entity.domdebugger.SetEventListenerBreakpointRequest request, int timeout) throws Exception {
        session.send("DOMDebugger.setEventListenerBreakpoint", request, timeout);
    }


    /**
    * Sets breakpoint on particular native event.
    */
    public void setInstrumentationBreakpoint(jpuppeteer.cdp.cdp.entity.domdebugger.SetInstrumentationBreakpointRequest request, int timeout) throws Exception {
        session.send("DOMDebugger.setInstrumentationBreakpoint", request, timeout);
    }


    /**
    * Sets breakpoint on XMLHttpRequest.
    */
    public void setXHRBreakpoint(jpuppeteer.cdp.cdp.entity.domdebugger.SetXHRBreakpointRequest request, int timeout) throws Exception {
        session.send("DOMDebugger.setXHRBreakpoint", request, timeout);
    }

}