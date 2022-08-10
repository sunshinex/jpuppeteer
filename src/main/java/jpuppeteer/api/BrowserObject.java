package jpuppeteer.api;

import jpuppeteer.util.XFuture;

public interface BrowserObject {

    String objectId();

    Isolate isolate();

    default XFuture<BrowserObject> call(String declaration, Object... args) {
        return isolate().call(declaration, objectId(), args);
    }

    default <R> XFuture<R> call(String declaration, Class<R> clazz, Object... args) {
        return isolate().call(declaration, objectId(), clazz, args);
    }

    XFuture<BrowserObject[]> getProperties();

    XFuture<BrowserObject> getProperty(String name);

    XFuture<?> release();

}
