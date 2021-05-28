package jpuppeteer.cdp.client.domain;

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
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.runtime.AwaitPromiseResponse> awaitPromise(jpuppeteer.cdp.client.entity.runtime.AwaitPromiseRequest request) {
        return session.send("Runtime.awaitPromise", request, jpuppeteer.cdp.client.entity.runtime.AwaitPromiseResponse.class);
    }


    /**
    * Calls function with given declaration on the given object. Object group of the result is inherited from the target object.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.runtime.CallFunctionOnResponse> callFunctionOn(jpuppeteer.cdp.client.entity.runtime.CallFunctionOnRequest request) {
        return session.send("Runtime.callFunctionOn", request, jpuppeteer.cdp.client.entity.runtime.CallFunctionOnResponse.class);
    }


    /**
    * Compiles expression.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.runtime.CompileScriptResponse> compileScript(jpuppeteer.cdp.client.entity.runtime.CompileScriptRequest request) {
        return session.send("Runtime.compileScript", request, jpuppeteer.cdp.client.entity.runtime.CompileScriptResponse.class);
    }


    /**
    * Disables reporting of execution contexts creation.
    */
    public io.netty.util.concurrent.Future disable() {
        return session.send("Runtime.disable", null);
    }


    /**
    * Discards collected exceptions and console API calls.
    */
    public io.netty.util.concurrent.Future discardConsoleEntries() {
        return session.send("Runtime.discardConsoleEntries", null);
    }


    /**
    * Enables reporting of execution contexts creation by means of `executionContextCreated` event. When the reporting gets enabled the event will be sent immediately for each existing execution context.
    */
    public io.netty.util.concurrent.Future enable() {
        return session.send("Runtime.enable", null);
    }


    /**
    * Evaluates expression on global object.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.runtime.EvaluateResponse> evaluate(jpuppeteer.cdp.client.entity.runtime.EvaluateRequest request) {
        return session.send("Runtime.evaluate", request, jpuppeteer.cdp.client.entity.runtime.EvaluateResponse.class);
    }


    /**
    * Returns the isolate id.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.runtime.GetIsolateIdResponse> getIsolateId() {
        return session.send("Runtime.getIsolateId", null, jpuppeteer.cdp.client.entity.runtime.GetIsolateIdResponse.class);
    }


    /**
    * Returns the JavaScript heap usage. It is the total usage of the corresponding isolate not scoped to a particular Runtime.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.runtime.GetHeapUsageResponse> getHeapUsage() {
        return session.send("Runtime.getHeapUsage", null, jpuppeteer.cdp.client.entity.runtime.GetHeapUsageResponse.class);
    }


    /**
    * Returns properties of a given object. Object group of the result is inherited from the target object.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.runtime.GetPropertiesResponse> getProperties(jpuppeteer.cdp.client.entity.runtime.GetPropertiesRequest request) {
        return session.send("Runtime.getProperties", request, jpuppeteer.cdp.client.entity.runtime.GetPropertiesResponse.class);
    }


    /**
    * Returns all let, const and class variables from global scope.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.runtime.GlobalLexicalScopeNamesResponse> globalLexicalScopeNames(jpuppeteer.cdp.client.entity.runtime.GlobalLexicalScopeNamesRequest request) {
        return session.send("Runtime.globalLexicalScopeNames", request, jpuppeteer.cdp.client.entity.runtime.GlobalLexicalScopeNamesResponse.class);
    }


    /**
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.runtime.QueryObjectsResponse> queryObjects(jpuppeteer.cdp.client.entity.runtime.QueryObjectsRequest request) {
        return session.send("Runtime.queryObjects", request, jpuppeteer.cdp.client.entity.runtime.QueryObjectsResponse.class);
    }


    /**
    * Releases remote object with given id.
    */
    public io.netty.util.concurrent.Future releaseObject(jpuppeteer.cdp.client.entity.runtime.ReleaseObjectRequest request) {
        return session.send("Runtime.releaseObject", request);
    }


    /**
    * Releases all remote objects that belong to a given group.
    */
    public io.netty.util.concurrent.Future releaseObjectGroup(jpuppeteer.cdp.client.entity.runtime.ReleaseObjectGroupRequest request) {
        return session.send("Runtime.releaseObjectGroup", request);
    }


    /**
    * Tells inspected instance to run if it was waiting for debugger to attach.
    */
    public io.netty.util.concurrent.Future runIfWaitingForDebugger() {
        return session.send("Runtime.runIfWaitingForDebugger", null);
    }


    /**
    * Runs script with given id in a given context.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.runtime.RunScriptResponse> runScript(jpuppeteer.cdp.client.entity.runtime.RunScriptRequest request) {
        return session.send("Runtime.runScript", request, jpuppeteer.cdp.client.entity.runtime.RunScriptResponse.class);
    }


    /**
    * Enables or disables async call stacks tracking.
    */
    public io.netty.util.concurrent.Future setAsyncCallStackDepth(jpuppeteer.cdp.client.entity.runtime.SetAsyncCallStackDepthRequest request) {
        return session.send("Runtime.setAsyncCallStackDepth", request);
    }


    /**
    * experimental
    */
    public io.netty.util.concurrent.Future setCustomObjectFormatterEnabled(jpuppeteer.cdp.client.entity.runtime.SetCustomObjectFormatterEnabledRequest request) {
        return session.send("Runtime.setCustomObjectFormatterEnabled", request);
    }


    /**
    * experimental
    */
    public io.netty.util.concurrent.Future setMaxCallStackSizeToCapture(jpuppeteer.cdp.client.entity.runtime.SetMaxCallStackSizeToCaptureRequest request) {
        return session.send("Runtime.setMaxCallStackSizeToCapture", request);
    }


    /**
    * Terminate current or next JavaScript execution. Will cancel the termination when the outer-most script execution ends.
    * experimental
    */
    public io.netty.util.concurrent.Future terminateExecution() {
        return session.send("Runtime.terminateExecution", null);
    }


    /**
    * If executionContextId is empty, adds binding with the given name on the global objects of all inspected contexts, including those created later, bindings survive reloads. Binding function takes exactly one argument, this argument should be string, in case of any other input, function throws an exception. Each binding function call produces Runtime.bindingCalled notification.
    * experimental
    */
    public io.netty.util.concurrent.Future addBinding(jpuppeteer.cdp.client.entity.runtime.AddBindingRequest request) {
        return session.send("Runtime.addBinding", request);
    }


    /**
    * This method does not remove binding function from global object but unsubscribes current runtime agent from Runtime.bindingCalled notifications.
    * experimental
    */
    public io.netty.util.concurrent.Future removeBinding(jpuppeteer.cdp.client.entity.runtime.RemoveBindingRequest request) {
        return session.send("Runtime.removeBinding", request);
    }

}