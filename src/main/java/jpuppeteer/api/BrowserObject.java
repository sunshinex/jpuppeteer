package jpuppeteer.api;

import io.netty.util.concurrent.Future;

public interface BrowserObject {

    String objectId();

    Isolate isolate();

    default Future<BrowserObject> call(String declaration, Object... args) {
        return isolate().call(declaration, objectId(), args);
    }

    default <R> Future<R> call(String declaration, Class<R> clazz, Object... args) {
        return isolate().call(declaration, objectId(), clazz, args);
    }

    Future<BrowserObject[]> getProperties();

    Future<BrowserObject> getProperty(String name);

    Future release();

}
