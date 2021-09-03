package jpuppeteer.cdp.client.domain;

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
    public io.netty.util.concurrent.Future continueToLocation(jpuppeteer.cdp.client.entity.debugger.ContinueToLocationRequest request) {
        return session.send("Debugger.continueToLocation", request);
    }


    /**
    * Disables debugger for given page.
    */
    public io.netty.util.concurrent.Future disable() {
        return session.send("Debugger.disable", null);
    }


    /**
    * Enables debugger for the given page. Clients should not assume that the debugging has been enabled until the result for this command is received.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.debugger.EnableResponse> enable(jpuppeteer.cdp.client.entity.debugger.EnableRequest request) {
        return session.send("Debugger.enable", request, jpuppeteer.cdp.client.entity.debugger.EnableResponse.class);
    }


    /**
    * Evaluates expression on a given call frame.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.debugger.EvaluateOnCallFrameResponse> evaluateOnCallFrame(jpuppeteer.cdp.client.entity.debugger.EvaluateOnCallFrameRequest request) {
        return session.send("Debugger.evaluateOnCallFrame", request, jpuppeteer.cdp.client.entity.debugger.EvaluateOnCallFrameResponse.class);
    }


    /**
    * Returns possible locations for breakpoint. scriptId in start and end range locations should be the same.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.debugger.GetPossibleBreakpointsResponse> getPossibleBreakpoints(jpuppeteer.cdp.client.entity.debugger.GetPossibleBreakpointsRequest request) {
        return session.send("Debugger.getPossibleBreakpoints", request, jpuppeteer.cdp.client.entity.debugger.GetPossibleBreakpointsResponse.class);
    }


    /**
    * Returns source for the script with given id.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.debugger.GetScriptSourceResponse> getScriptSource(jpuppeteer.cdp.client.entity.debugger.GetScriptSourceRequest request) {
        return session.send("Debugger.getScriptSource", request, jpuppeteer.cdp.client.entity.debugger.GetScriptSourceResponse.class);
    }


    /**
    * This command is deprecated. Use getScriptSource instead.
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.debugger.GetWasmBytecodeResponse> getWasmBytecode(jpuppeteer.cdp.client.entity.debugger.GetWasmBytecodeRequest request) {
        return session.send("Debugger.getWasmBytecode", request, jpuppeteer.cdp.client.entity.debugger.GetWasmBytecodeResponse.class);
    }


    /**
    * Returns stack trace with given `stackTraceId`.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.debugger.GetStackTraceResponse> getStackTrace(jpuppeteer.cdp.client.entity.debugger.GetStackTraceRequest request) {
        return session.send("Debugger.getStackTrace", request, jpuppeteer.cdp.client.entity.debugger.GetStackTraceResponse.class);
    }


    /**
    * Stops on the next JavaScript statement.
    */
    public io.netty.util.concurrent.Future pause() {
        return session.send("Debugger.pause", null);
    }


    /**
    * experimental
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future pauseOnAsyncCall(jpuppeteer.cdp.client.entity.debugger.PauseOnAsyncCallRequest request) {
        return session.send("Debugger.pauseOnAsyncCall", request);
    }


    /**
    * Removes JavaScript breakpoint.
    */
    public io.netty.util.concurrent.Future removeBreakpoint(jpuppeteer.cdp.client.entity.debugger.RemoveBreakpointRequest request) {
        return session.send("Debugger.removeBreakpoint", request);
    }


    /**
    * Restarts particular call frame from the beginning.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.debugger.RestartFrameResponse> restartFrame(jpuppeteer.cdp.client.entity.debugger.RestartFrameRequest request) {
        return session.send("Debugger.restartFrame", request, jpuppeteer.cdp.client.entity.debugger.RestartFrameResponse.class);
    }


    /**
    * Resumes JavaScript execution.
    */
    public io.netty.util.concurrent.Future resume(jpuppeteer.cdp.client.entity.debugger.ResumeRequest request) {
        return session.send("Debugger.resume", request);
    }


    /**
    * Searches for given string in script content.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.debugger.SearchInContentResponse> searchInContent(jpuppeteer.cdp.client.entity.debugger.SearchInContentRequest request) {
        return session.send("Debugger.searchInContent", request, jpuppeteer.cdp.client.entity.debugger.SearchInContentResponse.class);
    }


    /**
    * Enables or disables async call stacks tracking.
    */
    public io.netty.util.concurrent.Future setAsyncCallStackDepth(jpuppeteer.cdp.client.entity.debugger.SetAsyncCallStackDepthRequest request) {
        return session.send("Debugger.setAsyncCallStackDepth", request);
    }


    /**
    * Replace previous blackbox patterns with passed ones. Forces backend to skip stepping/pausing in scripts with url matching one of the patterns. VM will try to leave blackboxed script by performing 'step in' several times, finally resorting to 'step out' if unsuccessful.
    * experimental
    */
    public io.netty.util.concurrent.Future setBlackboxPatterns(jpuppeteer.cdp.client.entity.debugger.SetBlackboxPatternsRequest request) {
        return session.send("Debugger.setBlackboxPatterns", request);
    }


    /**
    * Makes backend skip steps in the script in blackboxed ranges. VM will try leave blacklisted scripts by performing 'step in' several times, finally resorting to 'step out' if unsuccessful. Positions array contains positions where blackbox state is changed. First interval isn't blackboxed. Array should be sorted.
    * experimental
    */
    public io.netty.util.concurrent.Future setBlackboxedRanges(jpuppeteer.cdp.client.entity.debugger.SetBlackboxedRangesRequest request) {
        return session.send("Debugger.setBlackboxedRanges", request);
    }


    /**
    * Sets JavaScript breakpoint at a given location.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.debugger.SetBreakpointResponse> setBreakpoint(jpuppeteer.cdp.client.entity.debugger.SetBreakpointRequest request) {
        return session.send("Debugger.setBreakpoint", request, jpuppeteer.cdp.client.entity.debugger.SetBreakpointResponse.class);
    }


    /**
    * Sets instrumentation breakpoint.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.debugger.SetInstrumentationBreakpointResponse> setInstrumentationBreakpoint(jpuppeteer.cdp.client.entity.debugger.SetInstrumentationBreakpointRequest request) {
        return session.send("Debugger.setInstrumentationBreakpoint", request, jpuppeteer.cdp.client.entity.debugger.SetInstrumentationBreakpointResponse.class);
    }


    /**
    * Sets JavaScript breakpoint at given location specified either by URL or URL regex. Once this command is issued, all existing parsed scripts will have breakpoints resolved and returned in `locations` property. Further matching script parsing will result in subsequent `breakpointResolved` events issued. This logical breakpoint will survive page reloads.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.debugger.SetBreakpointByUrlResponse> setBreakpointByUrl(jpuppeteer.cdp.client.entity.debugger.SetBreakpointByUrlRequest request) {
        return session.send("Debugger.setBreakpointByUrl", request, jpuppeteer.cdp.client.entity.debugger.SetBreakpointByUrlResponse.class);
    }


    /**
    * Sets JavaScript breakpoint before each call to the given function. If another function was created from the same source as a given one, calling it will also trigger the breakpoint.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.debugger.SetBreakpointOnFunctionCallResponse> setBreakpointOnFunctionCall(jpuppeteer.cdp.client.entity.debugger.SetBreakpointOnFunctionCallRequest request) {
        return session.send("Debugger.setBreakpointOnFunctionCall", request, jpuppeteer.cdp.client.entity.debugger.SetBreakpointOnFunctionCallResponse.class);
    }


    /**
    * Activates / deactivates all breakpoints on the page.
    */
    public io.netty.util.concurrent.Future setBreakpointsActive(jpuppeteer.cdp.client.entity.debugger.SetBreakpointsActiveRequest request) {
        return session.send("Debugger.setBreakpointsActive", request);
    }


    /**
    * Defines pause on exceptions state. Can be set to stop on all exceptions, uncaught exceptions or no exceptions. Initial pause on exceptions state is `none`.
    */
    public io.netty.util.concurrent.Future setPauseOnExceptions(jpuppeteer.cdp.client.entity.debugger.SetPauseOnExceptionsRequest request) {
        return session.send("Debugger.setPauseOnExceptions", request);
    }


    /**
    * Changes return value in top frame. Available only at return break position.
    * experimental
    */
    public io.netty.util.concurrent.Future setReturnValue(jpuppeteer.cdp.client.entity.debugger.SetReturnValueRequest request) {
        return session.send("Debugger.setReturnValue", request);
    }


    /**
    * Edits JavaScript source live.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.debugger.SetScriptSourceResponse> setScriptSource(jpuppeteer.cdp.client.entity.debugger.SetScriptSourceRequest request) {
        return session.send("Debugger.setScriptSource", request, jpuppeteer.cdp.client.entity.debugger.SetScriptSourceResponse.class);
    }


    /**
    * Makes page not interrupt on any pauses (breakpoint, exception, dom exception etc).
    */
    public io.netty.util.concurrent.Future setSkipAllPauses(jpuppeteer.cdp.client.entity.debugger.SetSkipAllPausesRequest request) {
        return session.send("Debugger.setSkipAllPauses", request);
    }


    /**
    * Changes value of variable in a callframe. Object-based scopes are not supported and must be mutated manually.
    */
    public io.netty.util.concurrent.Future setVariableValue(jpuppeteer.cdp.client.entity.debugger.SetVariableValueRequest request) {
        return session.send("Debugger.setVariableValue", request);
    }


    /**
    * Steps into the function call.
    */
    public io.netty.util.concurrent.Future stepInto(jpuppeteer.cdp.client.entity.debugger.StepIntoRequest request) {
        return session.send("Debugger.stepInto", request);
    }


    /**
    * Steps out of the function call.
    */
    public io.netty.util.concurrent.Future stepOut() {
        return session.send("Debugger.stepOut", null);
    }


    /**
    * Steps over the statement.
    */
    public io.netty.util.concurrent.Future stepOver(jpuppeteer.cdp.client.entity.debugger.StepOverRequest request) {
        return session.send("Debugger.stepOver", request);
    }

}