package jpuppeteer.chrome;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import jpuppeteer.api.BrowserObject;
import jpuppeteer.api.Isolate;
import jpuppeteer.cdp.client.domain.Runtime;
import jpuppeteer.cdp.client.entity.runtime.GetPropertiesRequest;
import jpuppeteer.cdp.client.entity.runtime.ReleaseObjectRequest;
import jpuppeteer.util.IsolateUtil;
import jpuppeteer.util.SeriesFuture;

public class ChromeObject implements BrowserObject {

    private final Isolate isolate;

    private final Runtime runtime;

    private final String objectId;

    private final EventExecutor executor;

    public ChromeObject(Isolate isolate, Runtime runtime, String objectId, EventExecutor executor) {
        this.isolate = isolate;
        this.runtime = runtime;
        this.objectId = objectId;
        this.executor = executor;
    }

    @Override
    public String objectId() {
        return objectId;
    }

    @Override
    public Isolate isolate() {
        return isolate;
    }

    @Override
    public Future<BrowserObject[]> getProperties() {
        return SeriesFuture
                .wrap(runtime.getProperties(new GetPropertiesRequest(objectId, true, false, false)))
                .sync(o -> {
                    IsolateUtil.checkException(o.exceptionDetails);
                    BrowserObject[] objects = new BrowserObject[o.result.size()];
                    for(int i=0; i<o.result.size(); i++) {
                        objects[i] = new ChromeObject(isolate, runtime, o.result.get(i).value.objectId, executor);
                    }
                    return objects;
                });
    }

    @Override
    public Future<BrowserObject> getProperty(String name) {
        return isolate.call("function(name){return this[name]}", objectId, false, name);
    }

    @Override
    public Future release() {
        ReleaseObjectRequest request = new ReleaseObjectRequest(objectId);
        return runtime.releaseObject(request);
    }
}
