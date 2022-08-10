package jpuppeteer.api;

import jpuppeteer.cdp.client.entity.runtime.CallFunctionOnRequest;
import jpuppeteer.cdp.client.entity.runtime.EvaluateRequest;
import jpuppeteer.util.XFuture;

public interface Isolate {

    String name();

    Frame frame();

    XFuture<BrowserObject> eval(EvaluateRequest request);

    <R> XFuture<R> eval(EvaluateRequest request, Class<R> clazz);

    default XFuture<BrowserObject> eval(String expression) {
        return eval(expression, (Integer) null);
    }

    XFuture<BrowserObject> eval(String expression, Integer timeout);

    <R> XFuture<R> eval(String expression, Integer timeout, Class<R> clazz);

    default <R> XFuture<R> eval(String expression, Class<R> clazz) {
        return eval(expression, null, clazz);
    }

    XFuture<BrowserObject> call(CallFunctionOnRequest request);

    <R> XFuture<R> call(CallFunctionOnRequest request, Class<R> clazz);

    XFuture<BrowserObject> call(String declaration, String objectId, Object... args);

    <R> XFuture<R> call(String declaration, String objectId, Class<R> clazz, Object... args);

    XFuture<BrowserObject> call(String declaration, Object... args);

    <R> XFuture<R> call(String declaration, Class<R> clazz, Object... args);

    XFuture<?> addBinding(String bindingName, BindingFunction function);

    XFuture<?> removeBinding(String bindingName);

}
