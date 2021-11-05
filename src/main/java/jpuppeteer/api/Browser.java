package jpuppeteer.api;

import io.netty.util.concurrent.Future;
import jpuppeteer.cdp.client.constant.storage.StorageType;
import jpuppeteer.cdp.client.entity.browser.GetVersionResponse;
import jpuppeteer.cdp.client.entity.target.CreateBrowserContextRequest;

import java.net.URI;

public interface Browser {

    URI uri();

    Future<GetVersionResponse> version();

    Future<BrowserContext> createContext(CreateBrowserContextRequest request);

    default Future<BrowserContext> createContext(String proxyServer, String proxyBypassList) {
        return createContext(new CreateBrowserContextRequest(false, proxyServer, proxyBypassList));
    }

    default Future<BrowserContext> createContext(String proxyServer) {
        return createContext(new CreateBrowserContextRequest(false, proxyServer, null));
    }

    default Future<BrowserContext> createContext() {
        return createContext(null, null);
    }

    BrowserContext defaultContext();

    BrowserContext[] browserContexts();

    Future clearData(String origin, StorageType... storageTypes);

    default Future clearData(String origin) {
        return clearData(origin, StorageType.ALL);
    }

    void disconnect();

    void close();

}
