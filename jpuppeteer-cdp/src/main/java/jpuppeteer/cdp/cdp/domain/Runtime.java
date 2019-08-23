package jpuppeteer.cdp.cdp.domain;

/**
*/
public class Runtime {

    private jpuppeteer.cdp.CDPSession session;

    public Runtime(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Add handler to promise with given promise object id.
    */
    public jpuppeteer.cdp.cdp.entity.runtime.AwaitPromiseResponse awaitPromise(jpuppeteer.cdp.cdp.entity.runtime.AwaitPromiseRequest request, int timeout) throws Exception {
        return session.send("Runtime.awaitPromise", request, jpuppeteer.cdp.cdp.entity.runtime.AwaitPromiseResponse.class, timeout);
    }


    /**
    * Calls function with given declaration on the given object. Object group of the result is inherited from the target object.
    */
    public jpuppeteer.cdp.cdp.entity.runtime.CallFunctionOnResponse callFunctionOn(jpuppeteer.cdp.cdp.entity.runtime.CallFunctionOnRequest request, int timeout) throws Exception {
        return session.send("Runtime.callFunctionOn", request, jpuppeteer.cdp.cdp.entity.runtime.CallFunctionOnResponse.class, timeout);
    }


    /**
    * Compiles expression.
    */
    public jpuppeteer.cdp.cdp.entity.runtime.CompileScriptResponse compileScript(jpuppeteer.cdp.cdp.entity.runtime.CompileScriptRequest request, int timeout) throws Exception {
        return session.send("Runtime.compileScript", request, jpuppeteer.cdp.cdp.entity.runtime.CompileScriptResponse.class, timeout);
    }


    /**
    * Disables reporting of execution contexts creation.
    */
    public void disable(int timeout) throws Exception {
        session.send("Runtime.disable", null, timeout);
    }


    /**
    * Discards collected exceptions and console API calls.
    */
    public void discardConsoleEntries(int timeout) throws Exception {
        session.send("Runtime.discardConsoleEntries", null, timeout);
    }


    /**
    * Enables reporting of execution contexts creation by means of `executionContextCreated` event. When the reporting gets enabled the event will be sent immediately for each existing execution context.
    */
    public void enable(int timeout) throws Exception {
        session.send("Runtime.enable", null, timeout);
    }


    /**
    * Evaluates expression on global object.
    */
    public jpuppeteer.cdp.cdp.entity.runtime.EvaluateResponse evaluate(jpuppeteer.cdp.cdp.entity.runtime.EvaluateRequest request, int timeout) throws Exception {
        return session.send("Runtime.evaluate", request, jpuppeteer.cdp.cdp.entity.runtime.EvaluateResponse.class, timeout);
    }


    /**
    * Returns the isolate id.
    */
    public jpuppeteer.cdp.cdp.entity.runtime.GetIsolateIdResponse getIsolateId(int timeout) throws Exception {
        return session.send("Runtime.getIsolateId", null, jpuppeteer.cdp.cdp.entity.runtime.GetIsolateIdResponse.class, timeout);
    }


    /**
    * Returns the JavaScript heap usage. It is the total usage of the corresponding isolate not scoped to a particular Runtime.
    */
    public jpuppeteer.cdp.cdp.entity.runtime.GetHeapUsageResponse getHeapUsage(int timeout) throws Exception {
        return session.send("Runtime.getHeapUsage", null, jpuppeteer.cdp.cdp.entity.runtime.GetHeapUsageResponse.class, timeout);
    }


    /**
    * Returns properties of a given object. Object group of the result is inherited from the target object.
    */
    public jpuppeteer.cdp.cdp.entity.runtime.GetPropertiesResponse getProperties(jpuppeteer.cdp.cdp.entity.runtime.GetPropertiesRequest request, int timeout) throws Exception {
        return session.send("Runtime.getProperties", request, jpuppeteer.cdp.cdp.entity.runtime.GetPropertiesResponse.class, timeout);
    }


    /**
    * Returns all let, const and class variables from global scope.
    */
    public jpuppeteer.cdp.cdp.entity.runtime.GlobalLexicalScopeNamesResponse globalLexicalScopeNames(jpuppeteer.cdp.cdp.entity.runtime.GlobalLexicalScopeNamesRequest request, int timeout) throws Exception {
        return session.send("Runtime.globalLexicalScopeNames", request, jpuppeteer.cdp.cdp.entity.runtime.GlobalLexicalScopeNamesResponse.class, timeout);
    }


    /**
    */
    public jpuppeteer.cdp.cdp.entity.runtime.QueryObjectsResponse queryObjects(jpuppeteer.cdp.cdp.entity.runtime.QueryObjectsRequest request, int timeout) throws Exception {
        return session.send("Runtime.queryObjects", request, jpuppeteer.cdp.cdp.entity.runtime.QueryObjectsResponse.class, timeout);
    }


    /**
    * Releases remote object with given id.
    */
    public void releaseObject(jpuppeteer.cdp.cdp.entity.runtime.ReleaseObjectRequest request, int timeout) throws Exception {
        session.send("Runtime.releaseObject", request, timeout);
    }


    /**
    * Releases all remote objects that belong to a given group.
    */
    public void releaseObjectGroup(jpuppeteer.cdp.cdp.entity.runtime.ReleaseObjectGroupRequest request, int timeout) throws Exception {
        session.send("Runtime.releaseObjectGroup", request, timeout);
    }


    /**
    * Tells inspected instance to run if it was waiting for debugger to attach.
    */
    public void runIfWaitingForDebugger(int timeout) throws Exception {
        session.send("Runtime.runIfWaitingForDebugger", null, timeout);
    }


    /**
    * Runs script with given id in a given context.
    */
    public jpuppeteer.cdp.cdp.entity.runtime.RunScriptResponse runScript(jpuppeteer.cdp.cdp.entity.runtime.RunScriptRequest request, int timeout) throws Exception {
        return session.send("Runtime.runScript", request, jpuppeteer.cdp.cdp.entity.runtime.RunScriptResponse.class, timeout);
    }


    /**
    * Enables or disables async call stacks tracking.
    */
    public void setAsyncCallStackDepth(jpuppeteer.cdp.cdp.entity.runtime.SetAsyncCallStackDepthRequest request, int timeout) throws Exception {
        session.send("Runtime.setAsyncCallStackDepth", request, timeout);
    }


    /**
    */
    public void setCustomObjectFormatterEnabled(jpuppeteer.cdp.cdp.entity.runtime.SetCustomObjectFormatterEnabledRequest request, int timeout) throws Exception {
        session.send("Runtime.setCustomObjectFormatterEnabled", request, timeout);
    }


    /**
    */
    public void setMaxCallStackSizeToCapture(jpuppeteer.cdp.cdp.entity.runtime.SetMaxCallStackSizeToCaptureRequest request, int timeout) throws Exception {
        session.send("Runtime.setMaxCallStackSizeToCapture", request, timeout);
    }


    /**
    * Terminate current or next JavaScript execution. Will cancel the termination when the outer-most script execution ends.
    */
    public void terminateExecution(int timeout) throws Exception {
        session.send("Runtime.terminateExecution", null, timeout);
    }


    /**
    * If executionContextId is empty, adds binding with the given name on the global objects of all inspected contexts, including those created later, bindings survive reloads. If executionContextId is specified, adds binding only on global object of given execution context. Binding function takes exactly one argument, this argument should be string, in case of any other input, function throws an exception. Each binding function call produces Runtime.bindingCalled notification.
    */
    public void addBinding(jpuppeteer.cdp.cdp.entity.runtime.AddBindingRequest request, int timeout) throws Exception {
        session.send("Runtime.addBinding", request, timeout);
    }


    /**
    * This method does not remove binding function from global object but unsubscribes current runtime agent from Runtime.bindingCalled notifications.
    */
    public void removeBinding(jpuppeteer.cdp.cdp.entity.runtime.RemoveBindingRequest request, int timeout) throws Exception {
        session.send("Runtime.removeBinding", request, timeout);
    }

}