package jpuppeteer.api;

import io.netty.util.concurrent.Future;
import jpuppeteer.api.event.EventEmitter;
import jpuppeteer.cdp.CDPEvent;
import jpuppeteer.cdp.client.constant.storage.StorageType;
import jpuppeteer.cdp.client.entity.browser.GetVersionResponse;

public interface Browser extends EventEmitter<CDPEvent> {

    String name();

    Future<GetVersionResponse> version();

    BrowserContext[] browserContexts();

    Future<BrowserContext> createContext();

    BrowserContext defaultContext();

    Future clearData(String origin, StorageType... storageTypes);

    default Future clearData(String origin) {
        return clearData(origin, StorageType.ALL);
    }

    Future close();

}
