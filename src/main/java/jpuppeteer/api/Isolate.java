package jpuppeteer.api;

import io.netty.util.concurrent.Future;
import jpuppeteer.cdp.client.entity.runtime.CallFunctionOnRequest;
import jpuppeteer.cdp.client.entity.runtime.EvaluateRequest;

public interface Isolate {

    Frame frame();

    Future<BrowserObject> eval(EvaluateRequest request);

    <R> Future<R> eval(EvaluateRequest request, Class<R> clazz);

    Future<BrowserObject> eval(String expression, Integer timeout);

    <R> Future<R> eval(String expression, Integer timeout, Class<R> clazz);

    Future<BrowserObject> call(CallFunctionOnRequest request);

    <R> Future<R> call(CallFunctionOnRequest request, Class<R> clazz);

    Future<BrowserObject> call(String declaration, String objectId, Object... args);

    <R> Future<R> call(String declaration, String objectId, Class<R> clazz, Object... args);

}
