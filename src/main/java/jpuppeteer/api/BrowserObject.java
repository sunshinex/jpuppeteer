package jpuppeteer.api;

import com.fasterxml.jackson.databind.JavaType;
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

    default <R> XFuture<R> call(String declaration, JavaType type, Object... args) {
        return isolate().call(declaration, objectId(), type, args);
    }

    XFuture<BrowserObject[]> getProperties();

    XFuture<?> setProperty(String name, Object value);

    XFuture<BrowserObject> getProperty(String name);

    <R> XFuture<R> getProperty(String name, Class<R> clazz);

    XFuture<?> release();

}
