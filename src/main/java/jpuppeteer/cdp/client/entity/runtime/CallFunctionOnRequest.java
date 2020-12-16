package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class CallFunctionOnRequest {

    /**
    * Declaration of the function to call.
    */
    public final String functionDeclaration;

    /**
    * Identifier of the object to call function on. Either objectId or executionContextId should be specified.
    */
    public final String objectId;

    /**
    * Call arguments. All call arguments must belong to the same JavaScript world as the target object.
    */
    public final java.util.List<CallArgument> arguments;

    /**
    * In silent mode exceptions thrown during evaluation are not reported and do not pause execution. Overrides `setPauseOnException` state.
    */
    public final Boolean silent;

    /**
    * Whether the result is expected to be a JSON object which should be sent by value.
    */
    public final Boolean returnByValue;

    /**
    * Whether preview should be generated for the result.
    */
    public final Boolean generatePreview;

    /**
    * Whether execution should be treated as initiated by user in the UI.
    */
    public final Boolean userGesture;

    /**
    * Whether execution should `await` for resulting value and return once awaited promise is resolved.
    */
    public final Boolean awaitPromise;

    /**
    * Specifies execution context which global object will be used to call function on. Either executionContextId or objectId should be specified.
    */
    public final Integer executionContextId;

    /**
    * Symbolic group name that can be used to release multiple objects. If objectGroup is not specified and objectId is, objectGroup will be inherited from object.
    */
    public final String objectGroup;

    public CallFunctionOnRequest(String functionDeclaration, String objectId, java.util.List<CallArgument> arguments, Boolean silent, Boolean returnByValue, Boolean generatePreview, Boolean userGesture, Boolean awaitPromise, Integer executionContextId, String objectGroup) {
        this.functionDeclaration = functionDeclaration;
        this.objectId = objectId;
        this.arguments = arguments;
        this.silent = silent;
        this.returnByValue = returnByValue;
        this.generatePreview = generatePreview;
        this.userGesture = userGesture;
        this.awaitPromise = awaitPromise;
        this.executionContextId = executionContextId;
        this.objectGroup = objectGroup;
    }

    public CallFunctionOnRequest(String functionDeclaration) {
        this.functionDeclaration = functionDeclaration;
        this.objectId = null;
        this.arguments = null;
        this.silent = null;
        this.returnByValue = null;
        this.generatePreview = null;
        this.userGesture = null;
        this.awaitPromise = null;
        this.executionContextId = null;
        this.objectGroup = null;
    }

}