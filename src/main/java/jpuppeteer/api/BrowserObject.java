package jpuppeteer.api;

import io.netty.util.concurrent.Future;

public interface BrowserObject {

    String objectId();

    Isolate isolate();

    Future<BrowserObject[]> getProperties();

    Future<BrowserObject> getProperty(String name);

    Future release();

}
