package jpuppeteer.chrome;

import jpuppeteer.api.BrowserObject;
import jpuppeteer.api.Isolate;
import jpuppeteer.cdp.client.domain.Runtime;
import jpuppeteer.cdp.client.entity.runtime.GetPropertiesRequest;
import jpuppeteer.cdp.client.entity.runtime.ReleaseObjectRequest;
import jpuppeteer.util.IsolateUtil;
import jpuppeteer.util.XFuture;

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
    public XFuture<BrowserObject[]> getProperties() {
        return runtime().getProperties(new GetPropertiesRequest(objectId, true, false, false))
                .sync(o -> {
                    IsolateUtil.checkException(o.getExceptionDetails());
                    BrowserObject[] objects = new BrowserObject[o.getResult().size()];
                    for(int i = 0; i< o.getResult().size(); i++) {
                        objects[i] = new ChromeObject(isolate, o.getResult().get(i).getValue().getObjectId());
                    }
                    return objects;
                });
    }

    @Override
    public XFuture<?> setProperty(String name, Object value) {
        return call("function(name, value){this[name] = value;}", name, value);
    }

    @Override
    public XFuture<BrowserObject> getProperty(String name) {
        return call("function(name){return this[name];}", name);
    }

    @Override
    public <R> XFuture<R> getProperty(String name, Class<R> clazz) {
        return call("function(name){return this[name];}", clazz, name);
    }

    @Override
    public XFuture<?> release() {
        ReleaseObjectRequest request = new ReleaseObjectRequest(objectId);
        return runtime().releaseObject(request);
    }
}
