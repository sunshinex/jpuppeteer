package jpuppeteer.chrome;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import jpuppeteer.api.BrowserObject;
import jpuppeteer.api.Frame;
import jpuppeteer.api.Isolate;
import jpuppeteer.cdp.client.constant.runtime.RemoteObjectSubtype;
import jpuppeteer.cdp.client.constant.runtime.RemoteObjectType;
import jpuppeteer.cdp.client.domain.Runtime;
import jpuppeteer.cdp.client.entity.runtime.CallFunctionOnRequest;
import jpuppeteer.cdp.client.entity.runtime.EvaluateRequest;
import jpuppeteer.util.IsolateUtil;
import jpuppeteer.util.SeriesFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChromeIsolate implements Isolate {

    private static final Logger logger = LoggerFactory.getLogger(ChromeIsolate.class);

    private final Runtime runtime;

    private final Integer isolateId;

    private final String name;

    private final Frame frame;

    private final EventExecutor executor;

    public ChromeIsolate(Runtime runtime, Integer isolateId, String name, Frame frame, EventExecutor executor) {
        this.runtime = runtime;
        this.isolateId = isolateId;
        this.name = name;
        this.frame = frame;
        this.executor = executor;
    }

    private static boolean checkNull(String type, String subType) {
        RemoteObjectType objectType = RemoteObjectType.findByValue(type);
        RemoteObjectSubtype subObjectType = RemoteObjectSubtype.findByValue(subType);
        if (
                RemoteObjectType.UNDEFINED.equals(objectType) || (
                        RemoteObjectType.OBJECT.equals(objectType) &&
                                RemoteObjectSubtype.NULL.equals(subObjectType)
                )
        ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Frame frame() {
        return this.frame;
    }

    @Override
    public Future<BrowserObject> eval(EvaluateRequest request) {
        return SeriesFuture
                .wrap(runtime.evaluate(request))
                .sync(o -> {
                    IsolateUtil.checkException(o.exceptionDetails);
                    if (checkNull(o.result.type, o.result.subtype)) {
                        return null;
                    }
                    return new ChromeObject(ChromeIsolate.this, runtime, o.result.objectId, executor);
                });
    }

    @Override
    public <R> Future<R> eval(EvaluateRequest request, Class<R> clazz) {
        return SeriesFuture
                .wrap(runtime.evaluate(request))
                .sync(o -> {
                    IsolateUtil.checkException(o.exceptionDetails);
                    if (checkNull(o.result.type, o.result.subtype)) {
                        return null;
                    }
                    return IsolateUtil.remoteObjectToValue(o.result, clazz);
                });
    }

    @Override
    public Future<BrowserObject> eval(String expression, Integer timeout) {
        return eval(IsolateUtil.buildEvaluateRequest(expression, isolateId, false, timeout));
    }

    @Override
    public <R> Future<R> eval(String expression, Integer timeout, Class<R> clazz) {
        return eval(IsolateUtil.buildEvaluateRequest(expression, isolateId, true, timeout), clazz);
    }

    @Override
    public Future<BrowserObject> call(CallFunctionOnRequest request) {
        return SeriesFuture
                .wrap(runtime.callFunctionOn(request))
                .sync(o -> {
                    IsolateUtil.checkException(o.exceptionDetails);
                    if (checkNull(o.result.type, o.result.subtype)) {
                        return null;
                    }
                    return new ChromeObject(this, runtime, o.result.objectId, executor);
                });
    }

    @Override
    public <R> Future<R> call(CallFunctionOnRequest request, Class<R> clazz) {
        return SeriesFuture
                .wrap(runtime.callFunctionOn(request))
                .sync(o -> {
                    IsolateUtil.checkException(o.exceptionDetails);
                    if (checkNull(o.result.type, o.result.subtype)) {
                        return null;
                    }
                    return IsolateUtil.remoteObjectToValue(o.result, clazz);
                });
    }

    @Override
    public Future<BrowserObject> call(String declaration, String objectId, Object... args) {
        if (objectId == null) {
            throw new IllegalArgumentException("objectId required");
        }
        return call(IsolateUtil.buildCallRequest(declaration, objectId, false, null, args));
    }

    @Override
    public <R> Future<R> call(String declaration, String objectId, Class<R> clazz, Object... args) {
        if (objectId == null) {
            throw new IllegalArgumentException("objectId required");
        }
        return call(IsolateUtil.buildCallRequest(declaration, objectId, true, null, args), clazz);
    }

    @Override
    public Future<BrowserObject> call(String declaration, Object... args) {
        return call(IsolateUtil.buildCallRequest(declaration, null, false, isolateId, args));
    }

    @Override
    public <R> Future<R> call(String declaration, Class<R> clazz, Object... args) {
        return call(IsolateUtil.buildCallRequest(declaration, null, true, isolateId, args), clazz);
    }

    @Override
    public String toString() {
        return name;
    }
}
