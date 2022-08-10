package jpuppeteer.api;

import jpuppeteer.api.event.EventEmitter;
import jpuppeteer.api.event.browser.BrowserEvent;
import jpuppeteer.cdp.client.constant.storage.StorageType;
import jpuppeteer.cdp.client.entity.browser.GetVersionResponse;
import jpuppeteer.cdp.client.entity.target.CreateBrowserContextRequest;
import jpuppeteer.util.XFuture;

import java.net.URI;

public interface Browser extends BrowserContext, EventEmitter<BrowserEvent> {

    URI uri();

    XFuture<GetVersionResponse> version();

    XFuture<BrowserContext> createContext(CreateBrowserContextRequest request);

    default XFuture<BrowserContext> createContext(String proxyServer, String proxyBypassList) {
        return createContext(new CreateBrowserContextRequest(false, proxyServer, proxyBypassList));
    }

    default XFuture<BrowserContext> createContext(String proxyServer) {
        return createContext(new CreateBrowserContextRequest(false, proxyServer, null));
    }

    default XFuture<BrowserContext> createContext() {
        return createContext(null, null);
    }

    XFuture<?> clearData(String origin, StorageType... storageTypes);

    default XFuture<?> clearData(String origin) {
        return clearData(origin, StorageType.ALL);
    }

    void disconnect();

    void close();

}
