package jpuppeteer.api;

import com.fasterxml.jackson.databind.JavaType;
import jpuppeteer.cdp.client.entity.runtime.CallFunctionOnRequest;
import jpuppeteer.cdp.client.entity.runtime.EvaluateRequest;
import jpuppeteer.util.XFuture;

public interface Isolate {

    String name();

    Frame frame();

    XFuture<BrowserObject> eval(EvaluateRequest request);

    <R> XFuture<R> eval(EvaluateRequest request, Class<R> clazz);

    <R> XFuture<R> eval(EvaluateRequest request, JavaType type);

    default XFuture<BrowserObject> eval(String expression) {
        return eval(expression, (Integer) null);
    }

    XFuture<BrowserObject> eval(String expression, Integer timeout);

    <R> XFuture<R> eval(String expression, Integer timeout, Class<R> clazz);

    <R> XFuture<R> eval(String expression, Integer timeout, JavaType type);

    default <R> XFuture<R> eval(String expression, Class<R> clazz) {
        return eval(expression, null, clazz);
    }

    default <R> XFuture<R> eval(String expression, JavaType type) {
        return eval(expression, null, type);
    }

    XFuture<BrowserObject> call(CallFunctionOnRequest request);

    <R> XFuture<R> call(CallFunctionOnRequest request, Class<R> clazz);

    <R> XFuture<R> call(CallFunctionOnRequest request, JavaType type);

    XFuture<BrowserObject> call(String declaration, String objectId, Object... args);

    <R> XFuture<R> call(String declaration, String objectId, Class<R> clazz, Object... args);

    <R> XFuture<R> call(String declaration, String objectId, JavaType type, Object... args);

    XFuture<BrowserObject> call(String declaration, Object... args);

    <R> XFuture<R> call(String declaration, Class<R> clazz, Object... args);

    <R> XFuture<R> call(String declaration, JavaType type, Object... args);

    XFuture<?> addBinding(String bindingName, BindingFunction function);

    XFuture<?> removeBinding(String bindingName);

}
