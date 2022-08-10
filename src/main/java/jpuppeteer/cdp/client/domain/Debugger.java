package jpuppeteer.cdp.client.domain;

/**
*/
public class Debugger {

    private jpuppeteer.cdp.CDPConnection connection;

    public Debugger(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Continues execution until specific location is reached.
    */
    public jpuppeteer.util.XFuture<?> continueToLocation(jpuppeteer.cdp.client.entity.debugger.ContinueToLocationRequest request) {
        return connection.send("Debugger.continueToLocation", request);
    }


    /**
    * Disables debugger for given page.
    */
    public jpuppeteer.util.XFuture<?> disable() {
        return connection.send("Debugger.disable", null);
    }


    /**
    * Enables debugger for the given page. Clients should not assume that the debugging has been enabled until the result for this command is received.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.debugger.EnableResponse> enable(jpuppeteer.cdp.client.entity.debugger.EnableRequest request) {
        return connection.send("Debugger.enable", request, jpuppeteer.cdp.client.entity.debugger.EnableResponse.class);
    }


    /**
    * Evaluates expression on a given call frame.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.debugger.EvaluateOnCallFrameResponse> evaluateOnCallFrame(jpuppeteer.cdp.client.entity.debugger.EvaluateOnCallFrameRequest request) {
        return connection.send("Debugger.evaluateOnCallFrame", request, jpuppeteer.cdp.client.entity.debugger.EvaluateOnCallFrameResponse.class);
    }


    /**
    * Returns possible locations for breakpoint. scriptId in start and end range locations should be the same.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.debugger.GetPossibleBreakpointsResponse> getPossibleBreakpoints(jpuppeteer.cdp.client.entity.debugger.GetPossibleBreakpointsRequest request) {
        return connection.send("Debugger.getPossibleBreakpoints", request, jpuppeteer.cdp.client.entity.debugger.GetPossibleBreakpointsResponse.class);
    }


    /**
    * Returns source for the script with given id.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.debugger.GetScriptSourceResponse> getScriptSource(jpuppeteer.cdp.client.entity.debugger.GetScriptSourceRequest request) {
        return connection.send("Debugger.getScriptSource", request, jpuppeteer.cdp.client.entity.debugger.GetScriptSourceResponse.class);
    }


    /**
    * This command is deprecated. Use getScriptSource instead.
    */
    @java.lang.Deprecated
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.debugger.GetWasmBytecodeResponse> getWasmBytecode(jpuppeteer.cdp.client.entity.debugger.GetWasmBytecodeRequest request) {
        return connection.send("Debugger.getWasmBytecode", request, jpuppeteer.cdp.client.entity.debugger.GetWasmBytecodeResponse.class);
    }


    /**
    * Returns stack trace with given `stackTraceId`.
    * experimental
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.debugger.GetStackTraceResponse> getStackTrace(jpuppeteer.cdp.client.entity.debugger.GetStackTraceRequest request) {
        return connection.send("Debugger.getStackTrace", request, jpuppeteer.cdp.client.entity.debugger.GetStackTraceResponse.class);
    }


    /**
    * Stops on the next JavaScript statement.
    */
    public jpuppeteer.util.XFuture<?> pause() {
        return connection.send("Debugger.pause", null);
    }


    /**
    * experimental
    */
    @java.lang.Deprecated
    public jpuppeteer.util.XFuture<?> pauseOnAsyncCall(jpuppeteer.cdp.client.entity.debugger.PauseOnAsyncCallRequest request) {
        return connection.send("Debugger.pauseOnAsyncCall", request);
    }


    /**
    * Removes JavaScript breakpoint.
    */
    public jpuppeteer.util.XFuture<?> removeBreakpoint(jpuppeteer.cdp.client.entity.debugger.RemoveBreakpointRequest request) {
        return connection.send("Debugger.removeBreakpoint", request);
    }


    /**
    * Restarts particular call frame from the beginning.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.debugger.RestartFrameResponse> restartFrame(jpuppeteer.cdp.client.entity.debugger.RestartFrameRequest request) {
        return connection.send("Debugger.restartFrame", request, jpuppeteer.cdp.client.entity.debugger.RestartFrameResponse.class);
    }


    /**
    * Resumes JavaScript execution.
    */
    public jpuppeteer.util.XFuture<?> resume(jpuppeteer.cdp.client.entity.debugger.ResumeRequest request) {
        return connection.send("Debugger.resume", request);
    }


    /**
    * Searches for given string in script content.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.debugger.SearchInContentResponse> searchInContent(jpuppeteer.cdp.client.entity.debugger.SearchInContentRequest request) {
        return connection.send("Debugger.searchInContent", request, jpuppeteer.cdp.client.entity.debugger.SearchInContentResponse.class);
    }


    /**
    * Enables or disables async call stacks tracking.
    */
    public jpuppeteer.util.XFuture<?> setAsyncCallStackDepth(jpuppeteer.cdp.client.entity.debugger.SetAsyncCallStackDepthRequest request) {
        return connection.send("Debugger.setAsyncCallStackDepth", request);
    }


    /**
    * Replace previous blackbox patterns with passed ones. Forces backend to skip stepping/pausing in scripts with url matching one of the patterns. VM will try to leave blackboxed script by performing 'step in' several times, finally resorting to 'step out' if unsuccessful.
    * experimental
    */
    public jpuppeteer.util.XFuture<?> setBlackboxPatterns(jpuppeteer.cdp.client.entity.debugger.SetBlackboxPatternsRequest request) {
        return connection.send("Debugger.setBlackboxPatterns", request);
    }


    /**
    * Makes backend skip steps in the script in blackboxed ranges. VM will try leave blacklisted scripts by performing 'step in' several times, finally resorting to 'step out' if unsuccessful. Positions array contains positions where blackbox state is changed. First interval isn't blackboxed. Array should be sorted.
    * experimental
    */
    public jpuppeteer.util.XFuture<?> setBlackboxedRanges(jpuppeteer.cdp.client.entity.debugger.SetBlackboxedRangesRequest request) {
        return connection.send("Debugger.setBlackboxedRanges", request);
    }


    /**
    * Sets JavaScript breakpoint at a given location.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.debugger.SetBreakpointResponse> setBreakpoint(jpuppeteer.cdp.client.entity.debugger.SetBreakpointRequest request) {
        return connection.send("Debugger.setBreakpoint", request, jpuppeteer.cdp.client.entity.debugger.SetBreakpointResponse.class);
    }


    /**
    * Sets instrumentation breakpoint.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.debugger.SetInstrumentationBreakpointResponse> setInstrumentationBreakpoint(jpuppeteer.cdp.client.entity.debugger.SetInstrumentationBreakpointRequest request) {
        return connection.send("Debugger.setInstrumentationBreakpoint", request, jpuppeteer.cdp.client.entity.debugger.SetInstrumentationBreakpointResponse.class);
    }


    /**
    * Sets JavaScript breakpoint at given location specified either by URL or URL regex. Once this command is issued, all existing parsed scripts will have breakpoints resolved and returned in `locations` property. Further matching script parsing will result in subsequent `breakpointResolved` events issued. This logical breakpoint will survive page reloads.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.debugger.SetBreakpointByUrlResponse> setBreakpointByUrl(jpuppeteer.cdp.client.entity.debugger.SetBreakpointByUrlRequest request) {
        return connection.send("Debugger.setBreakpointByUrl", request, jpuppeteer.cdp.client.entity.debugger.SetBreakpointByUrlResponse.class);
    }


    /**
    * Sets JavaScript breakpoint before each call to the given function. If another function was created from the same source as a given one, calling it will also trigger the breakpoint.
    * experimental
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.debugger.SetBreakpointOnFunctionCallResponse> setBreakpointOnFunctionCall(jpuppeteer.cdp.client.entity.debugger.SetBreakpointOnFunctionCallRequest request) {
        return connection.send("Debugger.setBreakpointOnFunctionCall", request, jpuppeteer.cdp.client.entity.debugger.SetBreakpointOnFunctionCallResponse.class);
    }


    /**
    * Activates / deactivates all breakpoints on the page.
    */
    public jpuppeteer.util.XFuture<?> setBreakpointsActive(jpuppeteer.cdp.client.entity.debugger.SetBreakpointsActiveRequest request) {
        return connection.send("Debugger.setBreakpointsActive", request);
    }


    /**
    * Defines pause on exceptions state. Can be set to stop on all exceptions, uncaught exceptions or no exceptions. Initial pause on exceptions state is `none`.
    */
    public jpuppeteer.util.XFuture<?> setPauseOnExceptions(jpuppeteer.cdp.client.entity.debugger.SetPauseOnExceptionsRequest request) {
        return connection.send("Debugger.setPauseOnExceptions", request);
    }


    /**
    * Changes return value in top frame. Available only at return break position.
    * experimental
    */
    public jpuppeteer.util.XFuture<?> setReturnValue(jpuppeteer.cdp.client.entity.debugger.SetReturnValueRequest request) {
        return connection.send("Debugger.setReturnValue", request);
    }


    /**
    * Edits JavaScript source live.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.debugger.SetScriptSourceResponse> setScriptSource(jpuppeteer.cdp.client.entity.debugger.SetScriptSourceRequest request) {
        return connection.send("Debugger.setScriptSource", request, jpuppeteer.cdp.client.entity.debugger.SetScriptSourceResponse.class);
    }


    /**
    * Makes page not interrupt on any pauses (breakpoint, exception, dom exception etc).
    */
    public jpuppeteer.util.XFuture<?> setSkipAllPauses(jpuppeteer.cdp.client.entity.debugger.SetSkipAllPausesRequest request) {
        return connection.send("Debugger.setSkipAllPauses", request);
    }


    /**
    * Changes value of variable in a callframe. Object-based scopes are not supported and must be mutated manually.
    */
    public jpuppeteer.util.XFuture<?> setVariableValue(jpuppeteer.cdp.client.entity.debugger.SetVariableValueRequest request) {
        return connection.send("Debugger.setVariableValue", request);
    }


    /**
    * Steps into the function call.
    */
    public jpuppeteer.util.XFuture<?> stepInto(jpuppeteer.cdp.client.entity.debugger.StepIntoRequest request) {
        return connection.send("Debugger.stepInto", request);
    }


    /**
    * Steps out of the function call.
    */
    public jpuppeteer.util.XFuture<?> stepOut() {
        return connection.send("Debugger.stepOut", null);
    }


    /**
    * Steps over the statement.
    */
    public jpuppeteer.util.XFuture<?> stepOver(jpuppeteer.cdp.client.entity.debugger.StepOverRequest request) {
        return connection.send("Debugger.stepOver", request);
    }

}