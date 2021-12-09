package jpuppeteer.chrome;

import io.netty.util.concurrent.Future;
import jpuppeteer.api.BindingFunction;
import jpuppeteer.api.BrowserObject;
import jpuppeteer.api.Frame;
import jpuppeteer.api.Isolate;
import jpuppeteer.cdp.client.constant.runtime.RemoteObjectSubtype;
import jpuppeteer.cdp.client.constant.runtime.RemoteObjectType;
import jpuppeteer.cdp.client.domain.Runtime;
import jpuppeteer.cdp.client.entity.runtime.CallFunctionOnRequest;
import jpuppeteer.cdp.client.entity.runtime.EvaluateRequest;
import jpuppeteer.util.IsolateUtil;
import jpuppeteer.util.SeriesPromise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChromeIsolate implements Isolate {

    private static final Logger logger = LoggerFactory.getLogger(ChromeIsolate.class);

    private final ChromeFrame frame;

    private final Integer isolateId;

    private final String uniqueId;

    private final String name;

    public ChromeIsolate(ChromeFrame frame, Integer isolateId, String name, String uniqueId) {
        this.frame = frame;
        this.isolateId = isolateId;
        this.name = name;
        this.uniqueId = uniqueId;
    }

    private static boolean checkNull(RemoteObjectType type, RemoteObjectSubtype subType) {
        if (
                RemoteObjectType.UNDEFINED.equals(type) || (
                        RemoteObjectType.OBJECT.equals(type) &&
                                RemoteObjectSubtype.NULL.equals(subType)
                )
        ) {
            return true;
        } else {
            return false;
        }
    }

    protected Runtime runtime() {
        return frame.page().connection().runtime;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public Frame frame() {
        return this.frame;
    }

    @Override
    public Future<BrowserObject> eval(EvaluateRequest request) {
        return SeriesPromise
                .wrap(runtime().evaluate(request))
                .sync(o -> {
                    IsolateUtil.checkException(o.exceptionDetails);
                    if (checkNull(o.result.type, o.result.subtype)) {
                        return null;
                    }
                    return new ChromeObject(ChromeIsolate.this, o.result.objectId);
                });
    }

    @Override
    public <R> Future<R> eval(EvaluateRequest request, Class<R> clazz) {
        return SeriesPromise
                .wrap(runtime().evaluate(request))
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
        return eval(IsolateUtil.buildEvaluateRequest(expression, isolateId, false, timeout, uniqueId));
    }

    @Override
    public <R> Future<R> eval(String expression, Integer timeout, Class<R> clazz) {
        return eval(IsolateUtil.buildEvaluateRequest(expression, isolateId, true, timeout, uniqueId), clazz);
    }

    @Override
    public Future<BrowserObject> call(CallFunctionOnRequest request) {
        return SeriesPromise
                .wrap(runtime().callFunctionOn(request))
                .sync(o -> {
                    IsolateUtil.checkException(o.exceptionDetails);
                    if (checkNull(o.result.type, o.result.subtype)) {
                        return null;
                    }
                    return new ChromeObject(this, o.result.objectId);
                });
    }

    @Override
    public <R> Future<R> call(CallFunctionOnRequest request, Class<R> clazz) {
        return SeriesPromise
                .wrap(runtime().callFunctionOn(request))
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
    public Future addBinding(String bindingName, BindingFunction function) {
        return frame.page().addBinding0(name, bindingName, function);
    }

    @Override
    public Future removeBinding(String bindingName) {
        return frame.page().removeBinding0(bindingName);
    }

    @Override
    public String toString() {
        return "ChromeIsolate:" + name;
    }
}
