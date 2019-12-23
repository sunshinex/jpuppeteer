package jpuppeteer.cdp.cdp.domain;

/**
*/
public class Debugger {

    private jpuppeteer.cdp.CDPSession session;

    public Debugger(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Continues execution until specific location is reached.
    */
    public void continueToLocation(jpuppeteer.cdp.cdp.entity.debugger.ContinueToLocationRequest request, int timeout) throws Exception {
        session.send("Debugger.continueToLocation", request, timeout);
    }


    /**
    * Disables debugger for given page.
    */
    public void disable(int timeout) throws Exception {
        session.send("Debugger.disable", null, timeout);
    }


    /**
    * Enables debugger for the given page. Clients should not assume that the debugging has been enabled until the result for this command is received.
    */
    public jpuppeteer.cdp.cdp.entity.debugger.EnableResponse enable(jpuppeteer.cdp.cdp.entity.debugger.EnableRequest request, int timeout) throws Exception {
        return session.send("Debugger.enable", request, jpuppeteer.cdp.cdp.entity.debugger.EnableResponse.class, timeout);
    }


    /**
    * Evaluates expression on a given call frame.
    */
    public jpuppeteer.cdp.cdp.entity.debugger.EvaluateOnCallFrameResponse evaluateOnCallFrame(jpuppeteer.cdp.cdp.entity.debugger.EvaluateOnCallFrameRequest request, int timeout) throws Exception {
        return session.send("Debugger.evaluateOnCallFrame", request, jpuppeteer.cdp.cdp.entity.debugger.EvaluateOnCallFrameResponse.class, timeout);
    }


    /**
    * Returns possible locations for breakpoint. scriptId in start and end range locations should be the same.
    */
    public jpuppeteer.cdp.cdp.entity.debugger.GetPossibleBreakpointsResponse getPossibleBreakpoints(jpuppeteer.cdp.cdp.entity.debugger.GetPossibleBreakpointsRequest request, int timeout) throws Exception {
        return session.send("Debugger.getPossibleBreakpoints", request, jpuppeteer.cdp.cdp.entity.debugger.GetPossibleBreakpointsResponse.class, timeout);
    }


    /**
    * Returns source for the script with given id.
    */
    public jpuppeteer.cdp.cdp.entity.debugger.GetScriptSourceResponse getScriptSource(jpuppeteer.cdp.cdp.entity.debugger.GetScriptSourceRequest request, int timeout) throws Exception {
        return session.send("Debugger.getScriptSource", request, jpuppeteer.cdp.cdp.entity.debugger.GetScriptSourceResponse.class, timeout);
    }


    /**
    * Returns stack trace with given `stackTraceId`.
    */
    public jpuppeteer.cdp.cdp.entity.debugger.GetStackTraceResponse getStackTrace(jpuppeteer.cdp.cdp.entity.debugger.GetStackTraceRequest request, int timeout) throws Exception {
        return session.send("Debugger.getStackTrace", request, jpuppeteer.cdp.cdp.entity.debugger.GetStackTraceResponse.class, timeout);
    }


    /**
    * Stops on the next JavaScript statement.
    */
    public void pause(int timeout) throws Exception {
        session.send("Debugger.pause", null, timeout);
    }


    /**
    */
    public void pauseOnAsyncCall(jpuppeteer.cdp.cdp.entity.debugger.PauseOnAsyncCallRequest request, int timeout) throws Exception {
        session.send("Debugger.pauseOnAsyncCall", request, timeout);
    }


    /**
    * Removes JavaScript breakpoint.
    */
    public void removeBreakpoint(jpuppeteer.cdp.cdp.entity.debugger.RemoveBreakpointRequest request, int timeout) throws Exception {
        session.send("Debugger.removeBreakpoint", request, timeout);
    }


    /**
    * Restarts particular call frame from the beginning.
    */
    public jpuppeteer.cdp.cdp.entity.debugger.RestartFrameResponse restartFrame(jpuppeteer.cdp.cdp.entity.debugger.RestartFrameRequest request, int timeout) throws Exception {
        return session.send("Debugger.restartFrame", request, jpuppeteer.cdp.cdp.entity.debugger.RestartFrameResponse.class, timeout);
    }


    /**
    * Resumes JavaScript execution.
    */
    public void resume(int timeout) throws Exception {
        session.send("Debugger.resume", null, timeout);
    }


    /**
    * Searches for given string in script content.
    */
    public jpuppeteer.cdp.cdp.entity.debugger.SearchInContentResponse searchInContent(jpuppeteer.cdp.cdp.entity.debugger.SearchInContentRequest request, int timeout) throws Exception {
        return session.send("Debugger.searchInContent", request, jpuppeteer.cdp.cdp.entity.debugger.SearchInContentResponse.class, timeout);
    }


    /**
    * Enables or disables async call stacks tracking.
    */
    public void setAsyncCallStackDepth(jpuppeteer.cdp.cdp.entity.debugger.SetAsyncCallStackDepthRequest request, int timeout) throws Exception {
        session.send("Debugger.setAsyncCallStackDepth", request, timeout);
    }


    /**
    * Replace previous blackbox patterns with passed ones. Forces backend to skip stepping/pausing in scripts with url matching one of the patterns. VM will try to leave blackboxed script by performing 'step in' several times, finally resorting to 'step out' if unsuccessful.
    */
    public void setBlackboxPatterns(jpuppeteer.cdp.cdp.entity.debugger.SetBlackboxPatternsRequest request, int timeout) throws Exception {
        session.send("Debugger.setBlackboxPatterns", request, timeout);
    }


    /**
    * Makes backend skip steps in the script in blackboxed ranges. VM will try leave blacklisted scripts by performing 'step in' several times, finally resorting to 'step out' if unsuccessful. Positions array contains positions where blackbox state is changed. First interval isn't blackboxed. Array should be sorted.
    */
    public void setBlackboxedRanges(jpuppeteer.cdp.cdp.entity.debugger.SetBlackboxedRangesRequest request, int timeout) throws Exception {
        session.send("Debugger.setBlackboxedRanges", request, timeout);
    }


    /**
    * Sets JavaScript breakpoint at a given location.
    */
    public jpuppeteer.cdp.cdp.entity.debugger.SetBreakpointResponse setBreakpoint(jpuppeteer.cdp.cdp.entity.debugger.SetBreakpointRequest request, int timeout) throws Exception {
        return session.send("Debugger.setBreakpoint", request, jpuppeteer.cdp.cdp.entity.debugger.SetBreakpointResponse.class, timeout);
    }


    /**
    * Sets instrumentation breakpoint.
    */
    public jpuppeteer.cdp.cdp.entity.debugger.SetInstrumentationBreakpointResponse setInstrumentationBreakpoint(jpuppeteer.cdp.cdp.entity.debugger.SetInstrumentationBreakpointRequest request, int timeout) throws Exception {
        return session.send("Debugger.setInstrumentationBreakpoint", request, jpuppeteer.cdp.cdp.entity.debugger.SetInstrumentationBreakpointResponse.class, timeout);
    }


    /**
    * Sets JavaScript breakpoint at given location specified either by URL or URL regex. Once this command is issued, all existing parsed scripts will have breakpoints resolved and returned in `locations` property. Further matching script parsing will result in subsequent `breakpointResolved` events issued. This logical breakpoint will survive page reloads.
    */
    public jpuppeteer.cdp.cdp.entity.debugger.SetBreakpointByUrlResponse setBreakpointByUrl(jpuppeteer.cdp.cdp.entity.debugger.SetBreakpointByUrlRequest request, int timeout) throws Exception {
        return session.send("Debugger.setBreakpointByUrl", request, jpuppeteer.cdp.cdp.entity.debugger.SetBreakpointByUrlResponse.class, timeout);
    }


    /**
    * Sets JavaScript breakpoint before each call to the given function. If another function was created from the same source as a given one, calling it will also trigger the breakpoint.
    */
    public jpuppeteer.cdp.cdp.entity.debugger.SetBreakpointOnFunctionCallResponse setBreakpointOnFunctionCall(jpuppeteer.cdp.cdp.entity.debugger.SetBreakpointOnFunctionCallRequest request, int timeout) throws Exception {
        return session.send("Debugger.setBreakpointOnFunctionCall", request, jpuppeteer.cdp.cdp.entity.debugger.SetBreakpointOnFunctionCallResponse.class, timeout);
    }


    /**
    * Activates / deactivates all breakpoints on the page.
    */
    public void setBreakpointsActive(jpuppeteer.cdp.cdp.entity.debugger.SetBreakpointsActiveRequest request, int timeout) throws Exception {
        session.send("Debugger.setBreakpointsActive", request, timeout);
    }


    /**
    * Defines pause on exceptions state. Can be set to stop on all exceptions, uncaught exceptions or no exceptions. Initial pause on exceptions state is `none`.
    */
    public void setPauseOnExceptions(jpuppeteer.cdp.cdp.entity.debugger.SetPauseOnExceptionsRequest request, int timeout) throws Exception {
        session.send("Debugger.setPauseOnExceptions", request, timeout);
    }


    /**
    * Changes return value in top frame. Available only at return break position.
    */
    public void setReturnValue(jpuppeteer.cdp.cdp.entity.debugger.SetReturnValueRequest request, int timeout) throws Exception {
        session.send("Debugger.setReturnValue", request, timeout);
    }


    /**
    * Edits JavaScript source live.
    */
    public jpuppeteer.cdp.cdp.entity.debugger.SetScriptSourceResponse setScriptSource(jpuppeteer.cdp.cdp.entity.debugger.SetScriptSourceRequest request, int timeout) throws Exception {
        return session.send("Debugger.setScriptSource", request, jpuppeteer.cdp.cdp.entity.debugger.SetScriptSourceResponse.class, timeout);
    }


    /**
    * Makes page not interrupt on any pauses (breakpoint, exception, dom exception etc).
    */
    public void setSkipAllPauses(jpuppeteer.cdp.cdp.entity.debugger.SetSkipAllPausesRequest request, int timeout) throws Exception {
        session.send("Debugger.setSkipAllPauses", request, timeout);
    }


    /**
    * Changes value of variable in a callframe. Object-based scopes are not supported and must be mutated manually.
    */
    public void setVariableValue(jpuppeteer.cdp.cdp.entity.debugger.SetVariableValueRequest request, int timeout) throws Exception {
        session.send("Debugger.setVariableValue", request, timeout);
    }


    /**
    * Steps into the function call.
    */
    public void stepInto(jpuppeteer.cdp.cdp.entity.debugger.StepIntoRequest request, int timeout) throws Exception {
        session.send("Debugger.stepInto", request, timeout);
    }


    /**
    * Steps out of the function call.
    */
    public void stepOut(int timeout) throws Exception {
        session.send("Debugger.stepOut", null, timeout);
    }


    /**
    * Steps over the statement.
    */
    public void stepOver(int timeout) throws Exception {
        session.send("Debugger.stepOver", null, timeout);
    }

}