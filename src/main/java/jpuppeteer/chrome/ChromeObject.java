package jpuppeteer.chrome;

import io.netty.util.concurrent.Future;
import jpuppeteer.api.BrowserObject;
import jpuppeteer.api.Isolate;
import jpuppeteer.cdp.client.domain.Runtime;
import jpuppeteer.cdp.client.entity.runtime.GetPropertiesRequest;
import jpuppeteer.cdp.client.entity.runtime.ReleaseObjectRequest;
import jpuppeteer.util.IsolateUtil;
import jpuppeteer.util.SeriesPromise;

public class ChromeObject implements BrowserObject {

    private final ChromeIsolate isolate;

    private final String objectId;

    public ChromeObject(ChromeIsolate isolate, String objectId) {
        this.isolate = isolate;
        this.objectId = objectId;
    }

    protected Runtime runtime() {
        return isolate.runtime();
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
        return SeriesPromise
                .wrap(runtime().getProperties(new GetPropertiesRequest(objectId, true, false, false)))
                .sync(o -> {
                    IsolateUtil.checkException(o.exceptionDetails);
                    BrowserObject[] objects = new BrowserObject[o.result.size()];
                    for(int i=0; i<o.result.size(); i++) {
                        objects[i] = new ChromeObject(isolate, o.result.get(i).value.objectId);
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
        return runtime().releaseObject(request);
    }
}
